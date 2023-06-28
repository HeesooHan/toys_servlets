<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
  .navbar {
      background-color: skyblue;
      padding-left: 15px;
      padding-right: 15px;
  }

  .nav-link {
      color: black;
  }

  .container {
      padding-left: 15px;
      padding-right: 15px;
  }

  .survey-buttons {
      text-align: center;
      margin-top: 15px;
      margin-bottom: 15px;
  }
</style>

<div class="container-fluid">
  <nav class="navbar navbar-expand">
      <div class="navbar-brand">
          <div class="navbar-nav me-auto">
              <a href="/Survey.jsp" class="nav-link">설문조사</a>
              <a href="/optionInforsJSPServlet" class="nav-link">회원관리</a>
              <a href="/statisticsServlet" class="nav-link">설문통계</a>
              <a href="/cars/login.jsp" class="nav-link">로그아웃</a>
          </div>
      </div>
  </nav>
</div>