package miu.edu.lab.request.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.lab.domain.v1.Comment;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCommentRequest {
    Long postId;
    Comment comment;
}
