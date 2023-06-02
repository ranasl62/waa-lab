package miu.edu.lab1.domain.v2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostV2 {
    long id;
    String title;
    String content;
    String author;
}
