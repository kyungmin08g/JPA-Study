package io.github.jpastudy.queryDsl.dto.response;

import lombok.*;

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
