package miu.edu.lab.request.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import miu.edu.lab.domain.v1.Post;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePostRequest {
    private Long userId;
    private Post post;
}
