package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.Student;
public class StudentDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "sayo", "sayo1234");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error  : " + e.toString());
		}
		return conn;
	}
	public ArrayList<Student> getList() throws Exception {
		Connection conn = open();
		ArrayList<Student> studentList = new ArrayList<>();
		String sql = "select student_no, student_name, student_gender, student_major, phone_no, student_address, to_char(add_date, 'yyyy.mm.dd') add_date "
				+ "from student_management " + "order by student_no ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		try (conn; pstmt; rs) {
			while (rs.next()) {
				Student s = new Student();
				s.setStudent_no(rs.getString(1));
				s.setStudent_name(rs.getString(2));
				s.setStudent_gender(rs.getString(3));
				s.setStudent_major(rs.getString(4));
				s.setPhone_no(rs.getString(5));
				s.setStudent_address(rs.getString(6));
				s.setAdd_date(rs.getString(7));
				studentList.add(s);
			}
			// System.out.println("inner studentList :"+studentList);
			// System.out.println("studentList :"+studentList);
			return studentList;
		}
	}
	public void insertStudent(Student s) throws Exception {
		Connection conn = open();
		String sql = "INSERT INTO STUDENT_MANAGEMENT(STUDENT_NO, STUDENT_NAME, STUDENT_GENDER, STUDENT_MAJOR, PHONE_NO, STUDENT_ADDRESS,ADDR_DET, ADD_DATE)  "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try (conn; pstmt) {
			pstmt.setString(1, s.getStudent_no());
			pstmt.setString(2, s.getStudent_name());
			pstmt.setString(3, s.getStudent_gender());
			pstmt.setString(4, s.getStudent_major());
			pstmt.setString(5, s.getPhone_no());
			pstmt.setString(6, s.getStudent_address());
			pstmt.setString(7, s.getAddr_det());
			// pstmt.setString(8, s.getAdd_date()); //这里的时间没有实际输入，而是系统时间，所以不需要set，get。
			pstmt.executeUpdate();
		}
	}
	public Student getDetail(String student_no) throws Exception {
		Connection conn = open();
		Student s = new Student();
		String sql = "SELECT TO_CHAR(ADD_DATE, 'YYYY.MM.DD') ADD_DATE, STUDENT_NAME, STUDENT_GENDER, STUDENT_MAJOR, PHONE_NO, STUDENT_ADDRESS, ADDR_DET "
				+ "FROM STUDENT_MANAGEMENT WHERE STUDENT_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, student_no);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		try (conn; pstmt; rs) {
			s.setAdd_date(rs.getString(1));
			s.setStudent_name(rs.getString(2));
			s.setStudent_gender(rs.getString(3));
			s.setStudent_major(rs.getString(4));
			s.setPhone_no(rs.getString(5));
			s.setStudent_address(rs.getString(6));
			s.setAddr_det(rs.getString(7));
			pstmt.executeQuery();
			return s;
		}
	}
	public Student getDetailForModify(String student_no) throws Exception {
		Connection conn = open();
		Student s = new Student();
		String sql = "SELECT STUDENT_NAME, STUDENT_GENDER, STUDENT_MAJOR, PHONE_NO, STUDENT_ADDRESS, ADDR_DET "
				+ "FROM STUDENT_MANAGEMENT WHERE STUDENT_NO=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, student_no);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		try (conn; pstmt; rs) {
			s.setStudent_name(rs.getString(1));
			s.setStudent_gender(rs.getString(2));
			s.setStudent_major(rs.getString(3));
			s.setPhone_no(rs.getString(4));
			s.setStudent_address(rs.getString(5));
			s.setAddr_det(rs.getString(6));
			pstmt.executeQuery();
			// System.out.println("s :"+ s);
			return s;
		}
	}
	public void updateStudent(Student s) throws Exception {
		Connection conn = open();
		String sql = "update student_management set student_name = ?, student_gender = ?, student_major = ?, phone_no = ?, student_address = ?, addr_det = ? where student_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try (conn; pstmt) {
			pstmt.setString(1, s.getStudent_name());
			pstmt.setString(2, s.getStudent_gender());
			pstmt.setString(3, s.getStudent_major());
			pstmt.setString(4, s.getPhone_no());
			pstmt.setString(5, s.getStudent_address());
			pstmt.setString(6, s.getAddr_det());
			pstmt.setString(7, s.getStudent_no());
//
			// 수정된 글이 없을 경우
			if (pstmt.executeUpdate() != 1) {
				throw new Exception("DB에러");
			}
		}
	}
	public void deleteStudent(String student_no) throws Exception {
		Connection conn = open();
		
		String sql ="delete from student_management where student_no=? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt){
			pstmt.setString(1, student_no);
			
			if (pstmt.executeUpdate() != 1) {
				throw new Exception("DB에러");
			}
		}
		
	}
}
