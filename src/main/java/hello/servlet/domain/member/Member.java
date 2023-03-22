package hello.servlet.domain.member;

import lombok.*;

@Getter
@Setter

public class Member {

    private Long id;
    private String username;
    private int age;

    public Member(){

    }

    public Member(String username, int age){
        this.username = username;
        this.age = age;
    }


}


/*
@RequiredArgsConstructor //private를 변수로 가지는 생성자 생성
@AllArgsConstructor
@NoArgsConstructor
class Jean{
    public String name;
    public String age;
    private String name2;


}

class Main{

    public void main(){
        Jean e = new Jean();
        Jean a = new Jean("jean","19","jin");
    }
}*/


class Main2{

    public void main(){
         MemberRepository repo = MemberRepository.getInstance();
    }
}
