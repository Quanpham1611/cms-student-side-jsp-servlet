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
        <h1>Kết quả bạn đã làm: </h1>
        <table id="resultTable" style="border: 1px solid black">
            <tr>
                <th>CourseId</th>
                <th>PractiseId</th>
                <th onclick="sortTable(2)">Score <span id="scoreArrow">&#x25BC;</span></th>
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
            border-collapse: collapse;
            border-spacing: 10px;
        }
        th, td {
            border: 1px solid black;
            padding: 5px;
            cursor: pointer;
        }
    </style>
    <script>
        var ascending = false; // Biến để lưu trạng thái sắp xếp (mặc định là giảm dần)

        function sortTable(columnIndex) {
            var table, rows, switching, i, x, y, shouldSwitch;
            table = document.getElementById("resultTable");
            switching = true;
            var scoreArrow = document.getElementById("scoreArrow");
            if (ascending) {
                scoreArrow.innerHTML = "&#x25BC;"; // Hiển thị mũi tên xuống (để giảm dần)
            } else {
                scoreArrow.innerHTML = "&#x25B2;"; // Hiển thị mũi tên lên (để tăng dần)
            }

            while (switching) {
                switching = false;
                rows = table.rows;
                for (i = 1; i < (rows.length - 1); i++) {
                    shouldSwitch = false;
                    x = rows[i].getElementsByTagName("td")[columnIndex];
                    y = rows[i + 1].getElementsByTagName("td")[columnIndex];
                    if (x && y) {
                        if (ascending) {
                            if (parseInt(x.innerText) < parseInt(y.innerText)) {
                                shouldSwitch = true;
                                break;
                            }
                        } else {
                            if (parseInt(x.innerText) > parseInt(y.innerText)) {
                                shouldSwitch = true;
                                break;
                            }
                        }
                    }
                }
                if (shouldSwitch) {
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                }
            }
            ascending = !ascending; // Đảo ngược trạng thái sắp xếp
        }
    </script>
</html>
