package miu.edu.lab.controller.v2;

import miu.edu.lab.dto.v2.PostDtoV2;
import miu.edu.lab.service.v2.PostServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/posts", headers = "X-API-Version=v2")
public class PostControllerV2 {
    private final PostServiceV2 postService;

    @Autowired
    public PostControllerV2(PostServiceV2 postService) {
        this.postService = postService;
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PostDtoV2>> getPostsByAuthor(@RequestParam("author") String author) {
        List<PostDtoV2> filteredPosts = postService.getPostsByAuthor(author);

        if (filteredPosts.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(filteredPosts);
        }
    }
}
