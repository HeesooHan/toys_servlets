package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/session/DeleteServlet")
public class SessionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession httpSession = request.getSession();
            httpSession.invalidate();    // 서버 측에서 현재 세션 무효화

            // delete cookies
            Cookie[] cookies = request.getCookies(); // 요청에 포함된 모든 쿠키 가져오기
            for (Cookie cookie : cookies) {
                String name = cookie.getName(); // 쿠키의 이름 가져오기
                String value = cookie.getValue(); // 쿠키의 값 가져오기
                if (name.equals("JSESSIONID")) { // 쿠키 삭제 -> Client side / JSESSIONID라는 이름의 쿠키를 찾음
                    cookie.setMaxAge(0); // 쿠키의 유효 시간을 0으로 설정하여 삭제
                    response.addCookie(cookie); // 응답에 쿠키 추가하여 삭제
                }
            }

            PrintWriter printWriter = response.getWriter(); // 응답으로부터 PrintWriter 객체 가져오기
            String contents = "<div>Logout !</div>"; // 출력할 내용 설정
            printWriter.println(contents); // 내용을 응답에 출력
            printWriter.close(); // 출력 종료
        } catch (Exception e) {
            System.out.println(e.getMessage()); // 예외 발생 시 에러 메시지 출력
        }
        }
    }
