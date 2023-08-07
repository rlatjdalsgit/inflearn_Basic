package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor//final 에 대한 생성자를 지가 만듦. @Autowired 필요없죠?
public class OrderServiceImpl implements OrderService{

    //멤버 저장소에서 회원찾아야하니까
    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy;
    private final DiscountPolicy discountPolicy;


//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//
//        this.memberRepository = memberRepository;
//    }
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//
//        this.discountPolicy = discountPolicy;
//    }

//    @Autowired//의존 관계 주입.
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

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
