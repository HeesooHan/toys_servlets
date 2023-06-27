<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% System.out.println("Login - doGet()"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap Template</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css">
    <link rel="stylesheet" href="../static/css/commons.css">
</head>  
<body>

      <div class="container login-window">
        <div class="row">
          <div class="col-md-6 offset-md-3">
            <h2>Login</h2>

            <form action="/session/CreateServlet" method="post">
              <div class="form-group">
                <input class="form-control" type="text" name="email" placeholder="Email address" id="idemail">
              </div>
              <div class="form-group">
                <input class="form-control" type="password" name="password" placeholder="Password" id="idpassword">
              </div>
              <button type="submit" class="btn btn-primary">LogIn</button>
            </form>
          </div>
        </div>
      </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</html>
<% System.out.println("Login - doGet() done."); %>