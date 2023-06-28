<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.HashMap" %>
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
        <h1 class="h3 mb-3 fw-normal">설문통계</h1>
    </div>
    
    <div class="container">
        <% HashMap<String, Object> optionInforRecord = (HashMap<String, Object>) request.getAttribute("optionInforRecord"); %>
        <hr>
        <table class="table" style="width:300px; height :100px; margin-left:auto; margin-right:auto;" >
            <tbody>
                <tr>
                    <td>총 설문자 수</td>
                    <td><%= optionInforRecord.get("TotalCount") %></td>
                </tr>
                <tr>
                    <td>답항별 총 수</td>
                    <td><%= optionInforRecord.get("Choice") %></td>
                    <td><%= optionInforRecord.get("CNT") %></td>
                </tr>
                <tr>
                    <td>문항별 총 수</td>
                  <!-- <td><%= optionInforRecord.get("TotalCount") %></td> -->
                </tr>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>