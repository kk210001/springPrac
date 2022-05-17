package discount;

import member.Grade;
import member.Member;

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
