package cn.teatour.controller.admin;

import cn.teatour.pojo.NewProdCate;
import cn.teatour.service.NewProdCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * NewProdCate 的控制类
 *
 * @author: @zj
 */
@Controller
@RequestMapping("/admin")
public class NewProdCateController {

    @Autowired
    NewProdCateService newProdCateService;

    @RequestMapping("/listNewProdCate")
    public String list(Model model) {
        List<NewProdCate> categories = newProdCateService.list();
        model.addAttribute("categories", categories);
        return "admin/listNewProdCate";
    }

    @RequestMapping("/editNewProdCate")
    public String edit(NewProdCate newProdCate, Model model) {
        model.addAttribute("newProdCate", newProdCate);
        return "admin/editNewProdCate";
    }

    @RequestMapping("/updateNewProdCate")
    public String update(NewProdCate newProdCate) {
        newProdCateService.update(newProdCate);
        return "redirect:listNewProdCate";
    }
}
