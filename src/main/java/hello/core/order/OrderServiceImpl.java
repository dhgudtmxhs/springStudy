package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

// 인터페이스는 직접적으로 new연산자로 객체화 못함

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 등급 만 넘겨도 되긴 하는데 확장성 고려
        //  OrderService 인터페이스는 할인에 관여하지 않음 -> 단일책임원칙을 지킴

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
