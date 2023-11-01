package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1.
@WebServlet(name = "FrontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    // 매핑 정보 만들기 key = url
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() { // 생성자를 통해 값을 초기화 (컨트롤러 매핑)
        controllerMap.put("/front-controller/v1/mebers/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/mebers/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/mebers", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        // 로직 만들기  http://localhost:8080/front-controller/v1/members/new-form 가 들어오면

        // requestURI 에 /front-controller/v1/members/new-form 을 받을 수 있음
        String requestURI = request.getRequestURI();

        ControllerV1 controller = controllerMap.get(requestURI); //  new MemberFormControllerV1() 객체 인스턴스 반환

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(request, response);
    }
}
