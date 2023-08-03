package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    //멤버 저장소에서 회원찾아야하니까
    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);//주문을 만들어준다!
        //Long memberId, String itemName, int itemPrice, int discountPrice
    }

    //for testing
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
