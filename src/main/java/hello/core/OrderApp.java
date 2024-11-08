package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServiaceImpl;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        //DIP/OCP 에 대한 수정으로 이제 생성자가 변경 되었다.
        //MemberService memberService = new MemberServiaceImpl();
        //OrderService orderService = new OrderServiceImpl();

        //AppConfig를 통해서 가져와야 한다.
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        //주문을 해줄 Member 생성
        long memberId = 1l;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //멤버를 저장하고
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA", 20000);

        System.out.println("order = "+ order);
        System.out.println("order.calculatePrice = "+ order.calculatePrice());

    }
}
