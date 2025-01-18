package com.example.CarBlog_2.Reply;

import com.example.CarBlog_2.Board.BoardDTO;
import com.example.CarBlog_2.DataNotFoundException;
import com.example.CarBlog_2.User.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public ReplyDTO getReply(Long id){
        Optional<ReplyDTO> replyDTO = this.replyRepository.findById(id);
        if(replyDTO.isPresent()){
            return replyDTO.get();
        }else{
            throw new DataNotFoundException("Reply Not Found");
        }

    }

    public void modifyReply(ReplyDTO replyDTO , String content){
        replyDTO.setContent(content);
        this.replyRepository.save(replyDTO);
    }

    public void deleteReply(ReplyDTO replyDTO){
        this.replyRepository.delete(replyDTO);

    }

}
