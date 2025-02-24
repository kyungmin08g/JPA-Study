package io.github.jpastudy.queryDsl.dto.response;

import lombok.*;

/**
 * 조인시 Dto로 받을 테스트 게시글 응답 객체
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TestBoardResponse {
  private Long id;
  private String title;
  private String content;
  private String memberId;
  private String memberName;
}
