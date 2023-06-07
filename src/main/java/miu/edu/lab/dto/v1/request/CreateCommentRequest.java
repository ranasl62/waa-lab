package miu.edu.lab.request.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.lab.domain.v1.CommentEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCommentRequest {
    Long postId;
    CommentEntity comment;
}
