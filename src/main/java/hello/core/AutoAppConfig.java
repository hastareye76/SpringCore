package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//설정정보이므로 @Configuration 을 넣어준다.  @ComponentScan 지정된 모든 내용을 스프링 bean 으로 등록해주기 위해서 사용한다.
@Configuration
@ComponentScan(
        //스캔을 시작할 대상의 path를 지정해 줄 수 있다.
        //basePackages = "hello.core.member", // <-- AutoAppConifg 클래스에서 Bean을 등록해주기 위해서 scan 하는 root path 를 지정.
        //AutoAppConfig class 자체는 spring bean 으로 등록되는 것을 방지하기 위해서 filter를 걸었다.
        //클래스 자체에 @Configuration annotation 으로 지정되어 있으므로 Configuration.class 는 AutoAppConfig class
        //자체를 가르킨다고 보면 된다.
        //@Component annotation을 달고 있는 클래스를 읽어와서 Bean으로 등록해준다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
