package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRespositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance(); // 테스트 할 대상

    // test 끝날때마다 초기화
    @AfterEach
    void afterEach() {
        memberRepository.clearStore(); //
    }

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }
}
