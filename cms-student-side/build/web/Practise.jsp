<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CMS - Course Management System</title>
        <link rel="shortcut icon" href="https://cmshn.fpt.edu.vn/theme/image.php/trema/theme/1684246329/favicon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                        <input type="radio" name="answers_${question.questionId}" value="${answer.answerId}">
                        ${answer.answerText}
                    </label><br>
                </c:forEach>
            </c:forEach>
            <input type="submit" value="Submit">
        </form>
        <script>
            // JavaScript code for countdown timer
            var timeLeft = 600; // 10 minutes in seconds
            var warningDisplayed = false; // Track if the warning has been displayed

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
            window.addEventListener('beforeunload', function (event) {
                if (!warningDisplayed) {
                    clearTimeout(updateCountdown);

                    event.preventDefault();
                    event.returnValue = '';

                    Swal.fire({
                        title: 'Bạn có muốn tiếp tục làm bài kiểm tra?',
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonText: 'Tiếp tục làm bài',
                        cancelButtonText: 'Thoát bài kiểm tra',
                    }).then((result) => {
                        if (result.isConfirmed) {
                            updateCountdown();
                        } else {
                            submitAnswers();
                        }
                    });

                    warningDisplayed = true; // Mark the warning as displayed
                }
            });

            function submitAnswers() {
                document.getElementById('answer').submit();
            }
        </script>
    </body>
</html>
