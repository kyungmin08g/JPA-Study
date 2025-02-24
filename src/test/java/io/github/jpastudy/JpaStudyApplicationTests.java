package io.github.jpastudy;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.github.jpastudy.queryDsl.dto.Member8Dto;
import io.github.jpastudy.queryDsl.dto.response.TestBoardResponse;
import io.github.jpastudy.relationship.twoWay.oneToOne.Member8;
import io.github.jpastudy.relationship.twoWay.oneToOne.Team8;
import io.github.jpastudy.relationship.twoWay.oneToOne.repository.Member8Repository;
import io.github.jpastudy.relationship.twoWay.oneToOne.repository.Team8Repository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static io.github.jpastudy.queryDsl.entity.QComments.comments;
import static io.github.jpastudy.queryDsl.entity.QMember.member;
import static io.github.jpastudy.queryDsl.entity.QTestBoard.testBoard;
import static io.github.jpastudy.relationship.twoWay.oneToOne.QMember8.member8;
import static io.github.jpastudy.relationship.twoWay.oneToOne.QTeam8.team8;

@SpringBootTest
class JpaStudyApplicationTests {

  @Autowired
  private Member8Repository member8Repository;

  @Autowired
  private Team8Repository team8Repository;

//  @BeforeEach
//  @DisplayName("데이터 세팅")
//  void dateSetUp() {
//    for (int i = 0; i < 5; i++) {
//      Team8 team8 = Team8.builder()
//        .name("team" + i)
//        .build();
//
//      team8Repository.save(team8);
//
//      Member8 member8 = Member8.builder()
//        .id("member" + i)
//        .name("홍길동" + i)
//        .age(20 + i)
//        .team(team8)
//        .build();
//
//      member8Repository.save(member8);
//    }
//  }

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

//  @Test
//  @DisplayName("양방향 - @OneToOne")
//  void contextLoads() {
//    List<Team8> team8 = team8Repository.findAll();
//    team8.forEach(t -> {
//      System.out.println(t.getMember8().getAge());
//    });
//  }

  @Autowired
  private JPAQueryFactory jpaQueryFactory;

  @Test
  @DisplayName("QueryDsl CRUD")
  /*
  @Transactional
  @Commit
  - 이 둘은 수정/삭제시 필요함. 물론 @Commit은 지금 테스트 코드여서 선언한거임. (원래 테스트 코드일때 저장이나 업데이트하면 DB에 적용이 안됨)
   */
  @Transactional
  @Commit
  void queryDslCRUD() {
    /*
    - 조회는 List에 담아서 받는 방법이랑 해당 엔티티나 Dto로 받는 방법이 있네..
     */
    // Entity로 받기
    Team8 team8Response = jpaQueryFactory.selectFrom(team8)
      .where(team8.id.eq(4L))
      .fetchOne(); // <- fetchOne();은 한개의 Entity나 Dto로 반환하는데 없으면 예외를 던짐
    System.out.println("팀 이름: " + team8Response.getName());

    // Dto로 받기
    Member8Dto member8Response = jpaQueryFactory
      .select(
        Projections.fields(Member8Dto.class,
          member8.id.as("memberId"),
          member8.name,
          member8.age
        )
      )
      .from(member8)
      .where(member8.id.eq("member2"))
      .fetchOne();
    System.out.println("회원 이름: " + member8Response.getName());

    // List로 받기
    List<Member8> member8Responses = jpaQueryFactory
      .selectFrom(member8)
      .where(member8.name.eq("김경민"), member8.age.eq(18)) // <- 조건을 동시에 여러개를 줄 수 있다는걸 말하고 싶었음 (지금 코드상에서 안해도됨)
      .fetch(); // <- fetch();는 List로 반환
    System.out.println(member8Responses.size());

    /*
    - CRUD에서 조회 빼고는 다 개수로 알려주네.. (C/U/D된 수)
     */
    long updateCount = jpaQueryFactory.update(member8)
      .where(member8.id.eq("member1"))
      .set(member8.name, "김경민").set(member8.age, 18)
      .execute();
    System.out.println(updateCount + "개의 업데이트를 수행함");

    long deleteCount = jpaQueryFactory.delete(member8)
      .where(member8.id.eq("member0"))
      .execute();
    System.out.println(deleteCount + "개의 삭제를 수행함");

    long insertCount = jpaQueryFactory.insert(member8)
      .columns(member8.id, member8.name, member8.age)
      .values("member11", "홍길동11", 43)
      .execute();
    System.out.println(insertCount + "개의 엔티티를 저장함");
  }

  // 실험을 위한 데이터 저장 - QueryDsl를 사용하여 저장
  @Test
  @DisplayName("Date Set Up")
  @Transactional
  @Commit
  void setUp() {
    // 회원 데이터 저장
    for (int i = 0; i < 5; i++) {
      jpaQueryFactory.insert(member)
        .columns(
          member.memberId,
          member.name,
          member.age
        )
        .values("memberId" + i, "김경민" + i, 20 + i)
        .execute();
    }

    // 회원 데이터 조회 및 게시글 데이터 저장
    for (int i = 0; i < 5; i++) {
      String memberId = jpaQueryFactory
        .select(
          member.memberId
        )
        .from(member)
        .where(member.memberId.eq("memberId" + i))
        .fetchOne();

      jpaQueryFactory.insert(comments)
        .columns(
          comments.content,
          comments.member.memberId
        )
        .values("테스트 댓글" + i, memberId)
        .execute();

      jpaQueryFactory.insert(testBoard)
        .columns(testBoard.title, testBoard.content, testBoard.member.memberId)
        .values("테스트 제목6" + i, "테스트 내용6" + i, memberId)
        .execute();
    }
  }

  @Test
  @DisplayName("QueryDsl Join")
  @Transactional
  @Commit
  void queryDslJoin() {
    // Inner Join -> 이 친구는 null을 포함하지 않은 동등한 조건을 만족시 그것만 join해서 가져오기 떄문에 아래와 같이 설계
    List<TestBoardResponse> innerJoinResponse = jpaQueryFactory
      .select(
        Projections.fields(
          TestBoardResponse.class,
          testBoard.id,
          testBoard.title,
          testBoard.content,
          member.memberId,
          member.name.as("memberName")
        )
      )
      .from(testBoard)
      .innerJoin(member)
      .on(testBoard.member.memberId.eq(member.memberId))
      .where(testBoard.member.memberId.eq("memberId1"))
      .fetch();
    innerJoinResponse.forEach(date -> {
      System.out.println("게시글 ID: " + date.getId() + ", 게시글 제목: " + date.getTitle() + ", 작성한 회원: " + date.getMemberName());
    });

    // Left Outer Join -> 이 친구는 왼쪽을 기준으로 모든 컬럼을 조회하는데 오른쪽 테이블에서 왼쪽 테이블에 있는 속성 값이 없다면 null로 처리
    List<TestBoardResponse> leftOuterJoinResponse = jpaQueryFactory
      .select(
        Projections.fields(
          TestBoardResponse.class,
          testBoard.id,
          testBoard.title,
          testBoard.content,
          member.memberId,
          member.name.as("memberName")
        )
      )
      .from(testBoard)
      .leftJoin(member)
      .on(testBoard.member.memberId.eq(member.memberId))
      .fetch();
    leftOuterJoinResponse.forEach(date -> {
      System.out.println("게시글 ID: " + date.getId() + ", 게시글 제목: " + date.getTitle() + ", 작성한 회원: " + date.getMemberName());
    });

    // Right Outer Join -> 얘는 오른쪽 테이블을 기준으로 잡고 left outer join과 같음
    List<TestBoardResponse> rightOuterJoinResponse = jpaQueryFactory
      .select(
        Projections.fields(
          TestBoardResponse.class,
          testBoard.id,
          testBoard.title,
          testBoard.content,
          member.memberId,
          member.name.as("memberName")
        )
      )
      .from(member)
      .rightJoin(testBoard)
      .on(testBoard.member.memberId.eq(member.memberId))
      .fetch();
    rightOuterJoinResponse.forEach(date -> {
      System.out.println("게시글 ID: " + date.getId() + ", 게시글 제목: " + date.getTitle() + ", 작성한 회원: " + date.getMemberName());
    });

    // 다중 Join
    List<TestBoardResponse> multipleInnerJoinResponse = jpaQueryFactory
      .select(
        Projections.fields(
          TestBoardResponse.class,
          testBoard.id,
          testBoard.title,
          testBoard.content,
          member.memberId,
          member.name.as("memberName")
        )
      )
      .from(testBoard)
      .join(member).on(testBoard.member.memberId.eq(member.memberId))
      .join(comments).on(comments.member.memberId.eq(member.memberId))
      .where(comments.member.memberId.eq("memberId3"))
      .fetch();
    multipleInnerJoinResponse.forEach(date -> {
      System.out.println("게시글 ID: " + date.getId());
    });
  }
}
