package hellospring.hellospring;

import hellospring.hellospring.aop.TimeTraceAop;
import hellospring.hellospring.repository.JdbcTemplateMemberRepository;
import hellospring.hellospring.repository.JpaMemberRepository;
import hellospring.hellospring.repository.MemberRepository;
import hellospring.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//직접 스프링빈 등록하는 방법
public class SpringConfig {

    //스프링 데이터 jpa가 자동으로 구현체 만들어줌
    // memberrepository를 jparepo가 상속받는데, memberrepository주입받을때 같이 주입받을 수 있다..?
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }



//    private EntityManager em;

//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
    /**
     * memberservice랑 memberrepository를 둘다 스프링빈에 등록하고
     * 스프링 빈에 등록되어있는 멤버리포지토리를 멤버서비스에 넣어줌.
     */

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }
}

