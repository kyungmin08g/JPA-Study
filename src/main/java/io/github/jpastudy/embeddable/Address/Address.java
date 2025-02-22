package io.github.jpastudy.embeddable.Address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  @Comment("시/도")
  private String city;

  @Comment("구/군")
  private String district;

  @Comment("동")
  private String dong;
}
