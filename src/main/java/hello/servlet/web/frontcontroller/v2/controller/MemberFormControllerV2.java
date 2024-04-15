package hello.servlet.web.frontcontroller.v2.controller;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override // MyView 를 반환하고, MyView 에서는 forward 를 통해 jsp 반환
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청을 처리하고 해당하는 jsp 경로를 반환
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
