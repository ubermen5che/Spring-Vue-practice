package com.example.coinwiki.controller;

import com.example.coinwiki.domain.Member;
import com.example.coinwiki.domain.Post;
import com.example.coinwiki.repository.BoardRepository;
import com.example.coinwiki.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/api/board")
    @ResponseBody
    public List<Post> getBoardList(Model model){
        List<Post> board = boardService.findAll();
        model.addAttribute("boardList", board);

        return board;
    }
}
