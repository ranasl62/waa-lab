package miu.edu.lab1.service.v1;

import miu.edu.lab1.domain.v1.User;
import miu.edu.lab1.dto.v1.PostDto;
import miu.edu.lab1.dto.v1.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> findAll();

    public UserDto getById(long id);

    public void create(User p);

    public void delete(long id);

    public void update(long id, User p);

    List<PostDto> getPostByUserId(long id);

    List<UserDto> getUsersWithMultiplePosts();
}
