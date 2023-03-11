package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberFromServlet",urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFromServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp"; //외부에서 호출되지 않고, Controller에서만 호출되고 싶으면 WEB-INF에 만들어야함 (WAS 룰)
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); //controller에서 view로 이동해야 될 때 사용
        //servlet에서 jsp 호출, 다른 서블릿이나 jsp로 이동할 수 있는 기능
        dispatcher.forward(request,response);



    }
}
