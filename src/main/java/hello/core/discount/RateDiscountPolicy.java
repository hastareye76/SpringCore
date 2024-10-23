package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    //Ctl + Shift + T 누르면 테스트 코드를
    @Override
    public int discount(Member member, int price) {
        //VIP 등급일 경우만 1000원 할일
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
