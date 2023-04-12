package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    //@RequestMapping(value="/new-form", method = RequestMethod.GET) //GET, POST 구분 추가
    @GetMapping("/new-form")
    public String newForm(){
        return "new-form"; //어노테이션 기반 controlller는 인터페이스로 설계되어서 유연하기 떄문에 string, ModelAndView 등으로 반환해도 됨
    }

    //@RequestMapping(value="/save", method = RequestMethod.POST) //GET은 조회하는거니까 POST로
    @PostMapping("/save")
    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model) { //request, response, pamameter도 받을 수 있음
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member",member);
        return "save-result";
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "members";
    }
}
