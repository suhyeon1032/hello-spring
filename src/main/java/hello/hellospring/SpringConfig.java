package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository; // Spring Data Jpa사용

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* private EntityManager em; // Jpa사용

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    /*private DataSource dataSource;

        @Autowired
        public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }
    */
    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

//    @Bean // TimeTraceAop.java에 @Component를 추가해도 되지만 Bean에 추가하는게 더 좋다
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource); // 고대 예전에 쓰던 JdbcTemplate db연동
//        return new JdbcTemplateMemberRepository(dataSource); // JdbcTemplate 버전 db연동 (반복코드가 줄어듬)
//        return new JpaMemberRepository(em); // Jpa사용

//    }
}
