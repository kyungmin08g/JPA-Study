package io.github.jpastudy.queryDsl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

  @Id
  private String memberId;

  @Comment("이름")
  private String name;

  @Comment("나이")
  private int age;

}
