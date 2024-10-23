package hello.core.member;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //저장시 사용한 서비스 객체를 하나 생성해 둔다.
    MemberService memberService = new MemberServiaceImpl();
    @Test
    void join() {
        //given
        Member member = new Member(1l, "memberA", Grade.VIP);

        //when
        memberService.join(member);;
        Member findMemeber = memberService.findMemberById(1l);

        //then
        Assertions.assertThat(member).isEqualTo(findMemeber);
    }
}
