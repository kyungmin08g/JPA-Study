package io.github.jpastudy.relationship.twoWay.oneToOne;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team8 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToOne(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
  private Member8 member8;
}
