<%-- 
    Document   : searchagain
    Created on : Jul 1, 2023, 9:11:42 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <li><a class="menu__item" href="doashboard.jsp" onclick="navigateToDashboard()"><i class="fa fa-home"></i>Trang chủ</a></li>
                        <li><a class="menu__item" href="logout"><i class="fa fa-share"></i>Đăng xuất</a></li>
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
            <h1 style="color: red; margin-left: 10px">Không tìm thấy kết quả nào khớp với ${keyword}!</h1><br>
        </div>
        <div id="backgroundVideo">
            <iframe src="https://www.youtube.com/embed/XVkADAwOXnU?autoplay=1&mute=1&loop=1&playlist=XVkADAwOXnU" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
        </div>

    </body>
    <style>
        body {
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        #backgroundVideo {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -1;
            pointer-events: none;
        }

        #backgroundVideo iframe {
            width: 100%;
            height: 100%;
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
