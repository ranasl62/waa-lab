package miu.edu.lab.service.v1;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.v1.Comment;
import miu.edu.lab.domain.v1.Post;
import miu.edu.lab.domain.v1.User;
import miu.edu.lab.dto.v1.CommentDto;
import miu.edu.lab.dto.v1.PostDto;
import miu.edu.lab.dto.v1.UserDto;
import miu.edu.lab.helper.ListMapper;
import miu.edu.lab.repo.v1.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) listMapper.mapList(this.userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getById(long id) {
        return modelMapper.map(this.userRepo.getById(id), UserDto.class);
    }

    @Override
    public void create(User p) {
        this.userRepo.save(p);
    }

    @Override
    public void delete(long id) {
        this.userRepo.delete(this.userRepo.findById(id).get());
    }

    @Override
    public void update(long id, User user) {
        User existingUser = userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
        try {
            BeanUtils.copyProperties(existingUser, user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        userRepo.save(existingUser);
    }

    @Override
    public List<PostDto> getPostByUserId(long id) {
        this.userRepo.getById(id).getPosts().forEach(System.out::println);
        return (List<PostDto>) listMapper.mapList(this.userRepo.getById(id).getPosts(), new PostDto());
    }

    @Override
    public List<UserDto> findByPostsSizeGreaterThan(Long postSize) {
        return (List<UserDto>) listMapper.mapList(this.userRepo.findByPostsSizeGreaterThan(postSize), new UserDto());
    }

    public CommentDto getComment(long userId, long postId, long commentId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Post post = user.findPostById(postId);
            if (post != null) {
                Comment comment = post.findCommentById(commentId);
                if (comment != null) {
                    // Assuming CommentDto is a DTO class for Comment
                    return modelMapper.map(comment, CommentDto.class);
                }
            }
        }
        return null;
    }

}
