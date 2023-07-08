<%-- 
    Document   : coursedetail
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
                <li><a class="menu__item" href="index.html"><i class="fa fa-home"></i>Trang chủ</a></li>
                <li><a class="menu__item" href="allcourse"><i class="fa fa-book"></i>Tất cả khóa học</a></li>


            </ul>
            </div>
            <img src="https://cmshn.fpt.edu.vn/pluginfile.php/1/core_admin/logocompact/0x70/1684246329/2020-FPTU-Eng.png" alt="logo" style="height: 27px; margin-left: 40px;">

        </div>
        <h2 style="margin-left: 10px; color: red">${courseName} - ${teacher}</h2>
        <div class="content-body">

            <div class="subject">
                <img src="${picture}" style="height: 100%; width: 100%" alt="Photo of course">
                <h2>Course Name: ${courseName}</h2>
                <p>Semester: ${semester}</p>
                <p>Teacher: ${teacher}</p>
            </div>

        </div>
        <form action="enroll" method="post">
            <input type="hidden" name="courseName" value="${courseName}">
            <input type="hidden" name="teacher" value="${teacher}">
            <input type="submit" name="enroll" value="Enroll me" style="margin-left: 10px;
                   height: 30px;
                   background-color: #FD647A;
                   color: black;
                   border: none;
                   font-weight: bold;">
        </form>
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
    </style>
</html>
