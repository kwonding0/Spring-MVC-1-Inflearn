package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//Junit4는 public 있어야되는데 Junit5부터는 public 없어도됨
class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    //테스트를 끝날때마다 테스트를 초기화하기 위함
    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){ //저장 테스트
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member savedMember = memberRepository.findById(saveMember.getId());
        assertThat(saveMember).isEqualTo(savedMember); //두개가 같은지 저장이 잘되고있는지 체크
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        //when
        memberRepository.save(member1);
        memberRepository.save(member2);

        //then
        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2); //두개가 저장됬는지 확인
        assertThat(result).contains(member1, member2); //member1, member2 가 다 들어있는지 확인
    }

}
