package io.github.jpastudy;

import io.github.jpastudy.auditing.Member1;
import io.github.jpastudy.auditing.Team1;
import io.github.jpastudy.auditing.repository.Member1Repository;
import io.github.jpastudy.auditing.repository.Team1Repository;
import io.github.jpastudy.embeddable.Member2;
import io.github.jpastudy.embeddable.Team2;
import io.github.jpastudy.embeddable.enums.Enum;
import io.github.jpastudy.embeddable.repository.Member2Repository;
import io.github.jpastudy.embeddable.repository.Team2Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaStudyApplicationTests {

  @Autowired
  private Member2Repository member2Repository;

  @Autowired
  private Team2Repository team2Repository;

  @BeforeEach
  @DisplayName("데이터 세팅")
  void dateSetUp() {
//    for (int i = 0; i < 5; i++) {
//      Team2 team2 = Team2.builder()
//        .name("team" + i)
//        .build();
//
//      team2Repository.save(team2);
//
//      Member2 member2 = Member2.builder()
//        .id("member" + i)
//        .name("홍길동" + i)
//        .age(20 + i)
//        .testEnum(Enum.ENUM1)
//        .team(team2)
//        .build();
//
//      member2Repository.save(member2);
//    }

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

  @Test
  @DisplayName("embeddable")
  void contextLoads() {
    List<Member2> member2 = member2Repository.findAll();
    member2.forEach(m -> {
      System.out.println(m.getName() + " 회원의 Enum: " + m.getTestEnum().getValue());
    });
  }

}
