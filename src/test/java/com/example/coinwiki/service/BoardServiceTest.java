package com.example.coinwiki.service;

import com.example.coinwiki.domain.Member;
import com.example.coinwiki.domain.PagingInfo;
import com.example.coinwiki.domain.Post;
import com.example.coinwiki.repository.BoardRepository;
import com.example.coinwiki.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Array;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@Commit
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
        post.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
        post.setType("admin");

        //when
        Long saveId = boardService.savePost(post);

        //then
        Post findPost = boardService.findOne(saveId).get();
        Assertions.assertThat(post.getId()).isEqualTo(findPost.getId());
    }

    @Test
    void findAll() {
        //given
        Post post1 = new Post();
        Post post2 = new Post();

        post1.setSubject("테스트1");
        post1.setCont("테스트111");
        boardService.savePost(post1);

        post2.setSubject("테스트2");
        post2.setCont("테스트222");
        boardService.savePost(post2);
        List<Long> postIdList = new ArrayList<>();
        postIdList.add(post1.getId());
        postIdList.add(post2.getId());

        //when
        List<Post> ap = new ArrayList<>();
        ap = boardService.findAll();

        //then
        Assertions.assertThat(ap.size()).isEqualTo(2);
    }

    @Test
    void paging() {
        List<Post> pList = new ArrayList<>();

        //given
        for (int i = 10; i < 20; i++) {
            String sub = "subject" + i;
            String cont = "content" + i;

            pList.add(new Post());
            pList.get(i).setSubject(sub);
            pList.get(i).setCont(cont);
            pList.get(i).setRegDate(Timestamp.valueOf(LocalDateTime.now()));
            boardService.savePost(pList.get(i));
        }

        //when

        List<Post> ap2 = new ArrayList<>();
        ap2 = boardService.findAll();

        List<Post> pagingList = new ArrayList<>();

        PagingInfo pagingInfo = new PagingInfo();
        pagingList = boardService.paging();
        //then

        Assertions.assertThat(ap2.size()).isEqualTo(pagingList.size());
    }
}
