package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMeberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    //주어진 id로 멤버를 찾아야 한다. 이역시 객체에 의존적이므로 주석처리
    //private final MemberRepository memberRepository = new MemoryMeberRepository();
    //멤버의 등급에 따른 discount 정책을 확인해야 하므로
    //하지만 DIP 설계원칙으로 보면 OrderServiceImpl 은 DiscountPolicy 인터페이스와
    //이를 구현한 FixDiscountPolicy 객체에 대해서도 의존하고 있다. 즉 DIP 위반이다.
    //추가로 비율 할인을 적용하려면 실제 구현역시 변경해야 하므로 이는 OCP 위반이다.
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //DIP 해결을 위해서 인퍼페이스에만 의존하지 않도록 아래와 같이 선언해 준다.
    //하지만 실제 사용할 객체가 설정되지 못하는 문제가 생긴다.
    private final MemberRepository memberRepository; //lombok 라이브러리 적용테스트를 위해서 final 키워드를 필드 멤버에 추가해주었다.
    private final DiscountPolicy discountPolicy;

    //setter 를 이용한 주입.
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("setMemberRepository Method 주입");
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("setDiscountPolicy Method 주입");
//        this.discountPolicy = discountPolicy;
//    }

    //일반 메소드 주입.
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//
//    }

    //생성자에서 주입 하므로서 OrderServiceImpl 은 DIP/OCP 준수하고 있다. 생성자가 하나만 정의 되어져 있다면 Autowired 를 생략할 수 있다.
    @Autowired //<== 생략이 가능하다. 롬복 라이브러리로 간단하게 해줄 수 있다. final이 붙은 필드를 모아서 생성자를 자동으로 만들어주는
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
        System.out.println("OrderServiceImpl constructor 생성자 주입");
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;

    }

//    @RequiredArgsConstructor 를 사용하면 final 로 선언된 멤버를 인자로 하여 생성자를 자동으로 만들어 준다.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //1번 메모리 DB에 저장된 멤버를 확인한다.
        Member member = memberRepository.findById(memberId);

        //
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
