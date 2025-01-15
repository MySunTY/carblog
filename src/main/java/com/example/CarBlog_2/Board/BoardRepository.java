package com.example.CarBlog_2.Board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardDTO,Long> {
    Page<BoardDTO> findAll(Pageable pageable);
}
