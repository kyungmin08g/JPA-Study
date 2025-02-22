package io.github.jpastudy.relationship.twoWay.manyToOne;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Member7 {

  @Id
  private String id;
  private String name;
  private int age;

  @CreatedDate
  private LocalDateTime createTime;

  @LastModifiedDate
  private LocalDateTime updateTime;

  // 단방향 관계 설정
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id") // <- FK가 될 컬럼 (@JoinColumn -> 연관관계 주인만)
  private Team7 team;
}
