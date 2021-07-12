package com.example.coinwiki.repository;

import com.example.coinwiki.domain.PagingInfo;
import com.example.coinwiki.domain.Post;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Post savePost(Post post);
    Post findByNum(Long id, String boardCode);
    List<Post> findAll();
    List<Post> paging(PagingInfo pi);
}
