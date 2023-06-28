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
            <%@ include file="/top_menus.jsp" %>
            <div style="text-align:center;">
                <img class="mb-4" src="https://i.namu.wiki/i/fmqo9BhDdF7UaaWj1u36bOCuOxoOCjFX78s7ZlHcIW63TzCUpuWU37aXQHwFbNeAVTasWMtTWJYSmUtlwGtT6Q.webp" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">회원정보</h1> 
            </div>
            <div class="container">
                <% String search=(String) request.getAttribute("search"); %>
                    <form action="/optionInforsJSPServlet">
                        <label>검색
                            <input type="text" name="search" value="<%= search %>">
                        </label>
                        <button class="btn btn-outline-dark"  >검색 하기</button>
                    </form> 
                    <P></P>
            </div>

            <div class="container">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>RESPONDENTS_ID</th>
                            <th>NAME</th>
                            <th>상세정보</th>
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
                                                
                                                <button class="btn btn-outline-dark"type="submit" formaction="/optionInforSelectServlet">
                                                    <%= optionInforRecord.get("RESPONDENTS") %> 상세정보
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