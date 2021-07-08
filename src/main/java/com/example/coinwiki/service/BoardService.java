package com.example.coinwiki.service;

import com.example.coinwiki.domain.Post;
import com.example.coinwiki.repository.BoardRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Long savePost(Post post){
        boardRepository.savePost(post);
        return post.getId();
    }

    public Optional<Post> findOne(Long id){
        return boardRepository.findByNum(id);
    }

    public List<Post> findAll(){
        return boardRepository.findAll();
    }
}
