package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    /**
     * 나의 궁금증
     * 1. discountFixAmount는 final로 해줘도 되는 거 아닌가?
     * 2. 전역 변수보다는 지역변수인 게 낫지 않을까? -> 3번 이유처럼 다른 메서드에서도 써야하니까 전역변수로 쓴 것
     * 3. return 1000; 하지 않고 변수로 리턴해주는 이유는 뭘까? -> 할인가가 달라지면? 한 번에 수정할 수 있잖아
     */
    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
