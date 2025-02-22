package io.github.jpastudy;

import io.github.jpastudy.relationship.oneWay.oneToOne.Member6;
import io.github.jpastudy.relationship.oneWay.oneToOne.Team6;
import io.github.jpastudy.relationship.oneWay.oneToOne.repository.Member6Repository;
import io.github.jpastudy.relationship.oneWay.oneToOne.repository.Team6Repository;
import io.github.jpastudy.relationship.twoWay.manyToOne.Member7;
import io.github.jpastudy.relationship.twoWay.manyToOne.Team7;
import io.github.jpastudy.relationship.twoWay.manyToOne.repository.Member7Repository;
import io.github.jpastudy.relationship.twoWay.manyToOne.repository.Team7Repository;
import io.github.jpastudy.relationship.twoWay.oneToOne.Member8;
import io.github.jpastudy.relationship.twoWay.oneToOne.Team8;
import io.github.jpastudy.relationship.twoWay.oneToOne.repository.Member8Repository;
import io.github.jpastudy.relationship.twoWay.oneToOne.repository.Team8Repository;
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
  private Member8Repository member8Repository;

  @Autowired
  private Team8Repository team8Repository;

  @BeforeEach
  @DisplayName("데이터 세팅")
  void dateSetUp() {
    for (int i = 0; i < 5; i++) {
      Team8 team8 = Team8.builder()
        .name("team" + i)
        .build();

      team8Repository.save(team8);

      Member8 member8 = Member8.builder()
        .id("member" + i)
        .name("홍길동" + i)
        .age(20 + i)
        .team(team8)
        .build();

      member8Repository.save(member8);
    }
  }

//  @Test
//  @DisplayName("Auditing") // 자동으로 시간을 감지해 저장함
//  void contextLoads() {
//    List<Member1> member1 = member1Repository.findAll();
//    member1.forEach(m -> {
//      System.out.println(m.getName() + " 회원이 생성된 날짜: " + m.getCreateTime());
//    });
//  }

//  @Test
//  @DisplayName("enumerated") // @Enumerated Enum의 값을 사용할 수 있음(?)
//  void contextLoads() {
//    List<Member2> member2 = member2Repository.findAll();
//    member2.forEach(m -> {
//      System.out.println(m.getName() + " 회원의 Enum: " + m.getTestEnum().getValue());
//    });
//  }

//  @Test
//  @DisplayName("builder") // @Builder.Default는 해당 컬럼에 초기값을 줌
//  void contextLoads() {
//    List<Team4> team4 = team4Repository.findAll();
//    team4.forEach(t -> {
//      t.getMemberList().forEach(m -> {
//        System.out.println(m.getName());
//      });
//    });
//  }

//  @Test
//  @DisplayName("단방향 - @ManyToOne")
//  void contextLoads() {
//    List<Member5> member5 = member5Repository.findAll();
//    member5.forEach(m -> {
//      System.out.println(m.getId());
//    });
//  }

//  @Test
//  @DisplayName("단방향 - @OneToOne")
//  void contextLoads() {
//    List<Member6> member6 = member6Repository.findAll();
//    member6.forEach(m -> {
//      System.out.println(m.getName());
//    });
//  }

//  @Test
//  @DisplayName("양방향 - @ManyToOne")
//  void contextLoads() {
//    List<Team7> team7 = team7Repository.findAll();
//    team7.forEach(t -> {
//      t.getMember7().forEach(m -> {
//        System.out.println(m.getId());
//      });
//    });
//  }

  @Test
  @DisplayName("양방향 - @OneToOne")
  void contextLoads() {
    List<Team8> team8 = team8Repository.findAll();
    team8.forEach(t -> {
      System.out.println(t.getMember8().getAge());
    });
  }

}
