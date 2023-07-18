/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package document;

/**
 *
 * @author Dell
 */
public class Document {
    /*
    Chức năng 1: Đăng nhập - Đăng Xuất (dùng OAuth 2.0)
    - Tạo databasse mới tên cms: create database cms
    - Tạo bảng Users với các thuộc tính: String id, String email, String name, String given_name,
    String family_name,  String picture;
    CREATE TABLE Users (
	ID NVARCHAR(256) PRIMARY KEY,
	Email NVARCHAR(250) NOT NULL,
	Name NVARCHAR(250) NOT NULL,
	Given_name NVARCHAR(250) NOT NULL,
	Family_name NVARCHAR(250) NOT NULL,
	Picture NVARCHAR(250) NOT NULL,
	enrollCourseId NVARCHAR(256) REFERENCES Course(CourseId)
    );
 
    - Đầu tiên yêu cầu người dùng đăng nhập bằng mail @fpt.edu.vn
        +) Nếu đúng mail thì sẽ kiểm tra người dùng co trong database chưa bằng câu lệnh SELECT * FROM Users WHERE Email = '" + email + "'"
            . Nếu chưa thì sẽ tự động thêm những thuộc tính ở bảng Users vào database bằng câu lệnh
                INSERT INTO Users (ID ,Email, Name, Given_Name, Family_Name, Picture) VALUES (?, ?, ?, ?, ?, ?)
            . Nếu người dùng đã tồn tại thì sẽ chuyển người dùng sang trang doashboard.jsp
        +) Nếu người dùng không dùng mail @fpt.edu.vn thì sẽ chuyển người dùng về trang login.jsp yêu cầu đăng nhập lại
    
    CHức năng 2: HIển thị toàn bộ khóa học và khóa học người dùng đã enroll
    - Sau khi người dùng đăng nhập thành công vào trang doashboard.jsp ở đây sẽ hiển thị menu show ra những khóa học người dùng
    đã enroll, nếu người dùng chưa enroll thì hiển thị ra rỗng
    - Tạo bảng Course trong database bằng câu lệnh
    create table Course (
	CourseId nvarchar(256) primary key,
	CourseName nvarchar(250) not null,
	Semester nvarchar(250) not null,
	TeacherName nvarchar(250) not null,
        Picture nvarchar(1000) not null,
    )
    - Thêm thông tin vào bảng Course trong database
        insert into Course values
            ('SSL101c','Academic Skills for University Success','FA23','HanhPN', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg'),
            ('CSI104','Introduction to Computer Science','FA23','AnhTD', 'https://images2.thanhnien.vn/Uploaded/trinm/2023_01_04/fpthanoi01-130.jpg'),
            ('PRF192','Programming Fundamentals','FA23','ThoPN', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/08/dai-hoc-fpt-tp-hcm-1.jpeg'),
            ('MAE101','	Mathematics for Engineering','FA23','NguyenDA', 'https://hcmuni.fpt.edu.vn/Data/Sites/1/media/1-2021-huynh-anh/hoc-phi-dh-fpt-2022/dji_0290.jpg'),
            ('CEA201','Computer Organization and Architecture','FA23','BanTQ', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg'),
            ('PRO192','Object-Oriented Programming','FA23','TuanVM', 'https://images2.thanhnien.vn/Uploaded/trinm/2023_01_04/fpthanoi01-130.jpg'),
            ('MAD101','Discrete mathematics','FA23','AnhNN', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/08/dai-hoc-fpt-tp-hcm-1.jpeg'),
            ('OSG202','Operating Systems','FA23','AnhDN', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg'),
            ('NWC203c','Computer Networking','FA23','MinhTH', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg'),
            ('SSG104','Communication and In-Group Working Skills','FA23','QuanN', 'https://images2.thanhnien.vn/Uploaded/trinm/2023_01_04/fpthanoi01-130.jpg'),
            ('JPD113','Elementary Japanese 1-A1.1','FA23','LinhNT', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/08/dai-hoc-fpt-tp-hcm-1.jpeg'),
            ('CSD201','	Data Structures and Algorithms','FA23','TruongNQ', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg'),
            ('DBI202','Introduction to Databases','FA23','TienTD', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg'),
            ('LAB211','OOP with Java Lab','FA23','NangNT', 'https://images2.thanhnien.vn/Uploaded/trinm/2023_01_04/fpthanoi01-130.jpg'),
            ('WED201c','Web Design','FA23','ThoPN', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg'),
            ('MAS291','Statistics and Probability','FA23','HongNN', 'https://images2.thanhnien.vn/Uploaded/trinm/2023_01_04/fpthanoi01-130.jpg'),
            ('JPD123','Elementary Japanese 1-A1.2','FA23','CauPD', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg'),
            ('IOT102','Internet of Things','FA23','LinhLTT', 'https://images2.thanhnien.vn/Uploaded/trinm/2023_01_04/fpthanoi01-130.jpg'),
            ('PRJ301','Java Web Application Development','FA23','TienTD', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/08/dai-hoc-fpt-tp-hcm-1.jpeg'),
            ('SWE201c','Introduction to Software Engineering','FA23','LongNT', 'https://daihoc.fpt.edu.vn/wp-content/uploads/2022/02/HCM-scaled.jpeg');
    - Tạo bảng UserCourse để lưu vào database tài khoản có Id nào đã tham gia khóa học nào bằng lệnh
        create table UserCourse (
        UserId nvarchar(256),
        CourseId nvarchar(256),
        primary key (UserId, CourseId),
        foreign key (UserId) references Users(ID),
        foreign key (CourseId) references Course(CourseId)
        );
    - Sau đó hiển thị ra bằng câu lệnh SELECT UC.CourseId, C.CourseName FROM UserCourse UC JOIN Course C ON UC.CourseId = C.CourseId WHERE UC.UserId = ?
    - HIển thị toàn bộ khóa học bằng câu lệnh: SELECT * FROM COURSE
    
    CHức năng 3: Tham gia khóa học
    - Khi thực hiện tìm kiếm hay hiển thị toàn bộ khóa học nếu như người dùng chưa tham gia khóa học đó thì sẽ được yêu cầu tham gia khóa học
    bằng câu lệnh INSERT INTO UserCourse (UserId, CourseId) VALUES (?, ?)
    - Nếu như tham gia thành công sẽ dẫn đến trang coursedetailenrolled, còn không thì quay ngược lại trang allcourse
    
    Chức năng 4: Tìm kiếm khóa học
    - Người dùng có thể tìm kiếm khóa học dựa vào tên khóa học, mã khóa học hoặc là dựa vào tên giảng viên
    - Nếu từ khóa để tìm kiếm đúng hoặc trong tên khóa học, mã khóa học, tên giảng viên chứa cụm từ khóa thì sẽ show ra kết quả
    - Nếu không có thì sẽ quay trở lại trang search và in ra thông báo để cho người dùng tìm kiếm lại
    
    Chức năng 5: HIển thị nội dung khóa học
    - Tạo bảng CourseContent bằng câu lệnh
        CREATE TABLE CourseContent (
        ContentId NVARCHAR(256) PRIMARY KEY,
        CourseId NVARCHAR(256) REFERENCES Course(CourseId),
        FileName NVARCHAR(250) NOT NULL,
        FilePath NVARCHAR(1000) NOT NULL,
        );
    - Thêm nội dung khóa học vào database
        insert into CourseContent
        values ('1', 'PRF192','Baitap.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\Baitap.docx'),
        ('2', 'PRF192','Diem.xlsx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\Diem.xlsx'),
        ('3', 'PRF192','Moitruong.zip','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\Moitruong.zip'),
        ('4', 'PRF192','SlideSlot1.pptx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\SlideSlot1.pptx'),
        ('5', 'PRF192','TinhDiem.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\TinhDiem.docx'),
        ('6', 'MAE101','SlideToan.pptx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\SlideToan.pptx'),
        ('7', 'MAE101','DiemToan.xlsx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\DiemToan.xlsx'),
        ('8', 'MAE101','BaiTapToan.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\BaiTapToan.docx'),
        ('9', 'PRO192','PRO192.zip','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\PRO192.zip'),
        ('10', 'PRO192','HuongDanCaiMoiTruong.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\HuongDanCaiMoiTruong.docx'),
        ('11', 'PRO192','DiemPro192.xlsx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\DiemPro192.xlsx'),
        ('12', 'PRO192','BaitapPro.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\BaitapPro.docx'),
        ('13', 'MAD101','MAD.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\MAD.docx'),
        ('14', 'MAD101','MADPoint.xlsx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\MADPoint.xlsx'),
        ('15', 'MAD101','MADSlide.pptx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\MADSlide.pptx'),
        ('16', 'MAD101','BaiTapMAD.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\BaiTapMAD.docx'),
        ('17', 'JPD113','BangChuCai.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\BangChuCai.docx'),
        ('18', 'JPD113','TrangTuHA.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\TrangTuHA.docx'),
        ('19', 'CSD201','CSD_Source.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\CSD_Source.docx'),
        ('20', 'CSD201','DiemCSD.docx','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\DiemCSD.docx'),
        ('21', 'CSD201','SlideCSD.zip','C:\\Users\\Dell\\Documents\\NetBeansProjects\\cms-student-side\\uploads\\SlideCSD.zip')
    - Sau khi người dùng click vào bất kì file nào file đó sẽ tự động tải về
    - Hiện tại mới chỉ dừng ở việc hỗ trợ các loại file docx, xlsx, pptx, zip, rar
    
    Chức năng 6: Làm bài kiểm tra trong khóa học
    - Tạo bảng CourseExam
        CREATE TABLE CourseExam (
        ExamName NVARCHAR(256) PRIMARY KEY,
        CourseId NVARCHAR(256) REFERENCES Course(CourseId),
	ExamBegin Datetime,
        ExamFinish Datetime,
    );
    - insert mẫu ví dụ vào database 
        insert into CourseExam values('PT3', 'PRF192', '2023-07-14 00:00:00', '2023-07-30 00:00:00')
    - Khi khóa học nào có bài kiểm tra thì sẽ hiện thị lên cho người dùng biết
    - Khi làm bài xong người dùng sẽ nộp lại file bài tập
    - Tạo bảng
    create table SubmitExam(
	UserId nvarchar(256) references Users(ID),
	CourseId nvarchar(256) references Course(CourseId),
	ExamName nvarchar(256),
	FileName nvarchar(256) not null,
	FilePath nvarchar(256) not null
    );
    
    
    CREATE TABLE SubmitExam (
    UserId NVARCHAR(256) REFERENCES Users(ID),
    CourseId NVARCHAR(256) REFERENCES Course(CourseId),
    ExamName NVARCHAR(256),
    FileName NVARCHAR(256) NOT NULL,
    FilePath NVARCHAR(256) NOT NULL,
    SubmissionTime DATETIME,
    PRIMARY KEY (UserId, CourseId, ExamName)
);

    - Sau khi người dùng nộp thành công phải có 2 yêu cầu
    +) file-path đã được lưu vào database
    +) folder uploads-std đã có file đó
    đáp ứng đủ 2 yêu cầu trên chức năng hoàn thành
    
    Chức năng 7: làm đề thi
        - tạo 4 bảng
            Create table question (
                ID nvarchar(30) primary key,
                Question nvarchar(256) not null,
                CourseId nvarchar(256) references Course(CourseId)
            )
            Create table answer (
                ID nvarchar(30) primary key,
                Answer nvarchar(256) not null,
                QuesID nvarchar(30) references question(ID),
                Iscorrect bit
            )
        - insert dữ liệu
            -- Câu hỏi 21
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q21', 'Calculate the area of a right triangle ABC with two legs of length 3 and 4?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A81', '6', 'Q21', 1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A82', '5', 'Q21', 0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A83', '7.5', 'Q21', 0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A84', '8', 'Q21', 0);

            -- Câu hỏi 22
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q22', 'Given a rectangle ABCD with AB = 6 and AD = 10. Calculate the area of this rectangle?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A85', '60', 'Q22', 0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A86', '30', 'Q22',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A87', '24', 'Q22',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A88', '36', 'Q22',0);

            -- Câu hỏi 23
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q23', 'Which formula is used to calculate the circumference of a circle?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A89', 'C = 2πr', 'Q23',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A90', 'C = 4πr', 'Q23',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A91', 'C = πr^2', 'Q23',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A92', 'C = 2πr^2', 'Q23',1);

            -- Câu hỏi 24
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q24', 'Solve the equation: 2x + 3 = 11', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A93', 'x = 4', 'Q24',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A94', 'x = 5', 'Q24',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A95', 'x = 3', 'Q24',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A96', 'x = 6', 'Q24',0);

            -- Câu hỏi 25
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q25', 'Calculate the area of a square with side length of 8?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A97', '64', 'Q25',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A98', '48', 'Q25',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A99', '32', 'Q25',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A100', '36', 'Q25',1);

            -- Câu hỏi 26
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q26', 'Select the correct statement about square ABCD:', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A101', 'Square ABCD is a square with all sides equal', 'Q26',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A102', 'Square ABCD is a square with all right angles', 'Q26',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A103', 'Square ABCD is a square with two pairs of equal sides', 'Q26',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A104', 'Square ABCD is a square with no right angles', 'Q26',0);

            -- Câu hỏi 27
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q27', 'Calculate the sum of numbers from 1 to 10?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A105', '45', 'Q27',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A106', '40', 'Q27',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A107', '50', 'Q27',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A108', '55', 'Q27',0);

            -- Câu hỏi 28
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q28', 'Calculate the value of the expression 3^2 + 4^2?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A109', '25', 'Q28',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A110', '16', 'Q28',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A111', '9', 'Q28',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A112', '13', 'Q28',0);

            -- Câu hỏi 29
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q29', 'Solve the equation: 5x + 2 = 17', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A113', 'x = 3', 'Q29',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A114', 'x = 4', 'Q29',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A115', 'x = 5', 'Q29',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A116', 'x = 6', 'Q29',0);

            -- Câu hỏi 30
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q30', 'Calculate the area of triangle ABC with sides length 7, 9, and 11?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A117', '27.99', 'Q30',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A118', '32.86', 'Q30',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A119', '22.85', 'Q30',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A120', '38.46', 'Q30',0);

            -- Continue adding the remaining questions and their corresponding answers for all 40 questions...
            -- Câu hỏi 1
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q1', 'What is the capital city of France?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A1', 'London', 'Q1',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A2', 'Berlin', 'Q1',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A3', 'Paris', 'Q1',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A4', 'Madrid', 'Q1',0);

            -- Câu hỏi 2
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q2', 'Which planet is known as the "Red Planet"?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A5', 'Venus', 'Q2',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A6', 'Mars', 'Q2',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A7', 'Jupiter', 'Q2',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A8', 'Neptune', 'Q2',0);

            -- Câu hỏi 3
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q3', 'What is the chemical symbol for water?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A9', 'H2O', 'Q3',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A10', 'CO2', 'Q3',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A11', 'N2O', 'Q3',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A12', 'O2', 'Q3',1);

            -- Câu hỏi 4
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q4', 'What is the largest mammal in the world?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A13', 'Elephant', 'Q4',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A14', 'Giraffe', 'Q4',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A15', 'Whale', 'Q4',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A16', 'Lion', 'Q4',0);

            -- Câu hỏi 5
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q5', 'What is the symbol for the element oxygen?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A17', 'O', 'Q5',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A18', 'H', 'Q5',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A19', 'N', 'Q5',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A20', 'C', 'Q5',0);

            -- Câu hỏi 6
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q6', 'What is the chemical formula for sulfuric acid?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A21', 'H2SO4', 'Q6',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A22', 'HCl', 'Q6',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A23', 'NaCl', 'Q6',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A24', 'HNO3', 'Q6',0);

            -- Câu hỏi 7
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q7', 'What is the largest planet in our solar system?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A25', 'Mercury', 'Q7',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A26', 'Mars', 'Q7',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A27', 'Jupiter', 'Q7',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A28', 'Saturn', 'Q7',1);

            -- Câu hỏi 8
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q8', 'What is the largest organ in the human body?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A29', 'Heart', 'Q8',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A30', 'Liver', 'Q8',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A31', 'Brain', 'Q8',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A32', 'Skin', 'Q8',0);

            -- Câu hỏi 9
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q9', 'What is the process by which plants make their own food?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A33', 'Respiration', 'Q9',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A34', 'Photosynthesis', 'Q9',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A35', 'Digestion', 'Q9',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A36', 'Fermentation', 'Q9',0);

            -- Câu hỏi 10
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q10', 'What is the chemical symbol for gold?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A37', 'Ag', 'Q10',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A38', 'Au', 'Q10',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A39', 'Fe', 'Q10',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A40', 'Cu', 'Q10',0);

            -- Continue adding the remaining questions and their corresponding answers for questions 11 to 20...
            -- Câu hỏi 11
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q11', 'What is the chemical symbol for sodium?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A41', 'So', 'Q11',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A42', 'Na', 'Q11',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A43', 'Mg', 'Q11',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A44', 'Ca', 'Q11',0);

            -- Câu hỏi 12
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q12', 'What is the largest organ in the human body?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A45', 'Heart', 'Q12',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A46', 'Liver', 'Q12',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A47', 'Brain', 'Q12',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A48', 'Skin', 'Q12',1);

            -- Câu hỏi 13
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q13', 'What is the capital city of Italy?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A49', 'London', 'Q13',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A50', 'Berlin', 'Q13',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A51', 'Paris', 'Q13',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A52', 'Rome', 'Q13',0);

            -- Câu hỏi 14
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q14', 'What is the chemical symbol for water?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A53', 'H2O', 'Q14',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A54', 'CO2', 'Q14',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A55', 'N2O', 'Q14',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A56', 'O2', 'Q14',0);

            -- Câu hỏi 15
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q15', 'What is the tallest mountain in the world?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A57', 'Mount Everest', 'Q15',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A58', 'Mount Kilimanjaro', 'Q15',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A59', 'Mount McKinley', 'Q15',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A60', 'Mount Fuji', 'Q15',0);

            -- Câu hỏi 16
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q16', 'What is the chemical formula for sulfuric acid?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A61', 'H2SO4', 'Q16',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A62', 'HCl', 'Q16',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A63', 'NaCl', 'Q16',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A64', 'HNO3', 'Q16',0);

            -- Câu hỏi 17
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q17', 'What is the chemical symbol for gold?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A65', 'Ag', 'Q17',1);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A66', 'Au', 'Q17',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A67', 'Fe', 'Q17',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A68', 'Cu', 'Q17',0);

            -- Câu hỏi 18
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q18', 'What is the chemical symbol for nitrogen?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A69', 'N', 'Q18',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A70', 'H', 'Q18',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A71', 'O', 'Q18',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A72', 'C', 'Q18',1);

            -- Câu hỏi 19
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q19', 'What is the chemical symbol for carbon dioxide?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A73', 'CO2', 'Q19',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A74', 'H2O', 'Q19',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A75', 'O2', 'Q19',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A76', 'N2', 'Q19',1);

            -- Câu hỏi 20
            INSERT INTO Question (ID, Question, CourseId) VALUES ('Q20', 'What is the chemical symbol for silver?', 'MAD101');
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A77', 'Ag', 'Q20',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A78', 'Au', 'Q20',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A79', 'Fe', 'Q20',0);
            INSERT INTO Answer (ID, Answer, QuesID, IsCorrect) VALUES ('A80', 'Cu', 'Q20',1);




           
            
        - Mỗi câu sẽ có 4 câu trả lời và chỉ có 1 câu trả lời đúng, hệ thống sẽ random ra 10 câu hỏi trong 30 câu hỏi để cho
        người dùng làm rồi tính điểm(mỗi câu đúng sẽ được 1 điểm trên thang điểm 10, nếu sai không có điểm)
        - Tạo bảng Practise
        CREATE TABLE Practise (
            PractiseId NVARCHAR(256) PRIMARY KEY,
            CourseId NVARCHAR(256) REFERENCES Course(CourseId),
            Practisename NVARCHAR(256)
            -- Các cột khác của bảng Practise
        );

        INSERT INTO Practise (PractiseId, CourseId, Practisename)
        VALUES 
            ('PT1', 'MAD101', 'Làm trắc nghiệm số 1'),
            ('PT2', 'MAD101', 'Làm trắc nghiệm số 2'),
            ('PT3', 'MAD101', 'Làm trắc nghiệm số 3')
        - Tạo bảng PractiseQuestion
        CREATE TABLE Practise_Question (
            PractiseId NVARCHAR(256) REFERENCES Practise(PractiseId),
            QuestionId NVARCHAR(30) REFERENCES Question(QuestionId),
            PRIMARY KEY (PractiseId, QuestionId)
        );
        INSERT INTO Practise_Question (PractiseId, QuestionId)
        VALUES
            ('PT1', 'Q1'),
            ('PT1', 'Q2'),
            ('PT1', 'Q3'),
            ('PT1', 'Q4'),
            ('PT1', 'Q5'),
            ('PT1', 'Q6'),
            ('PT1', 'Q7'),
            ('PT1', 'Q8'),
            ('PT1', 'Q9'),
            ('PT1', 'Q10'),
            ('PT1', 'Q11'),
            ('PT1', 'Q12'),
            ('PT1', 'Q13'),
            ('PT1', 'Q14'),
            ('PT1', 'Q15'),
            ('PT1', 'Q16'),
            ('PT1', 'Q17'),
            ('PT1', 'Q18'),
            ('PT1', 'Q19'),
            ('PT1', 'Q20'),
            ('PT1', 'Q21'),
            ('PT1', 'Q22'),
            ('PT1', 'Q23'),
            ('PT1', 'Q24'),
            ('PT1', 'Q25'),
            ('PT1', 'Q26'),
            ('PT1', 'Q27'),
            ('PT1', 'Q28'),
            ('PT1', 'Q29'),
            ('PT1', 'Q30');
    - Tạo bảng result để lưu kết quả
        CREATE TABLE Result (
            UserId NVARCHAR(256) REFERENCES Users(ID),
            CourseId NVARCHAR(256) REFERENCES Course(CourseId),
            PractiseId NVARCHAR(256) REFERENCES Practise(PractiseId),
            Score FLOAT,
            SubmissionTime DATETIME
        );
    
     */

}
