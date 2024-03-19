package hellospring.hellospring.service;

import hellospring.hellospring.domain.Member;
import hellospring.hellospring.repository.MemberRepository;
import hellospring.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복회원은 안됨.
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        //optional로 감싸서 가능한구문.. 원래는 if null이면.. 요렇게 해야됨.
//        result.ifPresent(m->{
//            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
//        });

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m->{
                            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
                        });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member>
}
