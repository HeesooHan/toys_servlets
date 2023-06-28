package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.toys_servlet.commons.Commons;
import com.example.toys_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/surveyServlet")
public class SurveyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

           // 요청 파라미터에서 "search" 값을 가져온다
            String search = request.getParameter("search");

          // HTML 문자열을 생성한다
            String contents = "<!DOCTYPE html>\r\n" + //
                    "<html lang=\"en\">\r\n" + //
                    "\r\n" + //
                    "<head>\r\n" + //
                    "    <meta charset=\"UTF-8\">\r\n" + //
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + //
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0 \">\r\n" + //
                    "    <title>Bootstrap Main</title>\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css\">\r\n" + //
                    "    <link rel=\"stylesheet\" href=\"../static/css/commons.css\">\r\n" + //
                    "    <style>\r\n" + //
                    "        .navbar {\r\n" + //
                    "            background-color: skyblue;\r\n" + //
                    "            padding-left: 15px;\r\n" + //
                    "            padding-right: 15px;\r\n" + //
                    "        }\r\n" + //
                    "\r\n" + //
                    "        .nav-link {\r\n" + //
                    "            color: black;\r\n" + //
                    "        }\r\n" + //
                    "\r\n" + //
                    "        .container {\r\n" + //
                    "            padding-left: 15px;\r\n" + //
                    "            padding-right: 15px;\r\n" + //
                    "        }\r\n" + //
                    "\r\n" + //
                    "        .survey-buttons {\r\n" + //
                    "            text-align: center;\r\n" + //
                    "            margin-top: 15px;\r\n" + //
                    "            margin-bottom: 15px;\r\n" + //
                    "        }\r\n" + //
                    "    </style>\r\n" + //
                    "</head>\r\n" + //
                    "\r\n" + //
                    "<body>\r\n" + //
                    "    <div class=\"container-fluid\">\r\n" + //
                    "        <nav class=\"navbar navbar-expand\">\r\n" + //
                    "            <div class=\"navbar-brand\">\r\n" + //
                    "                <div class=\"navbar-nav me-auto\">\r\n" + //
                    "                    <a href=\"Survey.html\" class=\"nav-link\">\uC124\uBB38\uD558\uAE30</a>\r\n" + //
                    "                    <a href=\"option_infors.jsp\" class=\"nav-link\">\uD68C\uC6D0\uAD00\uB9AC</a>\r\n" + //
                    "                    <a href=\"statistics.html\" class=\"nav-link\">\uC124\uBB38\uD1B5\uACC4</a>\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "            <button onclick=\"location.href='login.html'\" class=\"btn ms-auto \" style=\"float: right;\">\uB85C\uADF8\uC778</button>\r\n" + //
                    "        </nav>\r\n" + //
                    "    </div>\r\n" + //
                    "    <br>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <p><strong>\uC81C\uBAA9:</strong> 2023\uD559\uB144\uB3C4 \uBD04\uD559\uAE30 \uB300\uD559\uC6D0 \uD559\uC2B5\uC790 \uB9CC\uC871\uB3C4 \uBC0F \uD29C\uD130\uD3C9\uAC00 \uC124\uBB38 \uC870\uC0AC</p>\r\n" + //
                    "        <p><strong>\uC124\uBA85:</strong> \uAC15\uC758\uB9CC\uC871\uB3C4 \uC870\uC0AC</p>\r\n" + //
                    "        <p><strong>\uAE30\uAC04:</strong> 2023.6.27 ~ 2023.6.29</p>\r\n" + //
                    "    </div>\r\n" + //
                    "    <br>\r\n" + //
                    "    <div class=\"container\">\r\n" + //
                    "        <form action=\"Survey.html\">\r\n" + //
                    "            <div class=\"row\">\r\n" + //
                    "                <h5>Q1. \uAD50\uC218\uB294 \uC218\uC5C5 \uC804 \uAC15\uC758 \uBAA9\uD45C\uB97C \uBA85\uD655\uD788 \uC81C\uC2DC\uD558\uC600\uC2B5\uB2C8\uAE4C?</h5>\r\n" + //
                    "                <div class=\"card-body\">\r\n" + //
                    "                    <div class=\"m-3 form-check\">\r\n" + //
                    "                        <input type=\"radio\" name=\"q1\" value=\"not-at-all\" class=\"form-check-input\">\r\n" + //
                    "                        <label class=\"form-check-label\">\uC804\uD600 \uC544\uB2C8\uB2E4</label>\r\n" + //
                    "                    </div>\r\n" + //
                    "                    <div class=\"m-3 form-check\">\r\n" + //
                    "                        <input type=\"radio\" name=\"q1\" value=\"no\" class=\"form-check-input\">\r\n" + //
                    "                        <label class=\"form-check-label\">\uC544\uB2C8\uB2E4</label>\r\n" + //
                    "                    </div>\r\n" + //
                    "                    <div class=\"m-3 form-check\">\r\n" + //
                    "                        <input type=\"radio\" name=\"q1\" value=\"yes\" class=\"form-check-input\">\r\n" + //
                    "                        <label class=\"form-check-label\">\uADF8\uB807\uB2E4</label>\r\n" + //
                    "                    </div>\r\n" + //
                    "                    <div class=\"m-3 form-check\">\r\n" + //
                    "                        <input type=\"radio\" name=\"q1\" value=\"very-much\" class=\"form-check-input\">\r\n" + //
                    "                        <label class=\"form-check-label\">\uB9E4\uC6B0 \uADF8\uB807\uB2E4</label>\r\n" + //
                    "                    </div>\r\n" + //
                    "                    <p></p>\r\n" + //
                    "                    <h5>Q2. \uAC15\uC758\uC758 \uB0B4\uC6A9\uC740 \uCCB4\uACC4\uC801\uC774\uACE0 \uC131\uC758\uC788\uAC8C \uAD6C\uC131\uB418\uC5C8\uB294\uAC00?</h5>\r\n" + //
                    "                    <div class=\"card-body\">\r\n" + //
                    "                        <div class=\"m-3 form-check\">\r\n" + //
                    "                            <input type=\"radio\" name=\"q2\" value=\"not-at-all\" class=\"form-check-input\">\r\n" + //
                    "                            <label class=\"form-check-label\">\uC804\uD600 \uC544\uB2C8\uB2E4</label>\r\n" + //
                    "                        </div>\r\n" + //
                    "                        <div class=\"m-3 form-check\">\r\n" + //
                    "                            <input type=\"radio\" name=\"q2\" value=\"no\" class=\"form-check-input\">\r\n" + //
                    "                            <label class=\"form-check-label\">\uC544\uB2C8\uB2E4</label>\r\n" + //
                    "                        </div>\r\n" + //
                    "                        <div class=\"m-3 form-check\">\r\n" + //
                    "                            <input type=\"radio\" name=\"q2\" value=\"yes\" class=\"form-check-input\">\r\n" + //
                    "                            <label class=\"form-check-label\">\uADF8\uB807\uB2E4</label>\r\n" + //
                    "                        </div>\r\n" + //
                    "                        <div class=\"m-3 form-check\">\r\n" + //
                    "                            <input type=\"radio\" name=\"q2\" value=\"very-much\" class=\"form-check-input\">\r\n" + //
                    "                            <label class=\"form-check-label\">\uB9E4\uC6B0 \uADF8\uB807\uB2E4</label>\r\n" + //
                    "                        </div>\r\n" + //
                    "                        <p></p>\r\n" + //
                    "                        <h5>Q3. \uAD50\uC218\uB294 \uAC15\uC758 \uB0B4\uC6A9\uC5D0 \uB300\uD574 \uC804\uBB38\uC801 \uC9C0\uC2DD\uC774 \uC788\uC5C8\uB294\uAC00?</h5>\r\n" + //
                    "                        <div class=\"card-body\">\r\n" + //
                    "                            <div class=\"m-3 form-check\">\r\n" + //
                    "                                <input type=\"radio\" name=\"q3\" value=\"not-at-all\" class=\"form-check-input\">\r\n" + //
                    "                                <label class=\"form-check-label\">\uC804\uD600 \uC544\uB2C8\uB2E4</label>\r\n" + //
                    "                            </div>\r\n" + //
                    "                            <div class=\"m-3 form-check\">\r\n" + //
                    "                                <input type=\"radio\" name=\"q3\" value=\"no\" class=\"form-check-input\">\r\n" + //
                    "                                <label class=\"form-check-label\">\uC544\uB2C8\uB2E4</label>\r\n" + //
                    "                            </div>\r\n" + //
                    "                            <div class=\"m-3 form-check\">\r\n" + //
                    "                                <input type=\"radio\" name=\"q3\" value=\"yes\" class=\"form-check-input\">\r\n" + //
                    "                                <label class=\"form-check-label\">\uADF8\uB807\uB2E4</label>\r\n" + //
                    "                            </div>\r\n" + //
                    "                            <div class=\"m-3 form-check\">\r\n" + //
                    "                                <input type=\"radio\" name=\"q3\" value=\"very-much\" class=\"form-check-input\">\r\n" + //
                    "                                <label class=\"form-check-label\">\uB9E4\uC6B0 \uADF8\uB807\uB2E4</label>\r\n" + //
                    "                            </div>\r\n" + //
                    "                            <p></p>\r\n" + //
                    "                            <h5>Q4. \uAC15\uC758 \uC9C4\uD589 \uC18D\uB3C4\uB294 \uC801\uC808\uD558\uC600\uB294\uAC00?</h5>\r\n" + //
                    "                            <div class=\"card-body\">\r\n" + //
                    "                                <div class=\"m-3 form-check\">\r\n" + //
                    "                                    <input type=\"radio\" name=\"q4\" value=\"not-at-all\" class=\"form-check-input\">\r\n" + //
                    "                                    <label class=\"form-check-label\">\uC804\uD600 \uC544\uB2C8\uB2E4</label>\r\n" + //
                    "                                </div>\r\n" + //
                    "                                <div class=\"m-3 form-check\">\r\n" + //
                    "                                    <input type=\"radio\" name=\"q4\" value=\"no\" class=\"form-check-input\">\r\n" + //
                    "                                    <label class=\"form-check-label\">\uC544\uB2C8\uB2E4</label>\r\n" + //
                    "                                </div>\r\n" + //
                    "                                <div class=\"m-3 form-check\">\r\n" + //
                    "                                    <input type=\"radio\" name=\"q4\" value=\"yes\" class=\"form-check-input\">\r\n" + //
                    "                                    <label class=\"form-check-label\">\uADF8\uB807\uB2E4</label>\r\n" + //
                    "                                </div>\r\n" + //
                    "                                <div class=\"m-3 form-check\">\r\n" + //
                    "                                    <input type=\"radio\" name=\"q4\" value=\"very-much\" class=\"form-check-input\">\r\n" + //
                    "                                    <label class=\"form-check-label\">\uB9E4\uC6B0 \uADF8\uB807\uB2E4</label>\r\n" + //
                    "                                </div>\r\n" + //
                    "\r\n" + //
                    "                                <div class=\"survey-buttons\">\r\n" + //
                    "                                    <button onclick=\"ans_chek()\" class=\"btn btn-info\">\uB2EB\uAE30</button>\r\n" + //
                    "                                    <button onclick=\"ans_chek()\" class=\"btn btn-info\">\uC124\uBB38\uC81C\uCD9C</button>\r\n" + //
                    "                                </div>\r\n" + //
                    "                            </div>\r\n" + //
                    "                        </div>\r\n" + //
                    "                    </div>\r\n" + //
                    "                </div>\r\n" + //
                    "            </div>\r\n" + //
                    "        </form>\r\n" + //
                    "    </div>\r\n" + //
                    "</body>";
            OptionInforsDao optionInforsDao = new OptionInforsDao();
            ArrayList optionInforList = new ArrayList<>();
            optionInforList = optionInforsDao.SelectWithSearch(search);

            for(int i=0; i< optionInforList.size(); i=i+1) {
                HashMap optionInforRecord = new HashMap<>();
                optionInforRecord = (HashMap) optionInforList.get(i);
                contents = contents + "                <tr>\r\n" + //
                        "                    <td>"+optionInforRecord.get("RESPONDENTS_ID")+"</td>\r\n" + //
                        "                    <td>"+optionInforRecord.get("RESPONDENTS")+"</td>\r\n" + //
                        "                </tr>\r\n";
            }
            contents = contents + "            </tbody>\r\n" + //
                    "        </table>\r\n" + //
                    "    </div>\r\n" + //
                    "\r\n" + //
                    "</body>\r\n" + //
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
                    + //
                    "\r\n" + //
                    "</html>";
            // getWriter 전에 charset 하기
            response.setContentType("text/html;charset=UTF-8");

            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}