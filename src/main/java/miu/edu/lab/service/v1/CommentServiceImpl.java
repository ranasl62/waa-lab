package miu.edu.lab.service.v1;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.v1.CommentEntity;
import miu.edu.lab.domain.v1.PostEntity;
import miu.edu.lab.dto.v1.CommentDto;
import miu.edu.lab.helper.ListMapper;
import miu.edu.lab.repo.v1.CommentRepo;
import miu.edu.lab.repo.v1.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @Override
    public List<CommentDto> findAll() {
        return (List<CommentDto>) listMapper.mapList(this.commentRepo.findAll(), new CommentDto());
    }

    @Override
    public CommentDto getById(long id) {
        return modelMapper.map(this.commentRepo.getById(id), CommentDto.class);
    }

    @Override
    public void create(Long postId, CommentEntity comment) {
        Optional<PostEntity> post = postRepo.findById(postId);
        if (post.isPresent()) {
            comment.setPostEntity(post.get());
            commentRepo.save(comment);
        }
    }

    @Override
    public void delete(long id) {
        this.commentRepo.delete(this.commentRepo.findById(id).get());
    }

    @Override
    public void update(long id, CommentEntity comment) {
        CommentEntity existingComment = commentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found with ID: " + id));

        try {
            BeanUtils.copyProperties(existingComment, comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        commentRepo.save(existingComment);
    }

    @Override
    public void addCommentByUserId(long id, CommentEntity comment) {

    }
}
