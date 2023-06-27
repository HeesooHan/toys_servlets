package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.toys_servlet.commons.Commons;
import com.example.toys_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforsJSPServlet")
public class OptionInforsJSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try { 
            // 요청 파라미터에서 "search" 값을 가져온다
            String search = request.getParameter("search");

             // OptionInforsDao 객체를 생성하여 "search" 값을 이용하여 데이터베이스에서 검색을 수행한다
            OptionInforsDao optionInforsDao = new OptionInforsDao();
            ArrayList optionInforList = new ArrayList<>();
            optionInforList = optionInforsDao.SelectWithSearch(search);

             // request 객체에 검색어와 검색 결과를 저장한다
            request.setAttribute("search", search);
            request.setAttribute("optionInforList", optionInforList);

            //응답의 Content-Type을 설정하고 다음 JSP 파일을 호출하여 결과를 출력한다
            response.setContentType("text/html;charset=UTF-8");

            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cars/option_infors.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}