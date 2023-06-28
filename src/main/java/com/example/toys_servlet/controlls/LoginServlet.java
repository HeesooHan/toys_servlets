package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// /session/CreateServlet?username=yojulab&password=1234
@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cars/login.jsp");
        dispatcher.forward(request, response);
    }

   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
        try {

            // 쿼리에서 파라미터 값을 가져옵니다.
            String respondentsId = request.getParameter("RESPONDENTS_ID");
            String password = request.getParameter("PASSWORD");

 
            // 출력하기 위해 PrintWriter 객체를 가져옵니다.
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<div>Create Session Servlets</div>");
            // login 세션 가져오기

            HttpSession httpSession = request.getSession(false);
            String usernameSession = (String) httpSession.getAttribute("username"); /*username까지 확인해줘야함 */
            if (httpSession != null && usernameSession !=null) { // JSESSION 있음 - 로그인 되었다는 표시      
                printWriter.println("<div>username : "+usernameSession+"</div>");
                 printWriter.close();
            } else { // 세션이 존재하지 않으면 로그인
                if ("R004".equals(respondentsId) && "4444".equals(password)) {  //하드코딩된 사용자명과 비밀번호를 사용하고 있습니다.
                     // 새로운 세션을 생성하고 사용자 정보를 세션에 저장함
                    httpSession = request.getSession();
                    httpSession.setAttribute("respondentsId", respondentsId);
                    httpSession.setAttribute("password", password);
                    //printWriter.println("<div>" + username + ", " + password + "</div>");
                   
                    // response.sendRedirect("/설문조사페이지")
                   response.sendRedirect("/Survey.jsp");
                } else {
                    response.sendRedirect("/cars/login.jsp");
                    //response.sendRedirect("/cars/Survey.jsp");
                }
            }
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
