package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {

    @Test
    void findAllBean(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountServce.class);
        DiscountServce discountServce = ac.getBean(DiscountServce.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        int discountPrice = discountServce.discount(member, 10000, "fixDiscountPolicy");
        assertThat(discountServce).isInstanceOf(DiscountServce.class);
        assertThat(discountPrice).isEqualTo(1000);
    }
    static class DiscountServce{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountServce(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return  discountPolicy.discount(member, price);

        }
    }
}
