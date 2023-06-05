package miu.edu.lab.controller.v1;

import miu.edu.lab.domain.v1.Comment;
import miu.edu.lab.dto.v1.CommentDto;
import miu.edu.lab.request.v1.CreateCommentRequest;
import miu.edu.lab.response.Response;
import miu.edu.lab.service.v1.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping
    public ResponseEntity<List<CommentDto>> findAll() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<CommentDto>> getById(@PathVariable long id) {
        CommentDto comment = commentService.getById(id);
        if (comment != null) {
            Response<CommentDto> response = new Response<>(true, "Comment retrieved successfully", comment);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Response<CommentDto> response = new Response<>(false, "Comment not found", comment);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Response<Void>> create(@RequestBody CreateCommentRequest createCommentRequest) {
        commentService.create(createCommentRequest.getPostId(), createCommentRequest.getComment());
        Response<Void> response = new Response<>(true, "Comment saved successfully", null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Void>> update(@PathVariable long id, @RequestBody Comment comment) {
        commentService.update(id, comment);
        Response<Void> response = new Response<>(true, "Comment updated successfully", null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> delete(@PathVariable long id) {
        commentService.delete(id);
        Response<Void> response = new Response<>(true, "Comment deleted successfully", null);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
