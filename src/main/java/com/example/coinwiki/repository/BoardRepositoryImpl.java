package com.example.coinwiki.repository;

import com.example.coinwiki.domain.PagingInfo;
import com.example.coinwiki.domain.Post;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BoardRepositoryImpl implements BoardRepository{

    private final EntityManager em;


    public BoardRepositoryImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Post savePost(Post post) {
        em.persist(post);
        return post;
    }

    @Override
    public Post findByNum(Long id, String boardCode) {
        String bCode = boardCode;

        return (Post) em.createQuery("select p from Post p where p.board_code = :bCode AND p.id = :id")
                .setParameter("bCode", bCode)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }

    @Override
    public List<Post> paging(PagingInfo pi) {

        String boardCode = pi.getBoardCode();

        TypedQuery<Post> query =
                (TypedQuery<Post>) em.createQuery("SELECT p FROM Post p  WHERE p.board_code = :boardCode ORDER BY p.id DESC", Post.class);

        query.setParameter("boardCode", boardCode);
        query.setFirstResult((pi.getPage()-1) * pi.getIpp());
        query.setMaxResults(pi.getIpp());

        return query.getResultList();
    }
}
