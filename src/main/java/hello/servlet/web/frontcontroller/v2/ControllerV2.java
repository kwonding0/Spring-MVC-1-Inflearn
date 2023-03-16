package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    //현재 모든 컨트롤러가 뷰를 반환하고 있기 때문에 MyView로 반환
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
