package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public interface ControllerV3 {
   // V2 : MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
    ModelView process (Map<String, String> paramMap); // 요청 파라미터를 Map으로 받고 , ModelView로 반환


}
