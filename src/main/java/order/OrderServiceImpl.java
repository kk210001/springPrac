package order;

import discount.DiscountPoilcy;
import member.Member;
import member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    private MemberRepository memberRepository;
    private DiscountPoilcy discountPoilcy;

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
