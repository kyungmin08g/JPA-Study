package io.github.jpastudy.builder.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TestEnum2 {
  ENUM1("테스트1"),
  ENUM2("테스트2");

  private final String value;
}
