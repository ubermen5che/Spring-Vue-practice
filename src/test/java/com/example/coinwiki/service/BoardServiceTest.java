package com.example.coinwiki.service;

import com.example.coinwiki.domain.Member;
import com.example.coinwiki.domain.Post;
import com.example.coinwiki.repository.BoardRepository;
import com.example.coinwiki.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class BoardServiceTest {

    @Autowired
    BoardService boardService;
    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {
        //given
        Post post = new Post();
        post.setSubject("첫 글이다");
        post.setCont("무야호");


        //when
        Long saveId = boardService.savePost(post);

        //then
        Post findPost = boardService.findOne(saveId).get();
        Assertions.assertThat(post.getId()).isEqualTo(findPost.getId());
    }
}
