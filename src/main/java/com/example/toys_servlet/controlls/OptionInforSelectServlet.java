package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import com.example.toys_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforSelectServlet")
public class OptionInforSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {  
            // 요청 매개변수에서 unique_id를 가져옴
            String unique_id = request.getParameter("unique_id");

            // OptionInforsDao의 인스턴스를 생성
            OptionInforsDao optionInforsDao = new OptionInforsDao();

            // selectUniqueId 메서드를 호출하여 unique_id를 기반으로 레코드를 검색
            HashMap<String, Object> optionInforRecord = optionInforsDao.SelectWithUniqueId(unique_id);

            // optionInforRecord를 request 속성으로 설정
            request.setAttribute("optionInforRecord", optionInforRecord);

            // RequestDispatcher를 사용하여 detail_mem.jsp로 포워딩합니다.
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cars/detail_mem.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
