package io.github.jpastudy;

import io.github.jpastudy.builder.Member4;
import io.github.jpastudy.builder.Team4;
import io.github.jpastudy.builder.enums.TestEnum2;
import io.github.jpastudy.builder.repository.Member4Repository;
import io.github.jpastudy.builder.repository.Team4Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class JpaStudyApplicationTests {

  @Autowired
  private Member4Repository member4Repository;

  @Autowired
  private Team4Repository team4Repository;

  @BeforeEach
  @DisplayName("데이터 세팅")
  void dateSetUp() {
//    List<Member4> member4List = new ArrayList<>();
//    member4List.add(
//      Member4.builder()
//        .id("member")
//        .name("홍길동")
//        .age(20)
//        .testEnum(TestEnum2.ENUM2)
//        .team(null)
//        .build()
//    );

    for (int i = 0; i < 5; i++) {
      List<Member4> member4List = new ArrayList<>();
      Team4 team4 = Team4.builder()
        .name("team" + i)
        .memberList(member4List)
        .build();

      team4Repository.save(team4);

      Member4 member4 = Member4.builder()
        .id("member" + i)
        .name("홍길동" + i)
        .age(20 + i)
        .testEnum(TestEnum2.ENUM2)
        .team(team4)
        .build();

      member4Repository.save(member4);
    }
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
  @DisplayName("builder")
  void contextLoads() {
    List<Team4> team4 = team4Repository.findAll();
    team4.forEach(t -> {
      t.getMemberList().forEach(m -> {
        System.out.println(m.getName());
      });
    });
  }

}
