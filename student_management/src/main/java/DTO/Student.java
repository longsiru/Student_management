package DTO;
public class Student {
	private String student_no;
	private String student_name;
	private String student_gender;
	private String student_major;
	private String phone_no;
	private String student_address;
	private String addr_det;
	private String add_date;
	private String update_date;
	
	public Student(String student_no,  String student_name, String student_gender, String student_major, String phone_no, String student_address, String addr_det, String add_date, String update_date) {
		this.student_no = student_no;
		this.student_name = student_name;
		this.student_gender = student_gender;
		this.student_major = student_major;
		this.phone_no = phone_no;
		this.student_address = student_address;
		this.addr_det = addr_det;
		this.add_date = add_date;
		this.update_date = update_date;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getStudent_no() {
		return student_no;
	}
	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_gender() {
		return student_gender;
	}
	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}
	public String getStudent_major() {
		return student_major;
	}
	public void setStudent_major(String student_major) {
		this.student_major = student_major;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	public String getAddr_det() {
		return addr_det;
	}
	public void setAddr_det(String addr_det) {
		this.addr_det = addr_det;
	}
	public String getAdd_date() {
		return add_date;
	}
	public void setAdd_date(String add_date) {
		this.add_date = add_date;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	
	
	
}










