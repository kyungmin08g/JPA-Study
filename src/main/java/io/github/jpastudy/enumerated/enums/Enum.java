package io.github.jpastudy.enumerated.enums;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum Enum {
  ENUM1("테스트1"),
  ENUM2("테스트2");

  private final String value;
}
