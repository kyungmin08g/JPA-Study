package io.github.jpastudy.queryDsl.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 조인 테스트를 위한 테스트 게시글 엔티티
 */

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "test_board")
public class TestBoard {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Comment("제목")
  private String title;

  @Comment("내용")
  private String content;

  @CreatedDate
  @Column(updatable = false)
  @Comment("생성된 날짜")
  private LocalDateTime createTime;

  @LastModifiedDate
  @Comment("업데이트된 날짜")
  private LocalDateTime updateTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

}
