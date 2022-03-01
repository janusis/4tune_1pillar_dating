package sajudating.jpadating.repository;

import sajudating.jpadating.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Optional<Member> save(Member.MemberBuilder member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
