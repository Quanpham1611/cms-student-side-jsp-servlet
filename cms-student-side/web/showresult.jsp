<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Result</title>
    </head>
    <body>
        <div>
            <p>Bạn vừa làm bài ${practiseId} trong khóa ${courseName}</p>
            <h1 style="color: red">Điểm của bạn là: ${score}/10</h1>
            <a href="http://localhost:9999/cms-student-side/enroll?courseName=${courseName}">Quay về trang khóa học</a>
        </div>
    </body>
</html>
