package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="helloServlet", urlPatterns = "/hello") //참고로 name, urlPatterns는 겹치면 안됨
public class HelloServlet extends HttpServlet {

    @Override //protected : 이 서블릿이 호출되면 service method가 호출됨
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //서블릿 컨테이너가 오면 서버가 서블릿 reponse 객체를 만들어서 이 servlet에 던져줌
        //1.web브라우저가 서버에 http 요청 메세지를 보냄 (이 때 요청 request, 응답 response)
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        //org.apache.catalina.connector.RequestFacade@17c8737c
        // request, response 는 인터페이스
        // was 서버가 servlet 표준 스펙을 구현한 것
        System.out.println("response = " + response);

        // http://localhost:8080/hello?username=jin 여기서 ?뒤에 변수를 쿼리 파라미터라고 하는데, 이 쿼리 파라미터를 서블릿은 굉장히 편하게 읽게 해줌
        // 만약에 HTTP 데이터를 다 parshing 해서 읽었으면 굉장히 복잡했을 것
        // 이렇게 자주쓰는 기능들을 servlet이 편리하게 많이 도와줌.
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //응답은 response에 담아서!
        response.setContentType("text/plain"); //단순문자
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello JIN"); //getWriter -> http message body에 데이터가 들어감, 상위 두개는 content-type 헤더에 들어감

    }
}
