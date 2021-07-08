package com.example.coinwiki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.coinwiki.repository.*;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final EntityManager em;
    private final DataSource dataSource;

    //private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(EntityManager em, DataSource dataSource) {
        this.em = em;
        this.dataSource = dataSource;
    }

    /**
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
    **/

    @Bean
    public BoardService boardService(){
        return new BoardService(boardRepository());
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public BoardRepository boardRepository(){
        return new BoardRepositoryImpl(em);
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }

    /**
    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(this.em);
    }
**/
}