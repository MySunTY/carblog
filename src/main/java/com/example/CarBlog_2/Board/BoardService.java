package com.example.CarBlog_2.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDTO> getList(){
        return this.boardRepository.findAll();
    }
}
