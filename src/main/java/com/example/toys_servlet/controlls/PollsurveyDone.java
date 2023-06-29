package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.toys_servlet.daos.PollsDao;

@WebServlet(urlPatterns = "/poll/SurveyDone")
public class PollsurveyDone extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            HashMap<String, Object> map = new HashMap<String, Object>();
    
            Enumeration<String> enumber = request.getParameterNames();
            //pring params
            while (enumber.hasMoreElements()) {
                String key = enumber.nextElement().toString();
                String value = request.getParameter(key);
                System.out.println(key+","+value);
                map.put(key, value);  
            }
            
             PollsDao pollsDao = new PollsDao();
            pollsDao.Insert(map);

            // //Print Map
            // for(String key : map.keySet()){
            //     System.out.print(key+""+map.get(key));
            // }
            // 다음 파일 호출
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/simples.jsp");
            requestDispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}