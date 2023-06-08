package miu.edu.lab.service.v1.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.v1.CommentEntity;
import miu.edu.lab.domain.v1.PostEntity;
import miu.edu.lab.domain.v1.UserEntity;
import miu.edu.lab.dto.v1.PostDto;
import miu.edu.lab.service.v1.PostService;
import miu.edu.lab.utils.ListMapper;
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
    public void create(Long userId, PostEntity postEntity) {
        System.out.println(postEntity);
        Optional<UserEntity> user = userRepos.findById(userId);
        if (user.isPresent() && postEntity != null) {
            postEntity.setUserEntity(user.get());
            postRepo.save(postEntity);
        }

    }

    @Override
    public void delete(long id) {
        this.postRepo.delete(this.postRepo.findById(id).get());
    }

    @Override
    public void update(long id, PostEntity postEntity) {
        PostEntity existingPostEntity = postRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with ID: " + id));

        try {
            BeanUtils.copyProperties(existingPostEntity, postEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        postRepo.save(existingPostEntity);
    }

    @Override
    public void addPostByUserId(long id, PostEntity postEntity) {

    }

    public void addCommentToPost(PostEntity postEntity, CommentEntity comment) {
        postEntity.getComments().add(comment);
        postRepo.save(postEntity);
    }
}
