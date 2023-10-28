package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); // 회원 정보 저장할 map

    private static long sequence = 0L; // 회원 아이디를 생성 하기 위한 시퀀스

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() { // 한번만 생성된 객체를 가져온다.
        return instance;
    }

    //  생성자 private 으로 만들어 접근을 막는다.
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // store 의 모든 값 다 꺼내서 새로운 ArrayList에 담아서 넘김 -> 밖에서 조작해도 store 의 값을 건들지 x
    }
    public void clearStore() {
        store.clear();
    }

}
