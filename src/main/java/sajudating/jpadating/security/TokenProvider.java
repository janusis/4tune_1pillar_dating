package sajudating.jpadating.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sajudating.jpadating.domain.Member;
import sajudating.jpadating.domainDto.LoginDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service

public class TokenProvider {


    private static final String SECRET_KEY = "4398HF8N489GN39G2OK";

    public TokenProvider() {
    }

    //jwt 토큰생성
    public String create(Member member) {
        Date date = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));

        return Jwts.builder()
                //header 들어갈 내용과 서명을 위한 알고리즘과 SECRET_KEY
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                //payload에 들어갈 내용들
                .setSubject(String.valueOf(member.getId()))
                .setIssuer("demo app")
                .setIssuedAt(new Date())
                .setExpiration(date)
                .compact();

    }
    //토큰을 디코딩 및 파싱하고 토큰의 위조여부 확인
    public String validateAndGetUserId(String token){

        Claims claims = Jwts.parser()
                //디코딩 할 키 정하기
                .setSigningKey(SECRET_KEY)
                /*
                1.Base64로 디코딩
                2.헤더와 페이로드를 위에 시크릿키를 이용해서 다시 암호화
                3. 받은 token의 서명과 비교하여 같으면 Claims 객체(페이로드) 반환 아니라면 예외를 날린다.
                */
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}