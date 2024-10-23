package hello.core.member;

public class MemberServiaceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMeberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
