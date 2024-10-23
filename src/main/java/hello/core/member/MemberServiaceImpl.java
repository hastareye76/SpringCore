package hello.core.member;

public class MemberServiaceImpl implements MemberService {

    //DIP/OCP 위반을 해결하기 위해서 생성시 외부에 주입해 주도록 수정해 준다.
    //private final MemberRepository memberRepository = new MemoryMeberRepository();

    private MemberRepository memberRepository;

    //AppConfig 의 memberSerice 함수를 통해서 구현 실제 구현 객체가 설정된다.
    //의존성 주입 (생성자 주입)
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
}
