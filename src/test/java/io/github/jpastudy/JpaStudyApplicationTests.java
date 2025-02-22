package io.github.jpastudy;

import io.github.jpastudy.embeddable.Address.Address;
import io.github.jpastudy.embeddable.Member3;
import io.github.jpastudy.embeddable.Team3;
import io.github.jpastudy.embeddable.enums.TestEnum;
import io.github.jpastudy.embeddable.repository.Member3Repository;
import io.github.jpastudy.embeddable.repository.Team3Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaStudyApplicationTests {

  @Autowired
  private Member3Repository member3Repository;

  @Autowired
  private Team3Repository team3Repository;

  @BeforeEach
  @DisplayName("데이터 세팅")
  void dateSetUp() {
    for (int i = 0; i < 5; i++) {
      Team3 team3 = Team3.builder()
        .name("team" + i)
        .build();

      team3Repository.save(team3);

      Member3 member3 = Member3.builder()
        .id("member" + i)
        .name("홍길동" + i)
        .age(20 + i)
        .address(new Address("DD시", "DD구", "DD동"))
        .testEnum(TestEnum.ENUM2)
        .team(team3)
        .build();

      member3Repository.save(member3);
    }

//    Member1 member1 = Member1.builder()
//        .id("member")
//        .name("홍길동")
//        .age(30)
//        .team(team1Repository.findById(2L).get())
//        .build();
//
//    member1Repository.save(member1);
  }

//  @Test
//  @DisplayName("Auditing")
//  void contextLoads() {
//    List<Member1> member1 = member1Repository.findAll();
//    member1.forEach(m -> {
//      System.out.println(m.getName() + " 회원이 생성된 날짜: " + m.getCreateTime());
//    });
//  }

//  @Test
//  @DisplayName("enumerated")
//  void contextLoads() {
//    List<Member2> member2 = member2Repository.findAll();
//    member2.forEach(m -> {
//      System.out.println(m.getName() + " 회원의 Enum: " + m.getTestEnum().getValue());
//    });
//  }

  @Test
  @DisplayName("embeddable")
  void contextLoads() {
    List<Member3> member3 = member3Repository.findAll();
    member3.forEach(m -> {
      System.out.println(m.getName() + " 회원의 시: " + m.getAddress().getCity());
      System.out.println(m.getName() + " 회원의 구: " + m.getAddress().getDistrict());
      System.out.println(m.getName() + " 회원의 동: " + m.getAddress().getDong());
    });
  }

}
