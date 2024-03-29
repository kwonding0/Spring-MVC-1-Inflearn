package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan //스프링이 자동으로 현재 패키지를 포함한 하위패키지에서 서블릿을 다 찾아서 등록해서 실행할 수 있게 해줌 ( 서블릿 자동등록 )
@SpringBootApplication //해당 어노테이션이 있는 어플리케이션을 실행시키면 됨(was대체)
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

	/*@Bean //스프링부트가 자동으로 해당 코드처럼 해줌
	ViewResolver internalResourceViewResolver(){
		return new InternalResourceViewResolver("/WEB-INF/",".jsp");
	}*/
}
