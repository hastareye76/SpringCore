package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class XmlAppContextTest {

    @Test
    void xmlAppContextTest() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        BeanDefinition beanDefinition;

        MemberService memberService = (MemberService) ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
