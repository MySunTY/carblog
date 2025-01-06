package com.example.CarBlog_2.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping("/board/list")
    public String getList(Model model){
        List<BoardDTO> boardList = this.boardService.getList();
        model.addAttribute("boardList",boardList);
        return "board_list.html";
    }


}
