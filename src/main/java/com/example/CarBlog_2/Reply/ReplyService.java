package com.example.CarBlog_2.Reply;

import com.example.CarBlog_2.Board.BoardDTO;
import com.example.CarBlog_2.User.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyDTO createReply(String content, BoardDTO boardDTO, UserDTO username){
        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setContent(content);
        replyDTO.setCreateTime(LocalDateTime.now());
        replyDTO.setBoardDTO(boardDTO);
        replyDTO.setUsername(username);
        this.replyRepository.save(replyDTO);
        return replyDTO;

    }
}
