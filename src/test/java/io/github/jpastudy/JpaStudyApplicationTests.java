package io.github.jpastudy;

import io.github.jpastudy.auditing.Member1;
import io.github.jpastudy.auditing.Team1;
import io.github.jpastudy.auditing.repository.Member1Repository;
import io.github.jpastudy.auditing.repository.Team1Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaStudyApplicationTests {

  @Autowired
  private Member1Repository member1Repository;

  @Autowired
  private Team1Repository team1Repository;

//  @BeforeEach
//  @DisplayName("데이터 세팅")
//  void dateSetUp() {
////    for (int i = 0; i < 5; i++) {
////      Team1 team1 = Team1.builder()
////        .name("team" + i)
////        .build();
////
////      team1Repository.save(team1);
////
////      Member1 member1 = Member1.builder()
////        .id("member" + i)
////        .name("홍길동" + i)
////        .age(20 + i)
////        .team(team1)
////        .build();
////
////      member1Repository.save(member1);
////    }
//
//    Member1 member1 = Member1.builder()
//        .id("member")
//        .name("홍길동")
//        .age(30)
//        .team(team1Repository.findById(2L).get())
//        .build();
//
//    member1Repository.save(member1);
//  }

  @Test
  @DisplayName("Auditing")
  void contextLoads() {
    List<Member1> member1 = member1Repository.findAll();
    member1.forEach(m -> {
      System.out.println(m.getName() + " 회원이 생성된 날짜: " + m.getCreateTime());
    });
  }

}
