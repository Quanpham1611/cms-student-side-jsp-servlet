<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practice</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
        <h1>Practice Questions</h1>
        <p>Time left: <span id="countdown">10:00</span></p>
        <form id="answer" action="checkanswer" method="post">
            <input type="hidden" name="practiseId" value="${practiseId}">
            <input type="hidden" name="name" value="${name}">
            <c:forEach items="${questions}" var="question">
                <p>Câu hỏi ${question.questionId}: ${question.questionText}</p>
                <c:forEach items="${question.answers}" var="answer">
                    <label>
                        <input type="checkbox" name="answers_${question.questionId}" value="${answer.answerId}">
                        ${answer.answerText}
                    </label><br>
                </c:forEach>
            </c:forEach>
            <input type="submit" value="Submit">
        </form>
        <script>
            // JavaScript code for countdown timer
            var timeLeft = 600; // 10 minutes in seconds

            function updateCountdown() {
                var minutes = Math.floor(timeLeft / 60);
                var seconds = timeLeft % 60;
                var formattedTime = minutes.toString().padStart(2, '0') + ':' + seconds.toString().padStart(2, '0');
                document.getElementById('countdown').innerText = formattedTime;

                if (timeLeft === 0) {
                    submitAnswers();
                } else {
                    timeLeft--;
                    setTimeout(updateCountdown, 1000); // Update every 1 second
                }
            }

            // Start the countdown when the page loads
            updateCountdown();

            // Listen for beforeunload event (when the user is leaving the page)
            // Listen for beforeunload event (when the user is leaving the page)
    window.onbeforeunload = function(event) {
        // Prevent the countdown from continuing
        clearTimeout(updateCountdown);

        // Hiển thị cửa sổ cảnh báo tuỳ chỉnh
        event.preventDefault();
        event.returnValue = '';

        // Sử dụng thư viện SweetAlert2 để hiển thị cửa sổ cảnh báo
        Swal.fire({
            title: 'Bạn có muốn tiếp tục làm bài kiểm tra?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Tiếp tục làm bài',
            cancelButtonText: 'Thoát bài kiểm tra',
        }).then((result) => {
            if (result.isConfirmed) {
                // Nếu người dùng chọn "Tiếp tục làm bài", cho phép tiếp tục đếm ngược
                updateCountdown();
            } else {
                // Nếu người dùng chọn "Thoát bài kiểm tra", submit bài kiểm tra
                submitAnswers();
            }
        });
    };

            function submitAnswers() {
                // Use AJAX to submit the form data
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        // Redirect to the showresult.jsp page after submitting the answers
                        window.location.href = 'http://localhost:9999/cms-student-side/enroll?courseName=Discrete%20mathematics';
                    }
                };
                xhttp.open('POST', 'checkanswer', true);
                xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                xhttp.send(new URLSearchParams(new FormData(document.getElementById('answer'))));
            }
        </script>
    </body>
</html>







