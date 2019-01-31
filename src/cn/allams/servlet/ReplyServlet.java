package cn.allams.servlet;

import cn.allams.domain.Reply;
import cn.allams.domain.User;
import cn.allams.service.ReplyException;
import cn.allams.service.ReplyService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ReplyServlet extends BaseServlet {
    ReplyService replyService = new ReplyService();


    //发帖子方法
    public String reply(HttpServletRequest request, HttpServletResponse response){
        //封装表单数据
        Reply form = CommonUtils.toBean(request.getParameterMap(),Reply.class);
        //补全

        User session_user = (User)request.getSession().getAttribute("session_user");
        form.setUname(session_user.getUsername());

        form.setRid(CommonUtils.uuid());
        form.setPid((String)request.getSession().getAttribute("pid"));
        //System.out.println((String)request.getSession().getAttribute("pid")+"shabi");
        //创建Map来封装错误信息，key为表单字段名称，值为错误信息
        Map<String,String> errors = new HashMap<String,String>();


        String replycontent = form.getReplycontent();
        if(replycontent == null || replycontent.trim().isEmpty()){
            errors.put("replycontent", "回复不能为空");
        }else if(replycontent.length()<6 || replycontent.length()>254){
            errors.put("replycontent","回复字数必须在6~254之间");
        }


        //判断是否存在错误信息,有的话直接return回家
        if(errors.size() > 0){
            request.setAttribute("errors", errors);
            request.setAttribute("form", form);
            return "f:/details.jsp";
        }

        //接下来交给service层添加进数据库
        try {
            replyService.reply(form);
            //request.getSession().getAttribute("session_user_id");
            //request.setAttribute("msg", "回复成功");
            return "f:/msg.jsp";
        } catch (ReplyException e) {
            request.setAttribute("msg", e.getMessage());
            return "f:/msg.jsp";
        }
    }
}
