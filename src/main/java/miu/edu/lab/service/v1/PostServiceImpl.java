package miu.edu.lab.service.v1;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.v1.Comment;
import miu.edu.lab.domain.v1.Post;
import miu.edu.lab.domain.v1.User;
import miu.edu.lab.dto.v1.PostDto;
import miu.edu.lab.helper.ListMapper;
import miu.edu.lab.repo.v1.PostRepo;
import miu.edu.lab.repo.v1.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final UserRepo userRepos;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapper.mapList(this.postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(this.postRepo.getById(id), PostDto.class);
    }

    @Override
    public void create(Long userId, Post post) {
        System.out.println(post);
        Optional<User> user = userRepos.findById(userId);
        if (user.isPresent() && post != null) {
            post.setUser(user.get());
            postRepo.save(post);
        }

    }

    @Override
    public void delete(long id) {
        this.postRepo.delete(this.postRepo.findById(id).get());
    }

    @Override
    public void update(long id, Post post) {
        Post existingPost = postRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with ID: " + id));

        try {
            BeanUtils.copyProperties(existingPost, post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        postRepo.save(existingPost);
    }

    @Override
    public void addPostByUserId(long id, Post post) {

    }

    public void addCommentToPost(Post post, Comment comment) {
        post.getComments().add(comment);
        postRepo.save(post);
    }
}
