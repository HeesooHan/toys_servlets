package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// helloWorldJSPServlet?company=YoJuLab
@WebServlet(urlPatterns = "/helloWorldJSPServlet")
public class HelloWorldJSPServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 요청 파라미터에서 "company"의 값을 가져온다
            String contents = request.getParameter("company");

              // 요청 속성에 "contents"라는 이름으로 값을 설정한다
            request.setAttribute("contents", contents);

            // 다음 JSP 파일을 호출하여 응답으로 전송한다
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/helloworldJSP.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
