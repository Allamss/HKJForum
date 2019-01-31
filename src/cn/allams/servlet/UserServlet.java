package cn.allams.servlet;

import cn.allams.domain.User;
import cn.allams.service.UserException;
import cn.allams.service.UserService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();

    //注册方法
    public String regist(HttpServletRequest request, HttpServletResponse response){
        //封装表单数据
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        //补全
        form.setUid(CommonUtils.uuid());
        //创建Map来封装错误信息，key为表单字段名称，值为错误信息
        Map<String,String> errors = new HashMap<String,String>();

        String username = form.getUsername();
        if(username == null || username.trim().isEmpty()){
            errors.put("username", "用户名不能为空");
        }else if(username.length()<3 || username.length()>10){
            errors.put("username","用户名长度必须在3~10之间");
        }

        String password = form.getPassword();
        if(password == null || password.trim().isEmpty()){
            errors.put("password", "密码不能为空");
        }else if(password.length()<3 || password.length()>10){
            errors.put("password","密码长度必须在3~10之间");
        }


        //判断是否存在错误信息,有的话直接return回家
        if(errors.size() > 0){
            request.setAttribute("errors", errors);
            request.setAttribute("form", form);
            return "f:/regist.jsp";
        }

        //接下来交给service层判断数据库中是否有该账户，没有则添加进数据库
        try {
            userService.regist(form);
            request.setAttribute("msg", "恭喜恭喜恭喜你注册成功");
            return "f:/msg.jsp";
        } catch (UserException e) {
            request.setAttribute("msg", e.getMessage());
            return "f:/msg.jsp";
        }
    }

    //登陆方法
    public String login(HttpServletRequest request,HttpServletResponse response){
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);

        try{
            User user = userService.login(form);
            request.getSession().setAttribute("session_user", user);
            return "r:/main.jsp";
        }catch(UserException e){
            request.setAttribute("msg", e.getMessage());
            request.setAttribute("form", form);
            return "f:/login.jsp";
        }
    }

    //用户退出方法
    public String quit(HttpServletRequest request,HttpServletResponse response){
        request.getSession().invalidate();
        return "r:/main.jsp";
    }
}
