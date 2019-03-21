package kr.or.blog.main;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.or.blog.constant.Template;

@Controller
public class MainController{

    @RequestMapping(path="/")
    public String home(Model model){
        model.addAttribute("template",Template.HOME);
        return Template.MAIN;
    }

    @RequestMapping(path="/join",method=RequestMethod.GET)
    public String joinForm(Model model){

        model.addAttribute("template",Template.JOIN);
        return Template.MAIN;
    }

    @RequestMapping(path="/login")
    public String loginForm(
        Model model,
        HttpServletRequest request){
        model.addAttribute("template",Template.LOGIN);
        Map<String,?> redirectMap = RequestContextUtils.getInputFlashMap(request);
        if(redirectMap != null){
            model.addAttribute("message",redirectMap.get("message"));
        }
        return Template.NOFRAME;
    }

    @RequestMapping(path="/{userId}.BStory")
    public String userMain(
        Model model,
        @PathVariable(name="userId") String userId){
        model.addAttribute("template",Template.HOME);
        return Template.MAIN;
    }
}