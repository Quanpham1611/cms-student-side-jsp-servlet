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
    ArrayList<Course> allCourses = new ArrayList<>();
    if (request.getAttribute("allCourses") != null)
        allCourses = (ArrayList<Course>) request.getAttribute("allCourses");
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
    </head>
    <body>
        <div class="header">
            <div id="menu">
                <div id="menu-bar" onclick="menuOnClick()">
                    <div id="bar1" class="bar"></div>
                    <div id="bar2" class="bar"></div>
                    <div id="bar3" class="bar"></div>
                </div>
                <nav class="nav" id="nav">
                    <ul>
                        <li><a class="menu__item" href="index.html"><i class="fa fa-home"></i>Trang chủ</a></li>
                        <li><a class="menu__item" href="allcourse"><i class="fa fa-book"></i>Tất cả khóa học</a></li>
                    </ul>

                </nav> 
            </div>

            <div class="menu-bg" id="menu-bg"></div>
            <img src="https://cmshn.fpt.edu.vn/pluginfile.php/1/core_admin/logocompact/0x70/1684246329/2020-FPTU-Eng.png" alt="logo" style="width: 100px; height: 27px; margin-left: 70px; margin-top: 15px">
            <form action="searchkeyword" method="get">
                <input type="text" id="keywordInput" name="keyword" placeholder="Nhập từ khóa" style="height: 20px; margin-left: 10px; margin-top: 15px">
            </form>
        </div>
        <div class="body-content">
            <c:forEach items="${allCourses}" var="course">
                <div class="subject">
                    <img src="${course.picture}" style="width: 100%; height: 100%">
                    <a href="course?picture=${course.picture}&courseName=${course.courseName}&semester=${course.semester}&teacher=${course.teacherName}">Course Name: ${course.courseName}</a>
                    <p>Semester: ${course.semester}</p>
                    <p>Teacher: ${course.teacherName}</p>
                </div>
            </c:forEach>
        </div>

    </body>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: white;
        }

        #menu {
            z-index: 2;
        }

        #menu-bar {
            width: 45px;
            height: 40px;
            margin: 30px 0 20px 20px;
            cursor: pointer;
        }

        .bar {
            height: 5px;
            width: 100%;
            background-color: black;
            display: block;
            border-radius: 5px;
            transition: 0.3s ease;
        }

        #bar1 {
            transform: translateY(-4px);
        }

        #bar3 {
            transform: translateY(4px);
        }

        .nav {
            transition: 0.3s ease;
            display: none;
        }

        .nav ul {
            padding: 0 22px;
        }

        .nav li {
            list-style: none;
            padding: 12px 0;
        }

        .nav li a {
            color: white;
            font-size: 20px;
            text-decoration: none;
        }

        .nav li a:hover {
            font-weight: bold;
        }

        .menu-bg, #menu {
            top: 0;
            left: 0;
            position: absolute;
        }

        .menu-bg {
            z-index: 1;
            width: 0;
            height: 0;
            margin: 30px 0 20px 20px;
            background: radial-gradient(circle, #DC052D, #DC052D);
            border-radius: 50%;
            transition: 0.3s ease;
        }

        .change {
            display: block;
        }

        .change .bar {
            background-color: white;
        }

        .change #bar1 {
            transform: translateY(4px) rotateZ(-45deg);
        }

        .change #bar2 {
            opacity: 0;
        }

        .change #bar3 {
            transform: translateY(-6px) rotateZ(45deg);
        }

        .change-bg {
            width: 520px;
            height: 460px;
            transform: translate(-60%,-30%);
        }
        body {
            font-family: 'Roboto', sans-serif;
            background-color: white;
            margin: 0;
            padding: 0;
        }

        .header {
            display: flex;
            align-items: center;
            justify-content: flex-start;
            background-color: white;
            height: 60px;
        }

        .body-content {
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-start;
            align-items: flex-start;
            padding: 20px;
        }

        .subject {
            width: 200px;
            height: auto;
            border: 1px solid black;
            margin: 10px;
            padding: 10px;
        }
    </style>


</style>
<script>
    function menuOnClick() {
        document.getElementById("menu-bar").classList.toggle("change");
        document.getElementById("nav").classList.toggle("change");
        document.getElementById("menu-bg").classList.toggle("change-bg");
    }
    function onKeywordInputKeyDown(event) {
        if (event.keyCode === 13) { // Enter key
            var keyword = document.getElementById("keywordInput").value;
            window.location.href = "searchkeyword?keyword=" + encodeURIComponent(keyword);
        }
    }

    document.getElementById("keywordInput").addEventListener("keydown", onKeywordInputKeyDown);
</script>
</html>
