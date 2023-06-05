package miu.edu.lab.service.v1;

import miu.edu.lab.domain.v1.CommentEntity;
import miu.edu.lab.domain.v1.PostEntity;
import miu.edu.lab.dto.v1.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();

    public PostDto getById(long id);

    public void create(Long user_id, PostEntity p);

    public void delete(long id);

    public void update(long id, PostEntity p);

    public void addPostByUserId(long id, PostEntity postEntity);

    void addCommentToPost(PostEntity postEntity, CommentEntity comment);
}
