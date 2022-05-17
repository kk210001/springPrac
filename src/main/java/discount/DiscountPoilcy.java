package discount;

import member.Member;

public interface DiscountPoilcy {
    //리턴 할인 금액
    int discount(Member member, int price);

}
