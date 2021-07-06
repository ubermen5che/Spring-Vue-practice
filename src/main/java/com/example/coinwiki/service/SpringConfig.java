package com.example.coinwiki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.coinwiki.repository.*;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {


    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /**
    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(this.em);
    }
**/
}