package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServiaceImpl;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiaceImpl();
        OrderService orderService = new OrderServiceImpl();

        //주문을 해줄 Member 생성
        long memberId = 1l;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //멤버를 저장하고
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        System.out.println("order = "+ order);
        System.out.println("order.calculatePrice = "+ order.calculatePrice());

    }
}
