package miu.edu.lab.dto.v2;

import lombok.Data;

@Data
public class PostDtoV2 {
    long id;
    String title;
    String author;
    String content;
}
