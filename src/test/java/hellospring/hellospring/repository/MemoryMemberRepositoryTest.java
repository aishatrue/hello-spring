package hellospring.hellospring.repository;

import hellospring.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    //메소드들이 끝날때마다 동작하는 콜백 메소드
    //테스트는 서로 의존관계없이 설계되어야 한다.
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    //메인메소드 작성하는거랑 비슷함.
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result); //결과가 같은지 확인



//        Assertions.assertEquals(member,result);

//        System.out.println("result = "+(result ==member));
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);





    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);


    }
}
