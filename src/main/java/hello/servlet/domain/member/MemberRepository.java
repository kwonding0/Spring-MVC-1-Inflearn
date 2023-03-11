package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    //MemberRepository가 많아도 하나만 생성됨
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //id 증가 시퀀스
    //지금은 Spring을 안쓸거기떄문에 private 으로 싱글톤

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository() {

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(long id){
        return store.get(id);
    }

    //store에 있는 value를 건들고 싶지 않아서 ArrayList에 담아서 사용
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}

