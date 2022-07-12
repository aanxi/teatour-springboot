package cn.teatour.controller.admin;

import cn.teatour.pojo.User;
import cn.teatour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * User 控制器
 *
 * @author: @zj
 * @create: 2022-04-29-上午 9:51
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/listUser")
    public String list(Model model) {
        List<User> users = userService.list();
        model.addAttribute("users", users);
        return "admin/listUser";
    }

    @RequestMapping("/editUser")
    public String edit(Model model, Integer id) {
        User user = userService.get(id);
        model.addAttribute("user", user);
        return "admin/editUser";
    }

    @RequestMapping("/updateUser")
    public String update(Integer id, String password) {
        userService.updatePassword(id, password);
        return "redirect:listUser";
    }
}
