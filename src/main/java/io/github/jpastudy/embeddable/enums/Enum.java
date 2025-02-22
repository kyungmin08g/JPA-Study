package io.github.jpastudy.embeddable.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public enum Enum {
  ENUM1("테스트1"),
  ENUM2("테스트2");

  private String value;
}
