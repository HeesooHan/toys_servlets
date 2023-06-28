package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.toys_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/statisticsServlet")
public class StatisticsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 요청 파라미터에서 "unique_id"의 값을 가져온다
            String unique_id = request.getParameter("unique_id");

            // OptionInforsDao 객체를 생성하여 "unique_id"를 이용하여 레코드를 삭제한다
            OptionInforsDao optionInforsDao = new OptionInforsDao();
            int count = OptionInforsDao.Statistics();

            // 응답의 Content-Type을 설정하고 PrintWriter를 이용하여 응답을 생성한다
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter printWriter = response.getWriter();
            String contents= "SELECT COUNT(DISTINCT RESPONDENTS_ID) AS TotalCount\r\n" + //
                            "FROM statistics;";
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
