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
            ('SSL101c','Academic Skills for University Success','FA23','HanhPN'),
            ('CSI104','Introduction to Computer Science','FA23','AnhTD'),
            ('PRF192','Programming Fundamentals','FA23','ThoPN'),
            ('MAE101','	Mathematics for Engineering','FA23','NguyenDA'),
            ('CEA201','Computer Organization and Architecture','FA23','BanTQ'),
            ('PRO192','Object-Oriented Programming','FA23','TuanVM'),
            ('MAD101','Discrete mathematics','FA23','AnhNN'),
            ('OSG202','Operating Systems','FA23','AnhDN'),
            ('NWC203c','Computer Networking','FA23','MinhTH'),
            ('SSG104','Communication and In-Group Working Skills','FA23','QuanN'),
            ('JPD113','Elementary Japanese 1-A1.1','FA23','LinhNT'),
            ('CSD201','	Data Structures and Algorithms','FA23','TruongNQ'),
            ('DBI202','Introduction to Databases','FA23','TienTD'),
            ('LAB211','OOP with Java Lab','FA23','NangNT'),
            ('WED201c','Web Design','FA23','ThoPN'),
            ('MAS291','Statistics and Probability','FA23','HongNN'),
            ('JPD123','Elementary Japanese 1-A1.2','FA23','CauPD'),
            ('IOT102','Internet of Things','FA23','LinhLTT'),
            ('PRJ301','Java Web Application Development','FA23','TienTD'),
            ('SWE201c','Introduction to Software Engineering','FA23','LongNT');
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
     */
}
