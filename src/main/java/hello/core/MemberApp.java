package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        // memberServiceImpl 객체를 생성하며 구현체를 매개변수로 넘김

        // 스프링 컨테이너
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
                                                            // AppConfig에있는 @Bean을 등록하고 관리해준다.

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
                                                                 // getBean(찾을 객체 이름, 타입) - 기본적으로 메서드 이름으로 등록됨

        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("join된 new 멤버 : " + member.getName());
        System.out.println("find한 new 멤버 : " + findMember.getName());

    }
//re
}
