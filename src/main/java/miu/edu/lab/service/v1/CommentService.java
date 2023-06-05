package miu.edu.lab.service.v1;

import miu.edu.lab.domain.v1.CommentEntity;
import miu.edu.lab.dto.v1.CommentDto;

import java.util.List;

public interface CommentService {
    public List<CommentDto> findAll();

    public CommentDto getById(long id);

    public void create(Long postId, CommentEntity comment);

    public void delete(long id);

    public void update(long id, CommentEntity p);
    public void addCommentByUserId(long id, CommentEntity post);
}
