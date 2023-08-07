package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core", 어디를 스캔할지 위치를 지정해줌.
        //설정안하면? @Component가 붙은 정보클래스의 패키지가 시작 위치.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //Configuration 설정해 놓은게 많아서 충돌 생기는 거 방지하기.
)
//설정 정보가 없어도 자동으로 스프링 빈을 등록하는 기능
public class AutoAppConfig {
//    @Autowired MemberRepository memberRepository;
//    @Autowired DiscountPolicy discountPolicy;
//    @Bean
//    OrderService orderService(){
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

}
