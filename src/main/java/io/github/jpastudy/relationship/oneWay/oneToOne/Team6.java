package io.github.jpastudy.relationship.oneWay.oneToOne;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team6 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
}
