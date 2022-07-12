package cn.teatour.controller;

import cn.teatour.pojo.OrderItem;
import cn.teatour.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 前台页面跳转的控制器
 *
 * @author: @zj
 */
@Controller
@RequestMapping
public class PageController {
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }

    @RequestMapping("/registerSuccessPage")
    public String registerSuccessPage() {
        return "registerSuccessPage";
    }

    @RequestMapping("/registerPage")
    public String registerPage() {
        return "registerPage";
    }

    @RequestMapping("/test")
    public String testPage(Model model) {
        List<OrderItem> orderItems = orderItemService.getByOrderId(1);
        model.addAttribute("orderItems", orderItems);
        return "buyPage";
    }

    @RequestMapping("/payPage")
    public String payPage() {
        return "alipay";
    }

    @RequestMapping("/teaGardenPayPage")
    public String teaGardenPayPage() {
        return "teaGardenAlipay";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "index";
    }

    @RequestMapping("/personal")
    public String personal() {
        return "personal";
    }

    @RequestMapping("/showProductTrace")
    public String showProductTrace() {
        return "productTrace";
    }

//    @RequestMapping("/traceByCode")
//    public String traceByCode() {
//        return "traceResult";
//    }

    @RequestMapping("/createPage")
    public String createNewProd() {
        return "createPage";
    }


}
