package sajudating.jpadating.repository;

import sajudating.jpadating.DTO.MemberDTO;
import sajudating.jpadating.domain.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Optional<Member> save(MemberDTO member);
    Optional<Member> findByUserId(String userid);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    Optional<Member> findIdByNameAndBirthday(String name, LocalDate birthday);
    Optional<Member> findPWByUserIdAndNameAndBirthday(String userId, String name, LocalDate birthday);
    Optional<Member> updateMember(MemberDTO memberDTO);
}
