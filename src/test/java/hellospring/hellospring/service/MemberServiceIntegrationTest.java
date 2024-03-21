package hellospring.hellospring.service;

import hellospring.hellospring.domain.Member;
import hellospring.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    //테스트는 그냥 생성자 주입말고, 오토와이어드로 바로 받는게 편함.
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName(" 바꿈");


        //when
        Long saveId = memberService.join(member);


        //then
       Member findMember = memberService.findOne(saveId).get();
        System.out.println(findMember.getName());
       assertThat(member.getName()).isEqualTo(findMember.getName());


    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("저장되는거 맞냐구");

        Member member2 = new Member();
        member2.setName("오이이잉");

        //when
        memberService.join(member1);

        //try catch보다 쉬운.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));


        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.99");
//        try {
//            memberService.join(member2);
//            fail(); //여기까지 오면 fail인것
//
//        }catch (IllegalStateException e){
//                assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }



        //then

    }


}