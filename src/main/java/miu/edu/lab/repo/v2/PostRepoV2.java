package miu.edu.lab.repo.v2;

import miu.edu.lab.domain.v2.PostV2;

import java.util.List;

public interface PostRepoV2 {

    public List<PostV2> getPostsByAuthor(String author);}
