package com.example.CarBlog_2.Board;

import com.example.CarBlog_2.User.UserDTO;
import com.example.CarBlog_2.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("/board/list")
    public String getList(Model model, @RequestParam(value="page", defaultValue = "0") int page){
        String title = "목록보기";
        Page<BoardDTO> paging = this.boardService.getList(page);
        model.addAttribute("paging",paging);
        model.addAttribute("title",title);
        return "board_list.html";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/board/detail/{id}")
    public String boardDetail(@PathVariable("id") long id,Model model){

        BoardDTO boardDTO = this.boardService.getBoard(id);
        String title = boardDTO.getId()+"님의 게시글";
        model.addAttribute("boardDTO",boardDTO);
        model.addAttribute("title", title);
        return "board_detail.html";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/board/create")
    public String boardCreate(Model model, Principal principal){
        String title = "게시글 작성하기";
        model.addAttribute("title", title);
        String username = principal.getName();
        System.out.println(username);
        return "board_create.html";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/board/create")
    public String boardCreate(@RequestParam String title, @RequestParam String content, Principal principal){
        UserDTO user = userService.getUser(principal.getName());
        this.boardService.createBoard(title, content , user);
        return "redirect:/board/list";
    }


}
