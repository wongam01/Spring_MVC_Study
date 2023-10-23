package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/* 1. 파라미터 전송기능
http://localhost:8080/request-param?username=hello&age=20
*/
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class requestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("전체 파라미터 조회 - start");
        request.getParameterNames().asIterator() // asIterator 로 돌림
                .forEachRemaining(paramName -> System.out.println(paramName + " " + request.getParameter(paramName)));
        // forEachRemaining ->  현재 위치에서 시작하여 Iterator의 끝까지 각 요소에 대해 지정된 액션을 수행하게 함
        // paramName = key (username, age) , request.getParameter(paramName) -> key를 대입한 value값을 가져옴 (hello, 20)
        System.out.println("전체 파라미터 조회 - end");
        System.out.println();

        System.out.println("단일 파라미터 조회 - start");
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        String age = request.getParameter("age");
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("아름이 같은 복수 파라미터 조회");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }
        response.getWriter().write("ok");
        
    }
}
