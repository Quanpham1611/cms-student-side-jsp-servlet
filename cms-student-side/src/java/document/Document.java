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


     */

}
