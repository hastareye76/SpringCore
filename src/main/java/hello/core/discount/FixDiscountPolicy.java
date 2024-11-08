package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

    private int dicountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        //VIP 등급일 경우만 1000원 할일
        if(member.getGrade() == Grade.VIP){
            return dicountFixAmount;
        } else {
            return 0;
        }
    }
}
