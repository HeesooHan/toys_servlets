<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0 ">
        <title>Bootstrap Main</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.css">
        <link rel="stylesheet" href="../static/css/commons.css">

    <body>
        <%@ include file="/top_menus.jsp" %>
        <br>
        <div class="container">
            <p><strong>제목:</strong> 2023학년도 봄학기 대학원 학습자 만족도 및 튜터평가 설문 조사</p>
            <p><strong>설명:</strong> 강의만족도 조사</p>
            <p><strong>기간:</strong> 2023.6.27 ~ 2023.6.29</p>
        </div>
        <hr>
        <div class="container">
            <form action="Survey.jsp">
                <div class="row">
                    <h5>Q1. 교수는 수업 전 강의 목표를 명확히 제시하였습니까?</h5>
                    <div class="card-body">
                        <div class="m-3 form-check">
                            <input type="radio" name="q1" value="not-at-all" class="form-check-input">
                            <label class="form-check-label">전혀 아니다</label>
                        </div>
                        <div class="m-3 form-check">
                            <input type="radio" name="q1" value="no" class="form-check-input">
                            <label class="form-check-label">아니다</label>
                        </div>
                        <div class="m-3 form-check">
                            <input type="radio" name="q1" value="yes" class="form-check-input">
                            <label class="form-check-label">그렇다</label>
                        </div>
                        <div class="m-3 form-check">
                            <input type="radio" name="q1" value="very-much" class="form-check-input">
                            <label class="form-check-label">매우 그렇다</label>
                        </div>
                        <p></p>
                        <h5>Q2. 강의의 내용은 체계적이고 성의있게 구성되었는가?</h5>
                        <div class="card-body">
                            <div class="m-3 form-check">
                                <input type="radio" name="q2" value="not-at-all" class="form-check-input">
                                <label class="form-check-label">전혀 아니다</label>
                            </div>
                            <div class="m-3 form-check">
                                <input type="radio" name="q2" value="no" class="form-check-input">
                                <label class="form-check-label">아니다</label>
                            </div>
                            <div class="m-3 form-check">
                                <input type="radio" name="q2" value="yes" class="form-check-input">
                                <label class="form-check-label">그렇다</label>
                            </div>
                            <div class="m-3 form-check">
                                <input type="radio" name="q2" value="very-much" class="form-check-input">
                                <label class="form-check-label">매우 그렇다</label>
                            </div>
                            <p></p>
                            <h5>Q3. 교수는 강의 내용에 대해 전문적 지식이 있었는가?</h5>
                            <div class="card-body">
                                <div class="m-3 form-check">
                                    <input type="radio" name="q3" value="not-at-all" class="form-check-input">
                                    <label class="form-check-label">전혀 아니다</label>
                                </div>
                                <div class="m-3 form-check">
                                    <input type="radio" name="q3" value="no" class="form-check-input">
                                    <label class="form-check-label">아니다</label>
                                </div>
                                <div class="m-3 form-check">
                                    <input type="radio" name="q3" value="yes" class="form-check-input">
                                    <label class="form-check-label">그렇다</label>
                                </div>
                                <div class="m-3 form-check">
                                    <input type="radio" name="q3" value="very-much" class="form-check-input">
                                    <label class="form-check-label">매우 그렇다</label>
                                </div>
                                <p></p>
                                <h5>Q4. 강의 진행 속도는 적절하였는가?</h5>
                                <div class="card-body">
                                    <div class="m-3 form-check">
                                        <input type="radio" name="q4" value="not-at-all" class="form-check-input">
                                        <label class="form-check-label">전혀 아니다</label>
                                    </div>
                                    <div class="m-3 form-check">
                                        <input type="radio" name="q4" value="no" class="form-check-input">
                                        <label class="form-check-label">아니다</label>
                                    </div>
                                    <div class="m-3 form-check">
                                        <input type="radio" name="q4" value="yes" class="form-check-input">
                                        <label class="form-check-label">그렇다</label>
                                    </div>
                                    <div class="m-3 form-check">
                                        <input type="radio" name="q4" value="very-much" class="form-check-input">
                                        <label class="form-check-label">매우 그렇다</label>
                                    </div>

                                    <div class="survey-buttons">
                                        <button type="submit" class="btn btn-dark " >닫기</button>
                                        <button type="submit" class="btn btn-dark " >설문제출</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>