package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//나 스프링 빈에다가 추가해줘 역할.
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
            //저장해줘야지 저장소에다가

    @Autowired //자동 의존관계 주입을 자동으로 연결해서 해줌.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //for test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
