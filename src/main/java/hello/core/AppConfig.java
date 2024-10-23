package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberServiaceImpl;
import hello.core.member.MemberService;
import hello.core.member.MemoryMeberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//DIP/OCP 위반을 해결하기 위해서 추가된 클래스
public class AppConfig {
    //DIP / OCP 를 위반하는 코드는 MemberServiceImpl 에도 역시 존재
    //서비스에서 레파지토리를 직접생성하는 것을 방지하기 위해서
    //
    /*
    public class MemberServiaceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMeberRepository();
     */

    //서비스를 생성하는 함수 추가
    public MemberService memberService() {
        return new MemberServiaceImpl( new MemoryMeberRepository() );
    }

    //주문 서비스를 생성하는 함수 추가 두 객체를 생성해서 주문 서비스 객체를 반환해 준다.
    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMeberRepository(),
                new FixDiscountPolicy());
    }
}
