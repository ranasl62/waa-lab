package miu.edu.lab.controller.v1;

import miu.edu.lab.domain.v1.PostEntity;
import miu.edu.lab.dto.v1.PostDto;
import miu.edu.lab.request.v1.CreatePostRequest;
import miu.edu.lab.response.Response;
import miu.edu.lab.service.v1.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public ResponseEntity<List<PostDto>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<PostDto>> getById(@PathVariable long id) {
        PostDto post = postService.getById(id);
        if (post != null) {
            Response<PostDto> response = new Response<>(true, "Post retrieved successfully", post);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response<PostDto> response = new Response<>(false, "Post not found", post);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    @PostMapping
    public ResponseEntity<Response<Void>> create(@RequestBody CreatePostRequest createPostRequest) {
        postService.create(createPostRequest.getUserId(), createPostRequest.getPostEntity());
        Response<Void> response = new Response<>(true, "Post retrieved successfully", null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Void>> update(@PathVariable long id, @RequestBody PostEntity postEntity) {
        postService.update(id, postEntity);
        Response<Void> response = new Response<>(true, "Post updated successfully", null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@PathVariable long id) {
        postService.delete(id);
        Response<Void> response = new Response<>(true, "Post deleted successfully", null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
