<%-- 
    Document   : doashboard
    Created on : Jun 9, 2023, 2:51:01 PM
    Author     : Dell
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.Course" %>
<% 
    String name = (String) request.getAttribute("name");
    String picture = (String) request.getAttribute("picture");
    
     ArrayList<Course> enrolledCourses = new ArrayList<>();
    if (request.getAttribute("enrolledCourses") != null)
        enrolledCourses = (ArrayList<Course>) request.getAttribute("enrolledCourses");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>CMS - Course Management System</title>
        <link rel="shortcut icon" href="https://cmshn.fpt.edu.vn/theme/image.php/trema/theme/1684246329/favicon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
            />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="hamburger-menu">
            <input id="menu__toggle" type="checkbox" />
            <label class="menu__btn" for="menu__toggle">
                <span></span>
            </label>
            <img src="https://cmshn.fpt.edu.vn/pluginfile.php/1/core_admin/logocompact/0x70/1684246329/2020-FPTU-Eng.png" alt="logo" style="width: 100px; height: 27px">
            <label for="cars" class="fa fa-mortar-board" style="margin-left: 10px; width: 100px">Khóa học của bạn:</label>


            <form action="enroll?courseName=${course.courseName}" method="post">
                <select id="enrollCourseId" name="enrollCourseId" style="height: 20px; width: 250px;" onchange="this.form.submit()">
                    <option>ALL</option>
                    <c:forEach items="${enrolledCourses}" var="course">
                        <option value="${course.courseName}">${course.courseId} - ${course.courseName}</option>
                    </c:forEach>
                </select>
            </form>

            <form action="searchkeyword" method="get">
                <input type="text" id="keywordInput" name="keyword" placeholder="Nhập từ khóa" style="height: 20px; margin-left: 10px;">
            </form>

            <div class="user-info" style="display: flex; margin-left: 420px;">
                <p class="user-name" onclick="toggleMenu()"><%= name %></p>
                <img src="<%= picture %>" alt="User Avatar" class="user-avatar" style="width: 35px; height: 32px; border-radius: 40px;" onclick="toggleMenu()">

            </div>

            <ul class="menu__box" id="menuBox">
                <li><a class="menu__item" href="#" onclick="navigateToDashboard()"><i class="fa fa-home"></i>Trang chủ</a></li>
                <li><a class="menu__item" href="logout"><i class="fa fa-share"></i>Đăng xuất</a></li>
            </ul>

            <ul class="menu__box">
                <li><a class="menu__item" href="index.html"><i class="fa fa-home"></i>Trang chủ</a></li>
                <li><a class="menu__item" href="allcourse"><i class="fa fa-book"></i>Tất cả khóa học</a></li>


            </ul>
        </div>
        <div class="background-section">
            <div class="content">
                <h1 style="color: white">FPT EDUCATION</h1>
                <br><h2 style="color: white;">COURSE MANAGEMENT SYSTEM</h2>
                <input type="submit" name="learn-more" value="LEARN MORE" style="background-color: #FD647A; width: 80px; height: 40px">
            </div>
            <div class="image-overlay"></div>
        </div>
        <footer class="site-footer">
            <div class="footer-content">
                <a>You are logged in as <a> <%= name %></a>(<a href="logout" style="color: white"></i>Đăng xuất</a></li>)</a>
            </div>       
        </footer>
    </body>
    <style>
        #menu__toggle {
            opacity: 0;
        }
        #menu__toggle:checked + .menu__btn > span {
            transform: rotate(45deg);
        }
        #menu__toggle:checked + .menu__btn > span::before {
            top: 0;
            transform: rotate(0deg);
        }
        #menu__toggle:checked + .menu__btn > span::after {
            top: 0;
            transform: rotate(90deg);
        }
        #menu__toggle:checked ~ .menu__box {
            left: 0 !important;
        }
        .menu__btn {
            position: fixed;
            top: 20px;
            left: 20px;
            width: 26px;
            height: 26px;
            cursor: pointer;
            z-index: 1;
        }
        .menu__btn > span,
        .menu__btn > span::before,
        .menu__btn > span::after {
            display: block;
            position: absolute;
            width: 100%;
            height: 2px;
            background-color: #616161;
            transition-duration: .25s;
        }
        .menu__btn > span::before {
            content: '';
            top: -8px;
        }
        .menu__btn > span::after {
            content: '';
            top: 8px;
        }
        .menu__box {
            display: block;
            position: fixed;
            top: 0;
            left: -100%;
            width: 300px;
            height: 100%;
            margin: 0;
            padding: 80px 0;
            list-style: none;
            background-color: #ECEFF1;
            box-shadow: 2px 2px 6px rgba(0, 0, 0, .4);
            transition-duration: .25s;
        }
        .menu__item {
            display: block;
            padding: 12px 24px;
            color: #333;
            font-family: 'Roboto', sans-serif;
            font-size: 20px;
            font-weight: 600;
            text-decoration: none;
            transition-duration: .25s;
        }
        .menu__item:hover {
            background-color: #CFD8DC;
        }
        img {
            width: 90px;
            margin-left: 35px;
        }
        .login-title {
            margin-left: 850px;
            align-items: center;
            justify-content: center;

        }
        .hamburger-menu{
            display: flex;
            position: fixed;
            background-color: transparent;
        }
        .background-section {
            position: fixed;
            top: 50px; /* Đặt top thành chiều cao của menu */
            left: 0;
            width: 100%;
            height: calc(100% - 50px); /* Điều chỉnh chiều cao của phần tử này để lấp đầy phần còn lại của trang */
            background-image: url("https://cmshn.fpt.edu.vn/pluginfile.php/1/theme_trema/frontpagebanner/1684246329/sanhAlpha.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center center;
            z-index: -1;
        }
        .content {
            margin: 200px;
            margin-left: 589px;
        }
        .site-footer {
            color: white;
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
            background-color: #333;
            color: white;
            padding: 20px;
            z-index: 1; /* Lớp vượt qua ảnh nền */
        }
        .footer-content {
            display: flex;
            justify-content: center; /* Căn giữa theo chiều ngang */
            align-items: center; /* Căn giữa theo chiều dọc */
            height: 100%;
        }
        .menu__box {
            /* Các quy tắc CSS khác */
            /* ... */
            left: -100%;
            /* ... */
            transition-duration: .25s;
        }

        .show {
            left: 0 !important;
        }

    </style>
    <script>
        function toggleMenu() {
            var menuBox = document.getElementById("menuBox");
            menuBox.classList.toggle("show");
        }
        function navigateToDashboard() {
            window.location.href = "doashboard.jsp";
        }
        function onEnrollCourseChange() {
            var selectElement = document.getElementById("enrollCourseId");
            var selectedCourse = selectElement.value;
            if (selectedCourse !== "") {
                window.location.href = "enroll?courseName=" + selectedCourse;
            }
        }

            function onKeywordInputKeyDown(event) {
                if (event.keyCode === 13) { // Enter key
                    var keyword = document.getElementById("keywordInput").value;
                    window.location.href = "searchkeyword?keyword=" + encodeURIComponent(keyword);
                }
            }

            document.getElementById("keywordInput").addEventListener("keydown", onKeywordInputKeyDown);

            document.getElementById("enrollCourseId").addEventListener("change", onEnrollCourseChange);
    </script>
</html>
