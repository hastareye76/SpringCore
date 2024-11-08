package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServiaceImpl;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//     Spring 을 사용하기 위해서 주석
//        AppConfig appConfig = new AppConfig();
//        //AppConfig 로 부터 MemberService 형 객체를 리턴받는다.
//        MemberService memberService = appConfig.memberService();

        //MemberService memberService = new MemberServiaceImpl();

        //AppConfig 클래스에 담긴 설정정보를 Spring 컨테이너에 등록을 해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);


        Member findMemeber = memberService.findMemberById(1l);
        System.out.println("new member = "+ member.getName());
        System.out.println("find member = "+ findMemeber.getName());

    }
}
