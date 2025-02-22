package io.github.jpastudy.relationship.oneWay.oneToOne;

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
public class Member6 {

  @Id
  private String id;
  private String name;
  private int age;

  @CreatedDate
  private LocalDateTime createTime;

  @LastModifiedDate
  private LocalDateTime updateTime;

  @OneToOne
  @JoinColumn(name = "team_id")
  private Team6 team;
}