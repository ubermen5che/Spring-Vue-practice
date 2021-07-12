package com.example.coinwiki.repository;

import com.example.coinwiki.domain.PagingInfo;
import com.example.coinwiki.domain.Post;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Post savePost(Post post);
    Optional<Post> findByNum(Long id);
    List<Post> findAll();
    List<Post> paging(PagingInfo pi);
}
