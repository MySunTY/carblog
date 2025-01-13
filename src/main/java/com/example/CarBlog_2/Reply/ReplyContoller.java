package com.example.CarBlog_2.Reply;

import com.example.CarBlog_2.Board.BoardDTO;
import com.example.CarBlog_2.Board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class ReplyContoller {

    private final ReplyService replyService;
    private final BoardService boardService;

    @PostMapping("/reply/create/{id}")
    public String createreply(@RequestParam String content, @PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = this.boardService.getBoard(id);
        ReplyDTO replyDTO = this.replyService.createReply(content,boardDTO);
        model.addAttribute("replyDTO", replyDTO);
        return String.format("redirect:/board/detail/%s",id);
    }

}
