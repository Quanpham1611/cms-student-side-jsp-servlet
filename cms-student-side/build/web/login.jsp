<%-- 
    Document   : login
    Created on : Jun 9, 2023, 12:38:41 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMS - Course Management System</title>
        <link rel="shortcut icon" href="https://cmshn.fpt.edu.vn/theme/image.php/trema/theme/1684246329/favicon">
        <style>
            body {
                margin: 0;
                padding: 0;
                background-image: url('https://cmshn.fpt.edu.vn/pluginfile.php/1/theme_trema/loginbackgroundimage/1684246329/sanhAlpha2.jpg');
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
            }

            .center {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .content {
                text-align: center;
                align-self: center;
            }

            .frame {
                display: flex;
                flex-direction: column;
                align-items: center;
                padding: 20px;
                border: 1px solid gray;
                border-radius: 5px;
                background-color: white;
                margin-top: 20px;
                align-self: center;
            }
        </style>
    </head>
    <body>
        <div class="center">
            <div class="content">
                <h1 style="font-weight: bold; color: #FF0000">CMS - Course Management System</h1>
                <h2 style="font-size: 10px">Đăng nhập bằng tài khoản của bạn trên:</h2>
            </div>
            <!-- Các phần tử khác trong body -->
            <div class="frame">
                <%-- Kiểm tra thông báo lỗi và hiển thị thông báo nếu có --%>
                <c:if test="${param.error == 'invalid_email'}">
                    <p style="color: red;">Vui lòng sử dụng email @fpt.edu.vn để đăng nhập!</p>
                </c:if>
                <a href="https://accounts.google.com/o/oauth2/auth?scope=profile%20email&redirect_uri=http://localhost:9999/cms-student-side/LoginGoogleHandler&response_type=code&client_id=583884386426-mlf21d5nb8jt74s56bn737i5lsp6jk2p.apps.googleusercontent.com" style="color: black">
                    <image src="https://th.bing.com/th/id/R.21aa10651ccc4d8a2dca610304c5e4d7?rik=Kyg41BisxMt1Yg&pid=ImgRaw&r=0" style="width: 15px">
                    FPT.EDU.VN
                </a>
            </div>
    </body>
</html>



