package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    //return-> 할인 대상 금액. 얼마가 할인되었는지를 리턴함.
    int discount(Member member, int price);
}
