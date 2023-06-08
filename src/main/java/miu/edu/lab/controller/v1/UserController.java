package miu.edu.lab.controller.v1;

import miu.edu.lab.aspect.v1.annotation.ExecutionTime;
import miu.edu.lab.domain.v1.UserEntity;
import miu.edu.lab.dto.v1.CommentDto;
import miu.edu.lab.dto.v1.PostDto;
import miu.edu.lab.dto.v1.UserDto;
import miu.edu.lab.dto.v1.response.Response;
import miu.edu.lab.service.v1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService UserService) {
        this.userService = UserService;
    }


    @GetMapping
    public ResponseEntity<Response<List<UserDto>>> findAll() {
        Response<List<UserDto>> response = new Response<>(true, "User retrieved successfully", userService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public ResponseEntity<Response<UserDto>> getById(@PathVariable long id) {
        UserDto user = userService.getById(id);
        if (user != null) {
            Response<UserDto> response = new Response<>(true, "User retrieved successfully", user);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            Response<UserDto> response = new Response<>(true, "User retrieved fail", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Response<UserDto>> create(@RequestBody UserEntity userEntity) {
        userService.create(userEntity);
        Response<UserDto> response = new Response<>(true, "User created successfully", null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Long>> update(@PathVariable long id, @RequestBody UserEntity userEntity) {
        userService.update(id, userEntity);
        Response<Long> response = new Response<>(true, "User updated successfully", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Long>> delete(@PathVariable long id) {
        userService.delete(id);
        Response<Long> response = new Response<>(true, "User deleted successfully", id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<Response<List<PostDto>>> getPost(@PathVariable long id) {
        Response<List<PostDto>> response = new Response<>(true, "User posts retrieved successfully", userService.getPostByUserId(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/has-multiple-posts")
    public ResponseEntity<Response<List<UserDto>>> getPost() {
        Response<List<UserDto>> response = new Response<>(true, "User retrieved successfully who has multiple post", userService.findByPostsSizeGreaterThan((long) 2));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public ResponseEntity<Response<CommentDto>> getComment(
            @PathVariable long userId,
            @PathVariable long postId,
            @PathVariable long commentId
    ) {
        Response<CommentDto> response = new Response<>(true, "Comment retrieved successfully by user id and post id", userService.getComment(userId, postId, commentId));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
