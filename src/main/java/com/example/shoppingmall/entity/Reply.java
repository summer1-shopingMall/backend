package com.example.shoppingmall.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.attoparser.dom.Text;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reply")
public class Reply {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private Long productId;

  @NotNull
  private Text content;

  @NotNull
  private Long userId;

  @NotNull
  private int star;

  private LocalDateTime replyDate;

  //이거 밑에는 댓글 대댓글에 필요한
  private Long replyOriginId;

  private int replyOrder;
  private int replyDepth;
}
