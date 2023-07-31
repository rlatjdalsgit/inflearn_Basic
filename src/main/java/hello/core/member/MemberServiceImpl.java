package hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
            //저장해줘야지 저장소에다가


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
}
