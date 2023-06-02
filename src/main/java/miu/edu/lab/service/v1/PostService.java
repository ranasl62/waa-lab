package miu.edu.lab.service.v1;

import miu.edu.lab.domain.v1.Post;
import miu.edu.lab.dto.v1.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    public PostDto getById(long id);

    public void create(Post p);

    public void delete(long id);

    public void update(long id, Post p);
}
