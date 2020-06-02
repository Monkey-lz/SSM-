package com.lz.controller;

import com.lz.pojo.Paper;
import com.lz.pojo.User;
import com.lz.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName PaperController
 * @Description: TODO
 * @Author MAlone
 * @Date 2019/11/18
 * @Version V1.0
 * <p>
 * SpringMVC 页面传递参数到controller的五种方式
 * <p>
 * 一：直接将请求参数名作为Controller中方法的形参
 * <p>
 * public String login (String username,String password)   ：
 * 解释：括号中的参数必须与页面Form 表单中的 name 名字相同
 * <p>
 * 二：使用@RequestParam 绑定请求参数参数值
 * <p>
 * 举例：public String login(RequestParam ("username") String name) :
 * 解释：双引号中的username 必须与页面 name 名字相同，String name 中的name可以随便写
 * <p>
 * 三：用注解@RequestMapping接收参数的方法
 * @RequestMapping(value="/login/{username}/{password}") public String login(@PathVariable("username") String name，@PathVariable("password") String name)
 * 解释:上面的 @RequestMapping(value="/login/{username}/{password}") 是以注解的方式写在方法上的。注解上的usernname和 password 必须好页面上name 相同
 * <p>
 * 四：使用Pojo对象（就是封装的类，类中封装的字段作为参数）绑定请求参数值，原理是利用Set的页面反射机制找到User对象中的属性
 * <p>
 * 举例：@ReauestMapping（value=/login”）
 * public String login(User user){
 * 解释：就是把封装的一个类当成一个参数放在方法中，封装类中的属性就是参数。
 * <p>
 * 五：使用原生的Servlet API 作为Controller 方法的参数
 * <p>
 * public String login(HttpServletRequest request){
 * <p>
 * String usernma=Request.getParameter("username");
 * <p>
 * }
 **/

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Autowired
    private IPaperService paperService;

    /**
     * 任何通过这个Handler的请求在执行目标方法之前都要执行@ModelAttribute修饰的getModel方法
     * 形参中的user只有表单上提交的属性值
     * 从数据库中取出对应的属性放到request中
     */
    //@ModelAttribute
    //public void getModel(User user, Model map) {
    //    System.out.println("一"+user);
    //    if (user.getId() != 0) {
    //        map.addAttribute("abc", new User());
    //    }
    //}
    @RequestMapping("/allPapers")
    public String list(Model model) {
        List<Paper> papers = paperService.queryAllPaper();
        model.addAttribute("papers", papers);
        return "allPapers";
    }

    @RequestMapping("/toAddPaper")
    public String toAddPaper() {
        return "addPaper";
    }

    @RequestMapping("/addPaper")
    public String addPaper(Paper paper) {
        paperService.addPaper(paper);
        return "redirect:/paper/allPapers";
    }

    @RequestMapping("/del/{paperId}")
    public String deletePaper(@PathVariable("paperId") long id) {
        paperService.deletePaperById(id);
        return "redirect:/paper/allPapers";
    }

    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(Model model, long id) {
        System.out.println(id);
        System.out.println(paperService.queryById(id));
        model.addAttribute("paper", paperService.queryById(id));
        return "updatePaper";
    }

    @RequestMapping("/updatePaper")
    public String deletePaper(Model model, Paper paper) {
        paperService.updatePaper(paper);
        paper = paperService.queryById(paper.getPaperId());
        model.addAttribute("paper", paper);
        return "redirect:/paper/allPapers";
    }

}
