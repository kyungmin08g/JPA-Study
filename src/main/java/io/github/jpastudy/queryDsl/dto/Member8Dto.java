package io.github.jpastudy.queryDsl.dto;

import lombok.*;

/**
 * QueryDsl에서 어떤 엔티티를 조회하면 Dto로 받는지 테스트를 위한 회원 응답 객체
 */

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member8Dto {
  private String memberId;
  private String name;
  private int age;
}
