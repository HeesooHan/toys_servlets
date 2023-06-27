<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.HashMap, java.util.ArrayList" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
            <title>Document</title>
        </head>

        <body>
            <div class="container">
            <img src="images/단추.png" width="100" height="60"alt="">
            <H1>회원정보</H1>
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>RESPONDENTS_ID</th>
                            <th>NAME</th>
                            <th>Select</th>
                        </tr>
                    </thead>
                    <% ArrayList optionInforList=new ArrayList<>();
                        optionInforList = (ArrayList)request.getAttribute("optionInforList");
                        %>
                        <tbody>
                            <% for(int i=0; i< optionInforList.size(); i=i+1) { %>
                                <% HashMap optionInforRecord=new HashMap<>();
                                    optionInforRecord = (HashMap) optionInforList.get(i);
                                    %>
                                    <form>
                                        <input type="hidden" name="unique_id" value="<%= optionInforRecord.get("RESPONDENTS_ID") %>">

                                        <tr>
                                            <td>
                                                <%= optionInforRecord.get("RESPONDENTS_ID") %>
                                            </td>
                                            <td>
                                                <%= optionInforRecord.get("RESPONDENTS") %>
                                            </td>
                                            <td>
                                                <button type="submit" formaction="/optionInforsSelectServlet">
                                                   상세정보
                                                </button>
                                            </td>
                                        </tr>
                                    </form>
                                    <% } %>
                        </tbody>
                </table>
            </div>
        </body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>

        </html>