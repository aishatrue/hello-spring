package hellospring.hellospring.repository;

import hellospring.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    //이게 필요하다네..?스프링 부트가 자동으로 넣어주고
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        //persist기 영구저장하다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //조회타입,pk가 들어감.
        Member member = em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
       List<Member> result =  em.createQuery("select m from Member m where m.name= :name",Member.class)
                .setParameter("name",name)
                .getResultList();
       return result.stream().findAny();

    }

    @Override
    public List<Member> findAll() {
        //select 를 객체 자체를 셀렉트해옴. entity를 대상으로 쿼리를 날림.
        return em.createQuery("select m from Member as m",Member.class)
                .getResultList();
    }
}
