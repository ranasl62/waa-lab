package miu.edu.lab1.controller.v1;

import miu.edu.lab1.domain.v1.Post;
import miu.edu.lab1.dto.v1.PostDto;
import miu.edu.lab1.service.v1.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Post man collection https://documenter.getpostman.com/view/4759612/2s93mATzRV
 * replace {{base_url}} to host:port
 * replace {{api_version}} to v2 for version v2 api
 * */

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
    public ResponseEntity<PostDto> getById(@PathVariable long id) {
        PostDto post = postService.getById(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Post post) {
        postService.create(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Post post) {
        postService.update(id, post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
