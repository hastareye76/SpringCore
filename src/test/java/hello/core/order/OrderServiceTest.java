package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServiaceImpl;
import hello.core.member.MemberService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class OrderServiceTest {
    //MemberService memberService = new MemberServiaceImpl();
    //OrderService orderService = new OrderServiceImpl();
    private MemberService memberService;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }




    @Test
    void createOrder() {
        Long memberId = 1l;
        Member member = new Member(memberId, "memberTestA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemTest1", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
