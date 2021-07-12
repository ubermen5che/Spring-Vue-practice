package com.example.coinwiki.controller;

import com.example.coinwiki.domain.PagingInfo;;
import com.example.coinwiki.domain.Post;
import com.example.coinwiki.domain.ReceivedData;
import com.example.coinwiki.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("/api/board")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity getBoardList(ReceivedData rd){

        PagingInfo pi = boardService.setPagingInfo(rd);

        HashMap<String, Object> body = new HashMap<>();

        body.put("success", true);
        body.put("pagingInfo", pi);

        return new ResponseEntity(body, HttpStatus.OK);
    }

    @GetMapping("/api/board/view")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity getView(ReceivedData rd){

        Post fPost = boardService.findOne(rd.getId(), rd.getBoardCode());

        HashMap<String, Object> body = new HashMap<>();

        body.put("success", true);
        body.put("view", fPost);

        return new ResponseEntity(body, HttpStatus.OK);
    }

    @PostMapping("/api/board")
    public ResponseEntity create(@RequestBody PostForm form) {
        HashMap<String, Boolean> body = new HashMap<String, Boolean>();

        Post post = new Post();
        post.setSubject(form.getSubject());
        post.setCont(form.getCont());
        post.setType(form.getType());
        post.setBoard_code(form.getBoardCode());
        post.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
        body.put("success", true);
        System.out.println(post.toString());

        boardService.savePost(post);

        return new ResponseEntity(body, HttpStatus.OK);
    }

}
