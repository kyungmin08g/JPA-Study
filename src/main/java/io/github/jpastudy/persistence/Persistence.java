package io.github.jpastudy.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.Comment;

/**
 * 영속성 컨텍스트의 이해를 위한 엔티티 객체
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Persistence {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Comment("이름")
  private String name;

  public Persistence(String name) {
    this.name = name;
  }
}
