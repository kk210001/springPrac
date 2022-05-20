package discount;

import annotaionPackage.MainDiscountPolicy;
import member.Grade;
import member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPoilcy {

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.Vip){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
