package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/getRequestParamsServlet")
public class GetRequestParamsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try { // 요청 파라미터에서 "first_name"과 "second_name"의 값을 가져온다
            String firstName = request.getParameter("first_name");
            String secondName = request.getParameter("second_name");
            PrintWriter printWriter = response.getWriter();
             // 응답으로 전송할 HTML 문자열 생성
            String contents = "<!DOCTYPE html>\r\n" +
                    "<html lang=\"en\">\r\n" +
                    "<head>\r\n" +
                    "    <meta charset=\"UTF-8\">\r\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" +
                    "    <title>Hello World !</title>\r\n" +
                    "</head>\r\n" +
                    "<body>\r\n" +
                    "    <div>\r\n" +
                    "        First Name: " + firstName + "</div>\r\n" +
                    "    <div>\r\n" +
                    "        Second Name: " + secondName + "</div>\r\n" +
                    "</body>\r\n" +
                    "</html>";
            // 응답으로 HTML 내용을 클라이언트에게 전송
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
