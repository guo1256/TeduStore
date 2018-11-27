package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private IUserService userService;
	
	//显示个人信息页面
	@RequestMapping("/showPersonpage.do")
	public String showPersonpage() {
		return "personpage";
	}
	
	//显示修改密码页面
	@RequestMapping("/showPassword.do")
	public String showPassword() {
		return "personal_password";
	}
	
	//显示登录页面
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
	
	//显示注册的视图
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";		
	}
	
	//实现异步验证用户名是否存在
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		//声明ResponseResult<Void>对象
		ResponseResult<Void> rr = null;
		//调用业务层方法
		boolean b = userService.checkUsername(username);
		if(b) {
			rr = new ResponseResult<Void>(0,"用户名不可以使用");
		}else {
			rr = new ResponseResult<Void>(1,"用户名可以使用");
		}
		return rr;		
	}
	
	//实现异步验证邮箱是否存在
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		//声明ResponseResult<Void>对象
		ResponseResult<Void> rr = null;
		//调用业务层方法
		boolean b = userService.checkEmail(email);
		if(b) {
			rr = new ResponseResult<Void>(0,"邮箱不可以使用");
		}else {
			rr = new ResponseResult<Void>(1,"邮箱可以使用");
		}
		return rr;		
	}
	
	//实现异步验证电话是否存在
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		//声明ResponseResult<Void>对象
		ResponseResult<Void> rr = null;
		//调用业务层方法
		boolean b = userService.checkPhone(phone);
		if(b) {
			rr = new ResponseResult<Void>(0,"电话不可以使用");
		}else {
			rr = new ResponseResult<Void>(1,"电话可以使用");
		}
		return rr;		
	}
	
	
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(
			@RequestParam("uname") String username,
			@RequestParam("upwd") String password,
			String email,String phone){
		ResponseResult<Void> rr = null;
		try {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			userService.addUser(user);
			rr = new ResponseResult<Void>(1,"添加数据成功");
		}catch(RuntimeException ex){
			rr = new ResponseResult<Void>(0,"添加数据不成功");
		}
		return rr;		
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,
			String password,
			HttpSession session){
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		try {
			User user = userService.login(username, password);
			rr = new ResponseResult<Void>(1,"登录成功");
			session.setAttribute("user", user);
		} catch (RuntimeException ex) {
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
			return rr;		
	}
	
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:../main/showIndex.do";
	}
	
	@RequestMapping("updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(
			HttpSession session,
			String oldPwd,
			String newPwd){
		ResponseResult<Void> rr = null;
		try {			
			userService.changePassword(this.getId(session), oldPwd, newPwd);
			rr = new ResponseResult<Void>(1,"修改密码成功");
		} catch (RuntimeException ex) {
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(
			HttpSession session,String username,Integer gender,
			String email,String phone){
		ResponseResult<Void> rr = null;
		try {		
			userService.updateUser(this.getId(session), username, gender, email, phone);
			rr = new ResponseResult<Void>(1,"修改成功");
			//把session中的user对象替换成修改后的对象
			session.setAttribute("user", userService.getUserById(this.getId(session)));
		} catch (RuntimeException ex) {
			rr = new ResponseResult<Void>(0,ex.getMessage());
		}		
		return rr;
	}
	
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(MultipartFile file,
			HttpSession session) throws IllegalStateException, IOException{
		
		//1.创建rr对象
		ResponseResult<Void> rr =
				new ResponseResult<Void>(1,"成功");
		//2.上传图片
		//获取应用的真实路径
		String path = session.getServletContext().getRealPath("/");
		System.out.println(path);
		file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
		//3.修改数据库image字段
		userService.updImage(this.getId(session),"/upload/"+file.getOriginalFilename());
		//return rr;
		return rr;
	}
}
