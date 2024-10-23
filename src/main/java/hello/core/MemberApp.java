package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServiaceImpl;
import hello.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        //AppConfig 로 부터 MemberService 형 객체를 리턴받는다.
        MemberService memberService = appConfig.memberService();

        //MemberService memberService = new MemberServiaceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);


        Member findMemeber = memberService.findMemberById(1l);
        System.out.println("new member = "+ member.getName());
        System.out.println("find member = "+ findMemeber.getName());

    }
}
