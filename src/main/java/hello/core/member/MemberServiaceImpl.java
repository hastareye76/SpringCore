package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiaceImpl implements MemberService {

    //DIP/OCP 위반을 해결하기 위해서 생성시 외부에 주입해 주도록 수정해 준다.
    //private final MemberRepository memberRepository = new MemoryMeberRepository();
    private MemberRepository memberRepository;

    //AppConfig 의 memberSerice 함수를 통해서 구현 실제 구현 객체가 설정된다.
    //의존성 주입 (생성자 주입) 이 작업을 AppConfig class 에서 해주고 있다.
    //하지만 AppConfig 설정 클래스 사용하지 않고  AutoAppConfig 를 사용할 경우 의존성 주입을 해주는 동작이 없다.
    //이를 위해서 Autowired annotation 을 사용한다.
    @Autowired
    public MemberServiaceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //Bean으로 등록된
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
