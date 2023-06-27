package com.example.toys_servlet.controlls;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.toys_servlet.daos.OptionInforsDao;

@WebServlet(urlPatterns = "/optionInforSelectServlet")
public class OptionInforSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {  
            // 요청 매개변수에서 unique_id를 가져옵니다.
            String unique_id = request.getParameter("unique_id");

             // OptionInforsDao의 인스턴스를 생성합니다
            OptionInforsDao optionInforsDao = new OptionInforsDao();

             // selectUniqueId 메서드를 호출하여 unique_id를 기반으로 레코드를 검색합니다.
            HashMap<String, Object> optionInforRecord = optionInforsDao.SelectWithUniqueId(unique_id);

            // Generate the HTML content
            String contents = "<!DOCTYPE html>\r\n" +
                    "<html lang=\"en\">\r\n" +
                    "<head>\r\n" +
                    "    <meta charset=\"UTF-8\">\r\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" +
                    "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\">\r\n" +
                    "    <title>Document</title>\r\n" +
                    "</head>\r\n" +
                    "<body>\r\n" +
                    "    <div style=\"text-align:center;\">\r\n" +
                    "        <img class=\"mb-4\" src=\"https://i.namu.wiki/i/fmqo9BhDdF7UaaWj1u36bOCuOxoOCjFX78s7ZlHcIW63TzCUpuWU37aXQHwFbNeAVTasWMtTWJYSmUtlwGtT6Q.webp\" alt=\"\" width=\"200\" height=\"200\">\r\n" +
                    "        <h1 class=\"h3 mb-3 fw-normal\">상세정보</h1>\r\n" +
                    "    </div>\r\n" +
                    "\r\n" +
                    "    <div class=\"container\">\r\n" +
                    "        <table class=\"table table-bordered table-hover\">\r\n" +
                    "            <thead>\r\n" +
                    "                <tr>\r\n" +
                    "                    <th>RESPONDENTS_ID</th>\r\n" +
                    "                    <th>RESPONDENTS</th>\r\n" +
                    "                    <th>PASSWORD</th>\r\n" +
                    "                </tr>\r\n" +
                    "            </thead>\r\n" +
                    "            <tbody>\r\n" +
                    "                <form>\r\n" +
                    "                    <input type=\"hidden\" name=\"unique_id\" value=\"" + optionInforRecord.get("RESPONDENTS_ID") + "\">\r\n" +
                    "                    <tr>\r\n" +
                    "                        <td>\r\n" +
                    "                            " + optionInforRecord.get("RESPONDENTS_ID") + "\r\n" +
                    "                        </td>\r\n" +
                    "                        <td>\r\n" +
                    "                            " + optionInforRecord.get("RESPONDENTS") + "\r\n" +
                    "                        </td>\r\n" +
                    "                        <td>\r\n" +
                    "                            " + optionInforRecord.get("PASSWORD") + "\r\n" +
                    "                        </td>\r\n" +
                    "                    </tr>\r\n" +
                    "                </form>\r\n" +
                    "            </tbody>\r\n" +
                    "        </table>\r\n" +
                    "    </div>\r\n" +
                    "\r\n" +
                    "</body>\r\n" +
                    "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n" +
                    "\r\n" +
                    "</html>";

           // 응답 콘텐츠 타입을 HTML로 설정합니다.
            response.setContentType("text/html;charset=UTF-8");

            // HTML 콘텐츠를 응답에 작성합니다.
            PrintWriter printWriter = response.getWriter();
            printWriter.println(contents);
            printWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}