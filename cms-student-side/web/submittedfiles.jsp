<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMS - Course Management System</title>
        <link rel="shortcut icon" href="https://cmshn.fpt.edu.vn/theme/image.php/trema/theme/1684246329/favicon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="header" style="height: 27px; display: flex; align-items: center;">
            <div class="hamburger-menu">
                <input id="menu__toggle" type="checkbox"/>
                <label class="menu__btn" for="menu__toggle">
                    <span></span>
                </label>

                <ul class="menu__box">
                    <li><a class="menu__item" href="doashboard.jsp"><i class="fa fa-home"></i>Trang chủ</a></li>
                    <li><a class="menu__item" href="allcourse"><i class="fa fa-book"></i>Tất cả khóa học</a></li>


                </ul>
            </div>
            <img src="https://cmshn.fpt.edu.vn/pluginfile.php/1/core_admin/logocompact/0x70/1684246329/2020-FPTU-Eng.png" alt="logo" style="height: 27px; margin-left: 40px;">
            <h1 style="color: red">Danh sách bài nộp</h1>
        </div>

        <div class="content-body">
            <h3 style="color: red">Các file đã nộp</h3>

            <c:forEach items="${efl}" var="examFile">
                <div class="square-box">
                    <a href="dowload2?name=${examFile.fileName}" target="_blank" style="color: black; text-decoration: none; font-size: 20px">
                        Tên tệp: ${examFile.fileName} - Thời gian nộp: ${examFile.submissionTime}
                        

                    </a>
                </div>
            </c:forEach>
        </div>
        <a href="http://localhost:9999/cms-student-side/enroll?courseName=${courseName}">Quay về trang khóa học</a>
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
</html>
