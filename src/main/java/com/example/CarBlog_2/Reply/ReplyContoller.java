package com.example.CarBlog_2.Reply;

import com.example.CarBlog_2.Board.BoardDTO;
import com.example.CarBlog_2.Board.BoardService;
import com.example.CarBlog_2.User.UserDTO;
import com.example.CarBlog_2.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class ReplyContoller {

    private final ReplyService replyService;
    private final BoardService boardService;
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/reply/create/{id}")
    public String createreply(@RequestParam String content, @PathVariable("id") Long id, Model model, Principal principal){
        BoardDTO boardDTO = this.boardService.getBoard(id);
        UserDTO user = this.userService.getUser(principal.getName());
        ReplyDTO replyDTO = this.replyService.createReply(content,boardDTO,user);
        model.addAttribute("replyDTO", replyDTO);
        return String.format("redirect:/board/detail/%s",id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/reply/modify/{id}")
    public String modifyReply(@PathVariable("id")Long id, Model model){
        String title = "답변 수정 페이지";
        model.addAttribute("title", title);
        ReplyDTO replyDTO = this.replyService.getReply(id);
        model.addAttribute("replyDTO",replyDTO);

        return "reply_modify";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/reply/modify/{id}")
    public String modifyReply(@PathVariable("id")Long id , @RequestParam String content){
        ReplyDTO replyDTO = this.replyService.getReply(id);
        this.replyService.modifyReply(replyDTO, content);
        Long num = replyDTO.getBoardDTO().getId();
        return String.format("redirect:/board/detail/%s", num);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/reply/delete/{id}")
    public String deleteReply(@PathVariable("id") Long id){
        ReplyDTO replyDTO = this.replyService.getReply(id);
        this.replyService.deleteReply(replyDTO);
        return String.format("redirect:/board/detail/%s", replyDTO.getBoardDTO().getId());
    }

}
