package com.example.coinwiki.service;

import com.example.coinwiki.domain.PagingInfo;
import com.example.coinwiki.domain.Post;
import com.example.coinwiki.domain.ReceivedData;
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

    public Post findOne(Long id, String boardCode){
        return boardRepository.findByNum(id, boardCode);
    }

    public List<Post> findAll(){
        return boardRepository.findAll();
    }

    public PagingInfo setPagingInfo(ReceivedData rd){

        int ipp = 10;
        int page = rd.getPage();
        int totalCount = this.findAll().size();
        int endPage = (int)(Math.ceil(page / (double) ipp) * ipp);
        int startPage = (endPage - ipp) + 1;
        int totalPage = (int)(Math.ceil(totalCount / (double)ipp));
        int tmpEndPage = (int)(Math.ceil(totalCount / (double) ipp));
        String board_code = rd.getBoardCode();

        if(endPage > tmpEndPage)
            endPage = tmpEndPage;

        PagingInfo pi = new PagingInfo();

        pi.setTotalCount(totalCount);
        pi.setTotalPage(totalPage);
        pi.setStartPage(startPage);
        pi.setEndPage(endPage);
        pi.setBoardCode(board_code);
        pi.setPage(page);
        pi.setIpp(ipp);
        pi.setPl(boardRepository.paging(pi));
        System.out.println(pi.toString());

        return pi;
    }

    public List<Post> paging(){

        PagingInfo pi = new PagingInfo();
        pi.setPage(1);
        pi.setIpp(10);
        pi.setBoardCode("news");
        return boardRepository.paging(pi);
    }
}
