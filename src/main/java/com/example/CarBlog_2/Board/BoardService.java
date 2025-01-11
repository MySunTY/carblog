package com.example.CarBlog_2.Board;

import com.example.CarBlog_2.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDTO> getList(){
        return this.boardRepository.findAll();
    }

    public BoardDTO getBoard(Long id){
        Optional<BoardDTO> boardDTO = this.boardRepository.findById(id);
        if(boardDTO.isPresent()){
            return boardDTO.get();
        }else{
            throw new DataNotFoundException("Not Found");
        }

    }

    public void createBoard(String title, String content){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle(title);
        boardDTO.setContent(content);
        boardDTO.setCreateTime(LocalDateTime.now());
        this.boardRepository.save(boardDTO);
    }
}
