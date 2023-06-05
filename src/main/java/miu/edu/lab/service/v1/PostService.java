package miu.edu.lab.service.v1;

import miu.edu.lab.domain.v1.Comment;
import miu.edu.lab.domain.v1.Post;
import miu.edu.lab.dto.v1.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    public PostDto getById(long id);

    public void create(Long user_id, Post p);

    public void delete(long id);

    public void update(long id, Post p);

    public void addPostByUserId(long id, Post post);

    void addCommentToPost(Post post, Comment comment);
}
