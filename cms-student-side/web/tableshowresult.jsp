<%-- 
    Document   : tableshowresult
    Created on : Jul 18, 2023, 3:08:25 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMS</title>
    </head>
    <body>
        <h1>Kết quả bạn đã làm: </h1>
        <table style="border: 1px solid black">
            <tr>
                <th>CourseId</th>
                <th>PractiseId</th>
                <th>Score</th>
                <th>SubmissionTime</th>
            </tr>
            <c:forEach items="${rsl}" var="result">
                <tr>
                    <td>${result.practiseId}</td>
                    <td>${result.courseId}</td>
                    <td>${result.score}</td>
                    <td>${result.submissionTime}</td>
                </tr>
            </c:forEach>
        </table>
         <a href="http://localhost:9999/cms-student-side/enroll?courseName=${courseName}">Quay về trang khóa học</a>
    </body>
    <style>
        table {
            border-collapse: collapse; /* Kết hợp các đường viền của ô vào nhau */
            border-spacing: 10px; /* Khoảng cách giữa các cột và các hàng */
        }
        th, td {
            border: 1px solid black; /* Đường viền cho mỗi ô */
            padding: 5px; /* Khoảng cách giữa nội dung và đường viền của ô */
        }
    </style>

</html>
