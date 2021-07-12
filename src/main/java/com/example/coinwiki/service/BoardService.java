package com.example.coinwiki.service;

import com.example.coinwiki.domain.PagingInfo;
import com.example.coinwiki.domain.Post;
import com.example.coinwiki.domain.RecivedData;
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

    public PagingInfo setPagingInfo(RecivedData rd){

        int ipp = 10;
        int page = rd.getPage();
        int totalCount = this.findAll().size();
        int endPage = (int)(Math.ceil(page / (double) ipp) * ipp);
        int startPage = (endPage - ipp) + 1;
        int totalPage = (int)(Math.ceil(totalCount / (double)ipp));
        int tmpEndPage = (int)(Math.ceil(totalCount / (double) ipp));

        if(endPage > tmpEndPage)
            endPage = tmpEndPage;

        PagingInfo pi = new PagingInfo();

        pi.setTotalCount(totalCount);
        pi.setTotalPage(totalPage);
        pi.setStartPage(startPage);
        pi.setEndPage(endPage);
        pi.setPage(page);
        pi.setIpp(ipp);
        System.out.println(pi.toString());
        pi.setPl(boardRepository.paging(pi));

        return pi;
    }

    public List<Post> paging(){

        PagingInfo pi = new PagingInfo();

        pi.setIpp(10);

        return boardRepository.paging(pi);
    }
}
