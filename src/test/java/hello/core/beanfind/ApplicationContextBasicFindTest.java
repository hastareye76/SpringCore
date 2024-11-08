package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberServiaceImpl;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import static org.assertj.core.api.Assertions.assertThat;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = (MemberService) ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiaceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = (MemberService) ac.getBean( MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiaceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiaceImpl memberService = ac.getBean("memberService",
                MemberServiaceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiaceImpl.class);
    }
}
