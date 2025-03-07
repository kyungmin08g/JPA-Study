package io.github.jpastudy.queryDsl.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QueryDsl 설정
 * - JPAQueryFactory를 사용하면 옛날 방식인 CustomRepository를 만들지 않아도 됨 -> 편함
 */

@Configuration
@RequiredArgsConstructor
public class QueryDslConfig {

  private final EntityManager em;

  @Bean
  public JPAQueryFactory jpaQueryFactory() {
    return new JPAQueryFactory(em);
  }
}
