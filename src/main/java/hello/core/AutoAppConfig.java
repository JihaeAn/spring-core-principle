package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        // 여기서 basePackages = "hello.core.member" 해줬다가 AutoAppConfigTest에서 생성자에 soutv 찍어봤을 때 안 됐었다 ! 유의 !
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 참고: 보통 설정 정보를 컴포넌트 스캔 대상에서 제외하지 않지만, 기존 예제 코드를 최대한 남기고 유지하기 위해 !!
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
