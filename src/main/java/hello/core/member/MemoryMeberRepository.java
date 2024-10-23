package hello.core.member;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

public class MemoryMeberRepository implements MemberRepository {

    //여러곳에 동시에 접근이 가능한 저장소라서 테스트 이지만 ConcurrentHashMap 을 사용해야 하지만 강사가
    //그냥 진행함.
    //https://devlog-wjdrbs96.tistory.com/269
    private static Map<Long, Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
