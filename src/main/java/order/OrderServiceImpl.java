package order;

import discount.DiscountPoilcy;
import lombok.RequiredArgsConstructor;
import member.Member;
import member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //final 붙은 속성으로 생성자 만들어줌
public class OrderServiceImpl implements OrderService {

//    @Autowired private  MemberRepository memberRepository; //필드 주입 -> 외부에서 변경 힘듬
//    @Autowired private  DiscountPoilcy discountPoilcy;// 테스트 코드, @Configuration 같은 특수 상황에서만 쓰임
    private final MemberRepository memberRepository;
    private final DiscountPoilcy discountPoilcy;

//    @Autowired//수정자 주입 -> 선택, 변경 가능성  있는 의존관계에 사용
//    public void setDiscountPoilcy(DiscountPoilcy discountPoilcy) {
//        System.out.println("discountPoilcy = " + discountPoilcy);
//        this.discountPoilcy = discountPoilcy;
//    }
//    @Autowired(required = false)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

//    //생성자 주입-> 불변, 필수 의존관계에 사용
//    //@Autowired //생성자 1개이면 생략 가능
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPoilcy discountPoilcy) {
//        this.memberRepository = memberRepository;
//        this.discountPoilcy = discountPoilcy;
//    }

//    @Autowired //일반 메서드 주입 한번에 여러 필드 주입 받을 수 있음, 잘 사용 안함
//    public void init(MemberRepository memberRepository, DiscountPoilcy discountPoilcy){
//        this.memberRepository = memberRepository;
//        this.discountPoilcy = discountPoilcy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPoilcy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //test
    public MemberRepository getMemberRepository() {

        return memberRepository;
    }
}
