package io.github.jpastudy.relationship.oneWay.manyToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team5 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  /* 단방향은 연관관계 주인이 아닌 다른 엔티티에는 연관관계 설정 안해도 됨 */
}