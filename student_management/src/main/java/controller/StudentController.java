package controller;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import DAO.StudentDAO;
import DTO.Student;
@WebServlet("/")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao;
	private ServletContext ctx;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new StudentDAO();
		ctx = getServletContext();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doPro(request, response);
	}
	
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String context = request.getContextPath(); // 톰캣의 Context path를 가져온다(server.xml에서 확인)
		String command = request.getServletPath();
		String site = null;
		
		switch(command) {
		case "/list":
			site = getList(request);
			break;
			
		case "/add":
			site = "add.jsp";
			break;
			
		case "/insert":
			site = insertStudent(request);
			break;
			
		case "/detail":
			site = getDetail(request);
			break;
			
		case "/modify":
			site = getDetailForModify(request);
			break;
			
		case "/update":
			site = updateStudent(request);
			break;
			
		case "/delete":
			site = deleteStudent(request);
			break;
		}
		if(site.startsWith("redirect:/")) {
			// redirect/ 문자열 이후 경로만 가지고 옴
			String rview = site.substring("redirect:/".length());
			response.sendRedirect(rview);
		} else {
			ctx.getRequestDispatcher("/" + site).forward(request, response);
		}
	}
	
	public String getList(HttpServletRequest request) {
		List<Student> list;
		
		try {
			list = dao.getList();
			request.setAttribute("studentList", list);
			System.out.println("list   : "+list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("학생 정보 목록 생성 과정에서 문제 발생!!");
			request.setAttribute("error", "학생 정보 목록이 정상적으로 처리되지 않았습니다!!");
		}
		
		return "index.jsp";
	}
	
	
	public String insertStudent(HttpServletRequest request) {
		Student s = new Student();
		
		try {
			BeanUtils.populate(s, request.getParameterMap());
			dao.insertStudent(s);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("추가 과정에서 문제 발생!!");
			request.setAttribute("error", "학생정보가 정상적으로 등록되지 않았습니다!!");
			return getList(request);
		}
		return "redirect:/list";
	}
	
	public String getDetail(HttpServletRequest request) {
		String student_no = request.getParameter("student_no");
		try{
		Student s = dao.getDetail(student_no);
		request.setAttribute("student", s);
		request.setAttribute("student_no", student_no);
		}catch(Exception e){
			e.printStackTrace();
			ctx.log("정보를 가져오는 과정에서 문제 발생!!");
			request.setAttribute("error", "정보를 정상적으로 가져오지 못했습니다!!");
		}
		return "detail.jsp";
	}
	
	public String getDetailForModify(HttpServletRequest request) {
		String student_no = request.getParameter("student_no");
		
		try {
		Student s = dao.getDetailForModify(student_no);
		request.setAttribute("student", s);
		request.setAttribute("student_no", student_no);
		} catch(Exception e) {
			e.printStackTrace();
			ctx.log("정보를 가져오는 과정에서 문제 발생!!");
			request.setAttribute("error", "정보를 정상적으로 가져오지 못했습니다!!");
		}
		return "modify.jsp";
	}
	
	public String updateStudent(HttpServletRequest request) {
		
		Student s = new Student();
		try {
			BeanUtils.populate(s, request.getParameterMap());
			dao.updateStudent(s);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("추가 과정에서 문제 발생!!");
			request.setAttribute("error", "학생정보가 정상적으로 등록되지 않았습니다!!");
			return getList(request);
		}
		return "redirect:/detail?student_no=" + s.getStudent_no();
		
		
	}
	
	
	
	private String deleteStudent(HttpServletRequest request) {
		String student_no = request.getParameter("student_no");
		try {
			dao.deleteStudent(student_no);
			} catch(Exception e) {
				e.printStackTrace();
				ctx.log("삭제 과정에서 문제 발생!!");
				request.setAttribute("error", "정상적으로 삭제되지 않았습니다!!");
				return getList(request);
			}
			return "redirect:/list";
	}
}