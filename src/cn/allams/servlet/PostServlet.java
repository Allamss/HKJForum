package cn.allams.servlet;

import cn.allams.domain.Post;
import cn.allams.domain.User;
import cn.allams.service.PostException;
import cn.allams.service.PostService;
import cn.allams.service.ReplyService;
import cn.allams.service.UserService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class PostServlet extends BaseServlet {
    PostService postService = new PostService();
    UserService userService = new UserService();
    ReplyService replyService = new ReplyService();

    //返回所有帖子
    public String findAll(HttpServletRequest request,HttpServletResponse response){
        request.setAttribute("postList", postService.findAll());
        return "f:/left.jsp";
    }

    //发帖子方法
    public String post(HttpServletRequest request,HttpServletResponse response){
        //封装表单数据
        Post form = CommonUtils.toBean(request.getParameterMap(),Post.class);
        //补全

        User session_user = (User)request.getSession().getAttribute("session_user");
        form.setUname(session_user.getUsername());

        form.setPid(CommonUtils.uuid());
        //创建Map来封装错误信息，key为表单字段名称，值为错误信息
        Map<String,String> errors = new HashMap<String,String>();

        String topic = form.getTopic();
        if(topic == null || topic.trim().isEmpty()){
            errors.put("topic", "标题不能为空");
        }else if(topic.length()<3 || topic.length()>16){
            errors.put("topic","标题长度必须在3~16之间");
        }

        String postcontent = form.getPostcontent();
        if(postcontent == null || postcontent.trim().isEmpty()){
            errors.put("postcontent", "正文不能为空");
        }else if(postcontent.length()<10 || postcontent.length()>254){
            errors.put("postcontent","正文字数必须在10~254之间");
        }


        //判断是否存在错误信息,有的话直接return回家
        if(errors.size() > 0){
            request.setAttribute("errors", errors);
            request.setAttribute("form", form);
            return "f:/post.jsp";
        }

        //接下来交给service层添加进数据库
        try {
            postService.post(form);
            //,request.getSession().getAttribute("session_user_id").toString()
            request.setAttribute("msg", "发帖成功");
            return "f:/msg.jsp";
        } catch (PostException e) {
            request.setAttribute("msg", e.getMessage());
            return "f:/msg.jsp";
        }
    }

    //通过Pid查找
    public String findByPid(HttpServletRequest request,HttpServletResponse response){
        String pid = request.getParameter("pid");
        request.setAttribute("details", postService.findByPid(pid));
        request.setAttribute("replyList",replyService.findByPid(pid));
        request.getSession().setAttribute("pid", pid);
        return "f:/details.jsp?pid="+pid;
    }

    public void delete(HttpServletRequest request, HttpServletResponse response){
        postService.delete((String)request.getSession().getAttribute("pid"));
        replyService.delete((String)request.getSession().getAttribute("pid"));
    }
}
