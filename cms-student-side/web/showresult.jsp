<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMS - Course Management System</title>
        <link rel="shortcut icon" href="https://cmshn.fpt.edu.vn/theme/image.php/trema/theme/1684246329/favicon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div>
            <p>Bạn vừa làm bài ${practiseId} trong khóa ${courseName}</p>
            <h1>Điểm của bạn là: ${score}/10</h1>
            <a href="http://localhost:9999/cms-student-side/enroll?courseName=${courseName}">Quay về trang khóa học</a>
        </div>
        <div>
            <h2>Kết quả từng câu hỏi:</h2>
            <c:forEach items="${questions}" var="question">
                <p>Câu hỏi ${question.questionId}: ${question.questionText}</p>
                <p>Câu trả lời của bạn:</p>
                <ul>
                    <c:forEach items="${selectedAnswersMap[question.questionId]}" var="answerId">
                        <li>${answerId}</li>
                        </c:forEach>
                </ul>
                <c:if test="${question.isCorrectAnswer}">
                    <p style="color: green;">Câu trả lời chính xác!</p>
                </c:if>
                <c:if test="${!question.isCorrectAnswer}">
                    <p style="color: red;">Câu trả lời sai!</p>
                </c:if>
            </c:forEach>
        </div>
    </body>
</html>
