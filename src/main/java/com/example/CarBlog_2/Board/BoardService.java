package com.example.CarBlog_2.Board;

import com.example.CarBlog_2.DataNotFoundException;
import com.example.CarBlog_2.User.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<BoardDTO> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createTime"));
        Pageable pageable = PageRequest.of(page, 10 , Sort.by(sorts));
        return this.boardRepository.findAll(pageable);
    }

    public BoardDTO getBoard(Long id){
        Optional<BoardDTO> boardDTO = this.boardRepository.findById(id);
        if(boardDTO.isPresent()){
            return boardDTO.get();
        }else{
            throw new DataNotFoundException("Not Found");
        }

    }

    public void createBoard(String title, String content , UserDTO userDTO){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(title);
        boardDTO.setContent(content);
        boardDTO.setCreateTime(LocalDateTime.now());
        boardDTO.setUsername(userDTO);
        this.boardRepository.save(boardDTO);
    }

    public void boardModify(BoardDTO boardDTO , String title, String content){
        boardDTO.setTitle(title);
        boardDTO.setContent(content);
        this.boardRepository.save(boardDTO);


    }

    public void boardDelete(BoardDTO boardDTO){
        this.boardRepository.delete(boardDTO);
    }
}
