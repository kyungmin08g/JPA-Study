package io.github.jpastudy.embeddable.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TestEnum {
  ENUM1("테스트1"),
  ENUM2("테스트2");

  private final String value;
}
