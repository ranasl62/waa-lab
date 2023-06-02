package miu.edu.lab1.repo.v2;

import miu.edu.lab1.domain.v2.PostV2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImplV2 implements PostRepoV2 {
    private static List<PostV2> posts;
    private static long postId = 111;

    static {
        posts = new ArrayList<>();
        posts.add(new PostV2(111, "post title 1", "demo content 1", "john doe 1"));
        posts.add(new PostV2(222, "post title 2", "demo content 2", "john doe 1"));
        posts.add(new PostV2(333, "post title 2", "demo content 2", "john doe 2"));
        posts.add(new PostV2(444, "post title 3", "demo content 3", "john doe 3"));
    }

    @Override
    public List<PostV2> getPostsByAuthor(String author) {
        return posts.stream().filter(p -> p.getAuthor().equals(author)).toList();
    }
}
