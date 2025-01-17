package com.example.CarBlog_2.Reply;

import com.example.CarBlog_2.Board.BoardDTO;
import com.example.CarBlog_2.User.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ReplyDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createTime;

    @ManyToOne
    private BoardDTO boardDTO;

    @ManyToOne
    private UserDTO username;
}

