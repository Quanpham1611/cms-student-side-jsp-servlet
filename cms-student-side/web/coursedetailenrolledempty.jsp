<%-- 
    Document   : coursedetailenrolledempty
    Created on : Jun 22, 2023, 7:36:32 AM
    Author     : Dell
--%>

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
                <input id="menu__toggle" type="checkbox" />
                <label class="menu__btn" for="menu__toggle">
                    <span></span>
                </label>

                <ul class="menu__box">
                    <li><a class="menu__item" href="doashboard.jsp"><i class="fa fa-home"></i>Trang chủ</a></li>
                    <li><a class="menu__item" href="allcourse"><i class="fa fa-book"></i>Tất cả khóa học</a></li>


                </ul>
            </div>
            <img src="https://cmshn.fpt.edu.vn/pluginfile.php/1/core_admin/logocompact/0x70/1684246329/2020-FPTU-Eng.png" alt="logo" style="height: 27px; margin-left: 40px;">
            <h2 style="margin-left: 10px; color: red">${courseName}</h2>
            <form action="searchkeyword" method="get">
                <input type="text" id="keywordInput" name="keyword" placeholder="Nhập từ khóa" style="height: 20px; margin-left: 10px;">
            </form>
        </div>

        <div class="content-body">
            <h3 style="color: red">Uploads File</h3>

            <h1 style="color: red">Oops!!! Thầy\cô của bạn chưa upload file gì lên cms rồi</h1>

        </div>

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
        .subject {
            width: 200px;
            height: auto;
            border: 1px solid black;
            margin: 10px;
            padding: 10px;
        }
        .content-body{
            width: 100%;
            height: 100%;
            border: 1px solid #000;
        }
        .square-box {
            width: 100%; /* Độ rộng của hình vuông */
            height: 50px; /* Chiều cao của hình vuông */
            display: flex;
            align-items: center;
            border: 1px solid #000;
        }

        .square-box a {
            display: block;
            text-align: center;
            color: #000;
        }
    </style>
    <script>
        function onKeywordInputKeyDown(event) {
            if (event.keyCode === 13) { // Enter key
                var keyword = document.getElementById("keywordInput").value;
                window.location.href = "searchkeyword?keyword=" + encodeURIComponent(keyword);
            }
        }

        document.getElementById("keywordInput").addEventListener("keydown", onKeywordInputKeyDown);

    </script>
</html>
