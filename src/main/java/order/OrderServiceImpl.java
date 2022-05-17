package order;

import discount.DiscountPoilcy;
import member.Member;
import member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPoilcy discountPoilcy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPoilcy discountPoilcy) {
        this.memberRepository = memberRepository;
        this.discountPoilcy = discountPoilcy;
    }

    @Override
    public Order calculateOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPoilcy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //test
    public MemberRepository getMemberRepository() {

        return memberRepository;
    }
}
