package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*") //url 와일드카드 사용
public class FrontControllerServletV1 extends HttpServlet { //얘는 서블릿이여야 함

    private Map<String, ControllerV1> controllerMap = new HashMap<>(); //매핑정보

    public FrontControllerServletV1() { //매핑정보
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestURI = request.getRequestURI(); //ex: /front-controller/v1/members/new-form

        //인터페이스 사용해서 일관성있게 꺼낼 수 있음, 다형성에 의해서 인터페이스로 받을 수 있음. 부모가 Controller1이기 때문에
        //ControllerV1 controllerV1 = new MemberListControllerV1();
        ControllerV1 controllerV1 = controllerMap.get(requestURI);
        if(controllerV1 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV1.process(request, response);
    }
}
