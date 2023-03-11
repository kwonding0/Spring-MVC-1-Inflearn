package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //[status-line]
        response.setStatus(HttpServletResponse.SC_OK); //응답코드 200
        //response.setStatus(HttpServletResponse.SC_BAD_REQUEST); //응답코드 400


        //[response-header]
        //response.setHeader("Content-Type","text/plain/charset=utf-8");
        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //캐시 무효화
        response.setHeader("Pragma", "no-cache"); //캐시 무효화(과거버전)
        response.setHeader("hi", "hello");

        content(response);

        cookie(response);

        redirect(response);

        response.getWriter().write("OK");
    }

    private void content(HttpServletResponse response) {
        //Content-Type: text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        //response.setContentLength(2); //(생략시 자동 생성)
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600"); //cookie도 setHeader에 넣어줄 수 있지만
        Cookie cookie = new Cookie("myCookie", "good"); //cookie관련 함수 지원함
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
        //maxAge 외의 값들은 tomcat이 넣어준 것
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html
        response.setStatus(HttpServletResponse.SC_FOUND); //302
        //response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
