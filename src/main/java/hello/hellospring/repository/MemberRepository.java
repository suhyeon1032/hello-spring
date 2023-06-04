package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 1. 저장
    Optional<Member> findById(Long id); // 2. 시스템이 인식하는 ID를 통해서 member 찾기
    Optional<Member> findByName(String name); // 3. 사용자 이름을 통해 member 찾기
    List<Member> findAll(); // 4. 저장된 모든 회원 리스트 반환
}
