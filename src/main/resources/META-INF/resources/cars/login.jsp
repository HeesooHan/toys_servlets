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
  <main class="container d-flex align-items-center justify-content-center vh-100">
    <div class="container login-window">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <form action="/Survey.jsp" method="post">
                  <div style="text-align: center;">
                    <img class="mb-4"
                      src="https://i.namu.wiki/i/fmqo9BhDdF7UaaWj1u36bOCuOxoOCjFX78s7ZlHcIW63TzCUpuWU37aXQHwFbNeAVTasWMtTWJYSmUtlwGtT6Q.webp"
                      alt="" width="200" height="200">
                  </div>
                    <div class="form-group">
                        <input class="form-control" type="text" name="RESPONDENTS_ID" placeholder="ID" id="idemail">
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="password" name="PASSWORDdi" placeholder="Password" id="idpassword">
                    </div>
                    <div style="text-align: center;">
                          <p></p>
                    <button type="submit" class="btn btn-dark " >LogIn</button>
                    </div>
                
                </form>
            </div>
        </div>
    </div>
  </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<% System.out.println("Login - doGet() done."); %>