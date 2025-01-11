package com.example.CarBlog_2.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    public String getList(Model model){
        String title = "목록보기";
        List<BoardDTO> boardList = this.boardService.getList();
        model.addAttribute("boardList",boardList);
        model.addAttribute("title",title);
        return "board_list.html";
    }

    @GetMapping("/board/detail/{id}")
    public String boardDetail(@PathVariable("id") long id,Model model){

        BoardDTO boardDTO = this.boardService.getBoard(id);
        String title = boardDTO.getId()+"님의 게시글";
        model.addAttribute("boardDTO",boardDTO);
        model.addAttribute("title", title);
        return "board_detail.html";
    }

    @GetMapping("/board/create")
    public String boardCreate(Model model){
        String title = "게시글 작성하기";
        model.addAttribute("title", title);
        return "board_create.html";
    }

    @PostMapping("/board/create")
    public String boardCreate(@RequestParam String title, @RequestParam String content){
        this.boardService.createBoard(title, content);
        return "redirect:/board/list";
    }


}