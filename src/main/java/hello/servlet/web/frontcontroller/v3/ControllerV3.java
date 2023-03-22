package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap); //서블릿 기술(HTTPRequset, HTTPResponse) 사용하지 않음. 서블릿에 종속하지않음
}
