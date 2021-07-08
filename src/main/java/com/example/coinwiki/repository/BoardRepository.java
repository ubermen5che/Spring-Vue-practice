package com.example.coinwiki.repository;

import com.example.coinwiki.domain.Post;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Post savePost(Post post);
    Optional<Post> findByNum(Long id);
    List<Post> findAll();
}
