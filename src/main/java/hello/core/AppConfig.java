package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 나는 의존성 주입 시 순서가 상관이 있을 거라고 생각했는데, Spring의 프록시 및 싱글톤 관리 메커니즘 덕분에 순서는 상관이 없다고 한다.

    /**
     * @Bean만 사용해도 스프링 빈으로 등록되지만, 싱글톤을 보장하지 않는다.
     *      - memberRepository()처럼 외존관계 주입이 필요해서 메서드를 직접 호출할 때 싱글톤을 보장하지 않는다.
     * 크게 고민할 것 없다. 스프링 설정 정보는 항상 @Configuration을 사용하자
     */

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
