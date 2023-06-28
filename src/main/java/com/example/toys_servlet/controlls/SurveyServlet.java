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
@WebServlet(urlPatterns = "/surveyServlet")
public class SurveyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the login page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Survey.jsp");
        dispatcher.forward(request, response);
    }
}   
