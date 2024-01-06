package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){

        // given ~~ 환경에서
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when ~~ 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then ~~ 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);

        // 클래스 다이어그램 : 정적
        // 객체 다이어그램 : 동적(실행될 때의 객체 - 실제 구현체만)

    }

}
