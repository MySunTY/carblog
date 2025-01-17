package com.example.CarBlog_2.Board;

import com.example.CarBlog_2.Reply.ReplyDTO;
import com.example.CarBlog_2.User.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class BoardDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createTime;

    @OneToMany(mappedBy = "boardDTO" ,cascade = CascadeType.REMOVE)
    private List<ReplyDTO> replyDTOList;

    @ManyToOne
    private UserDTO username;

}
