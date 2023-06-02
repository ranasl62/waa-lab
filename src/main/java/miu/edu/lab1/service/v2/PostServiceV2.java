package miu.edu.lab1.service.v2;

import miu.edu.lab1.dto.v2.PostDtoV2;
import java.util.List;

public interface PostServiceV2 {
    public List<PostDtoV2> getPostsByAuthor(String author);
}
