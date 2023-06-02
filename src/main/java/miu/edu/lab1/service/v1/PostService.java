package miu.edu.lab1.service.v1;

import miu.edu.lab1.domain.v1.Post;
import miu.edu.lab1.dto.v1.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    public PostDto getById(long id);

    public void create(Post p);

    public void delete(long id);

    public void update(long id, Post p);
}
