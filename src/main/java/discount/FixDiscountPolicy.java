package discount;

import member.Grade;
import member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPoilcy {
    private int discountFixAmount = 1000; //1000원 할인
    @Override

    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.Vip){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
