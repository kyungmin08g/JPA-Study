package io.github.jpastudy.embeddable;

import io.github.jpastudy.embeddable.Address.Address;
import io.github.jpastudy.embeddable.enums.TestEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
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
public class Member3 {

  @Id
  private String id;
  private String name;
  private int age;

  @Embedded
  @Comment("주소")
  private Address address;

  @Enumerated(EnumType.STRING)
  private TestEnum testEnum;

  @CreatedDate
  private LocalDateTime createTime;

  @LastModifiedDate
  private LocalDateTime updateTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "team_id")
  private Team3 team;
}