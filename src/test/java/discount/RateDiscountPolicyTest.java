package discount;

import member.Grade;
import member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인 적용")
    void vip_o() {

        Member member = new Member(1l, "memberVip", Grade.Vip);

        int discount = discountPolicy.discount(member, 10000);

       assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP 아닐시 할인적용 x")
    void vip_X() {

        Member member = new Member(2l, "memberBasic", Grade.Baisc);

        int discount = discountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }

}