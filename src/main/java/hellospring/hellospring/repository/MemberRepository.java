package hellospring.hellospring.repository;

import hellospring.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //null이 반환될수도 있어서 optional로 감싸는걸 선호
    Optional<Member> findByName(String name);
    List<Member>findAll();



}
