package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    //frontController가 Model까지 만들어서 보내줌, 개발자는 해당 모델에 데이터를 put하면 됨
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
