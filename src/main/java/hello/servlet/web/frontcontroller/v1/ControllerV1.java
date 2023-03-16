package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* HTTP요청이 올때 매핑정보에서 찾아서 컨트롤러를 호출할 때 일관성있게 다형성을 사용해서 FrontController는 인터페이스를 의존하면서 편리하게 호출할 수 있음
* */
public interface ControllerV1 { //서블릿이랑 모양이 같은 인터페이스 생성

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
