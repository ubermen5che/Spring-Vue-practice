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
    public Optional<Post> findByNum(Long id) {
        Post post = em.find(Post.class, id);
        return Optional.ofNullable(post);
    }

    @Override
    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }

    @Override
    public List<Post> paging(PagingInfo pi) {

        TypedQuery<Post> query =
                (TypedQuery<Post>) em.createQuery("SELECT p FROM Post p ORDER BY p.id DESC");

        query.setFirstResult((pi.getPage()-1) * pi.getIpp());
        query.setMaxResults(pi.getIpp());

        return query.getResultList();
    }
}
