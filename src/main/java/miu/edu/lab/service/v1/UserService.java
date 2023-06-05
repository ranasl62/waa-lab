package miu.edu.lab.service.v1;

import miu.edu.lab.domain.v1.UserEntity;
import miu.edu.lab.dto.v1.CommentDto;
import miu.edu.lab.dto.v1.PostDto;
import miu.edu.lab.dto.v1.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();

    public UserDto getById(long id);

    public void create(UserEntity p);

    public void delete(long id);

    public void update(long id, UserEntity p);

    List<PostDto> getPostByUserId(long id);


    List<UserDto> findByPostsSizeGreaterThan(Long postSize);

    CommentDto getComment(long userId, long postId, long commentId);
}
