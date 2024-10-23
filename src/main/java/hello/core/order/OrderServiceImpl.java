package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMeberRepository;

public class OrderServiceImpl implements OrderService {

    //주어진 id로 멤버를 찾아야 한다.
    private final MemberRepository memberRepository = new MemoryMeberRepository();
    //멤버의 등급에 따른 discount 정책을 확인해야 하므로
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //1번 메모리 DB에 저장된 멤버를 확인한다.
        Member member = memberRepository.findById(memberId);

        //
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
