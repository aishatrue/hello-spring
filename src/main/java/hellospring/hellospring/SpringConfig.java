package hellospring.hellospring;

import hellospring.hellospring.repository.MemberRepository;
import hellospring.hellospring.repository.MemoryMemberRepository;
import hellospring.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//직접 스프링빈 등록하는 방법
public class SpringConfig {

    /**
     * memberservice랑 memberrepository를 둘다 스프링빈에 등록하고
     * 스프링 빈에 등록되어있는 멤버리포지토리를 멤버서비스에 넣어줌.
     */

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

