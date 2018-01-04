package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;
import service.UserDAO;
import service.impl.UsersDAOImpl;

public class UserAction extends SuperAction implements ModelDriven<Users> {

	private static final long seriaVersionUID = 1L;
	private Users users = new Users();
	
	public String Login() {
		UserDAO udao = new UsersDAOImpl();
		if (udao.usersLongin(users)) {
			session.setAttribute("loginUserName", users.getUsername());
			return "login_session";
		} else {
			return "login_failure";
		}
	}

	@SkipValidation
	public String logout() {
		if(session.getAttribute("loginUserName") != null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if("".equals(users.getUsername().trim())) {
			this.addFieldError("usernameError","用户名不能为空！");
		}
		if(users.getPassword().length()<2) {
			this.addFieldError("passwordError", "密码长度不能小于2位！");
		}
	}
	
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return this.users;
	}
	
	
}
