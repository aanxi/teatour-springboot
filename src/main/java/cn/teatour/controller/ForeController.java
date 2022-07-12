package cn.teatour.controller;

import cn.teatour.pojo.*;
import cn.teatour.service.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Comparator.comparing;

/**
 * @program: teatour
 * @description: 前端控制器
 * @author: 张佳
 * @create: 2022-02-10 13:57
 **/
@Controller
@RequestMapping
public class ForeController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    PropertyValueService propertyValueService;

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderService orderService;

    @Autowired
    TeaGardenService teaGardenService;

    @Autowired
    TeaGardenReviewService teaGardenReviewService;


    @Autowired
    AppointmentItemService appointmentItemService;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    TeaGardenCategoryService teaGardenCategoryService;

    @Autowired
    NewProdCateService newProdCateService;

    @Autowired
    NewProdService newProdService;

    @Autowired
    NewProdRevService newProdRevService;


    /**
     * 用户登陆
     *
     * @param model
     * @param name
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(Model model,
                        @RequestParam("name") String name,
                        @RequestParam("password") String password,
                        HttpSession session) {
        User user = userService.get(name, password);
        if (null == user) {
            model.addAttribute("msg", "账号密码错误");
            return "loginPage";
        }
        session.setAttribute("user", user);
        return "redirect:home";
    }

    /**
     * 退出登陆
     *
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:home";
    }

    /**
     * 用户注册
     *
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String register(Model model, User user) {
        String name = user.getName();
        boolean exist = userService.isExist(name);

        if (exist) {
            String msg = "用户名已经被占用，不能使用";
            model.addAttribute("msg", msg);
            model.addAttribute("username", user.getName());
            return "registerPage";
        }
        userService.add(user);

        return "redirect:registerSuccessPage";
    }


    /**
     * 首页访问方法，给首页的JSP页面添加以下数据：
     *
     * @param model
     * @return
     */
    @RequestMapping("home")
    public String home(Model model) {
        List<Category> categories = categoryService.list();
        productService.fill(categories);
        productService.fillByRow(categories);

        model.addAttribute("categories", categories);

        return "index";
    }

    /**
     * 显示产品信息
     *
     * @param model
     * @param product_id
     * @return
     */
    @RequestMapping("showProduct")
    public String showProduct(Model model, Integer product_id) {
        Product product = productService.get(product_id);
        productService.setReviewCount(product);
        model.addAttribute("product", product);
        List<PropertyValue> propertyValues = propertyValueService.listByProductId(product_id);
        model.addAttribute("propertyValues", propertyValues);
        List<Review> reviews = reviewService.listByProductId(product_id);
        model.addAttribute("reviews", reviews);
        return "product";
    }

    /**
     * 展示所有产品
     *
     * @param model
     * @return
     */
    @RequestMapping("showAllProduct")
    public String showAllProduct(Model model) {
        List<Category> categories = categoryService.list();
        productService.fill(categories);
        productService.fillByRow(categories);
        model.addAttribute("categories", categories);

        return "allProduct";
    }

    /**
     * 展示所有产品
     *
     * @param model
     * @param keyword
     * @return
     */
    @RequestMapping("searchProduct")
    public String searchProduct(Model model, String keyword) {

        PageHelper.offsetPage(0, 20);
        List<Product> products = productService.search(keyword);
        model.addAttribute("products", products);
        return "searchResult";
    }

    /**
     * 搜索结果排序
     *
     * @param model
     * @param keyword
     * @return
     */
    @RequestMapping("sortProduct")
    public String sortProduct(Model model, String sort, String keyword) {
        List<Product> products = productService.search(keyword);
        for (Product product : products) {
            product.setReviewCount(reviewService.getReviewCount(product.getId()));
        }
        if (null != sort) {
            switch (sort) {
                case "all":
                    Collections.sort(products, comparing(Product::getSaleXReviewCount));
                    break;
                case "reviewCount":
                    Collections.sort(products, comparing(Product::getReviewCount));
                    break;
//                case "date":
//                    Collections.sort(products, comparing(Product::getCreate_date));
//                    break;
                case "sale":
                    Collections.sort(products, comparing((Product::getSale)));
                    break;
                case "price":
                    Collections.sort(products, comparing(Product::getPrice));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + sort);
            }
        }
        model.addAttribute("products", products);

        return "searchResult";
    }


    /**
     * 立即购买某一种产品
     *
     * @param product_id 产品的ID
     * @param number     购买的数量
     * @param session    session用于获取user信息
     * @return
     */
    @RequestMapping("/buyone")
    public String buyone(Integer product_id, Integer number, HttpSession session) {
        Product product = productService.get(product_id);
        int orderItemId = 0;

        User user = (User) session.getAttribute("user");
        boolean found = false;

        List<OrderItem> orderItems = orderItemService.listByUserId(user.getId());
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct_id().intValue() == product.getId().intValue()) {
                found = true;
                orderItem.setNumber(number);
                orderItemService.update(orderItem);
                orderItemId = orderItem.getId();
                break;
            }
        }

        if (!found) {
            OrderItem orderItem = new OrderItem();
            orderItem.setUser_id(user.getId());
            orderItem.setNumber(number);
            orderItem.setProduct_id(product_id);
            orderItemService.add(orderItem);
            orderItemId = orderItem.getId();
        }

        return "redirect:buy?orderItemId=" + orderItemId;

    }

    /**
     * 购买一种或多种商品
     *
     * @param model
     * @param orderItemId
     * @param session
     * @return
     */
    @RequestMapping("buy")
    public String buy(Model model, String[] orderItemId, HttpSession session) {
        List<OrderItem> orderItems = new ArrayList<>();
        float total = 0;

        for (String strId : orderItemId) {
            int id = Integer.parseInt(strId);
            OrderItem oi = orderItemService.getById(id);
            total += oi.getProduct().getPrice() * oi.getNumber();
            orderItems.add(oi);
        }

        session.setAttribute("orderItems", orderItems);
        model.addAttribute("total", total);
        return "buyPage";
    }

    /**
     * 创建订单
     *
     * @param model
     * @param order
     * @param session
     * @return
     */
    @RequestMapping("createOrder")
    public String createOrder(Model model, Order order, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        order.setOrder_code(orderCode);
        order.setCreate_date(new Date());
        order.setUser_id(user.getId());
        order.setStatus(OrderService.waitPay);
        List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("orderItems");
        float total = orderService.add(order, orderItems);
        for (OrderItem orderItem : orderItems) {
            productService.updateSaleAndStock(orderItem.getProduct_id(), orderItem.getNumber());
        }
        return "redirect:payPage?order_id=" + order.getId() + "&total=" + total;
    }

    /**
     * 支付订单
     *
     * @param model
     * @param order_id
     * @param total
     * @return
     */
    @RequestMapping("payed")
    public String payed(Integer order_id, float total, Model model) {
        Order order = orderService.get(order_id);
        order.setStatus(OrderService.waitDelivery);
        order.setPay_date(new Date());
        orderService.update(order);
        model.addAttribute("o", order);
        model.addAttribute("order_id", order_id);
        model.addAttribute("total", total);
        return "payed";
    }

    /**
     * 加入购物车，需要新增订单项OrderItem，分为两种情况：
     * 1.如果这个产品已经存在于购物车中，那么只需要相应的调整数量就可以了
     * 2.如果不存在对应的OrderItem项，那么就新增一个订单项（OrderItem）
     * - 前提条件：已经登录
     *
     * @param product_id
     * @param num
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("addCart")
    @ResponseBody
    public String addCart(int product_id, int num, Model model, HttpSession session) {
        Product product = productService.get(product_id);

        User user = (User) session.getAttribute("user");
        boolean found = false;

        List<OrderItem> orderItems = orderItemService.listByUserId(user.getId());
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getProduct_id().intValue() == product.getId().intValue() && orderItem.getOrder_id() == null) {
                found = true;
                orderItem.setNumber(orderItem.getNumber() + num);
                orderItemService.update(orderItem);
                break;
            }
        }

        if (!found) {
            OrderItem orderItem = new OrderItem();
            orderItem.setUser_id(user.getId());
            orderItem.setNumber(num);
            orderItem.setProduct_id(product_id);
            orderItemService.add(orderItem);
        }
        return "success";
    }

    /**
     * 查看购物车方法：
     * 1.首先通过session获取到当前的用户
     * 2.获取这个用户关联的订单项的集合
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/cart")
    public String cart(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<OrderItem> orderItems = orderItemService.listForCart(user.getId());
        model.addAttribute("orderItems", orderItems);
        return "cart";
    }

    /**
     * 检查用户是否登陆
     * 通过session获取到当前的用户
     *
     * @param session
     * @return
     */
    @RequestMapping("/checkLogin")
    @ResponseBody
    public String checkLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null)
            return "success";
        return "fail";
    }

    /**
     * 改变订单项
     * 通过session获取到当前的用户
     *
     * @param session
     * @param model
     * @param product_id
     * @param number
     * @return
     */
    @RequestMapping("changeOrderItem")
    @ResponseBody
    public String changeOrderItem(Model model, HttpSession session, int product_id, int number) {
        User user = (User) session.getAttribute("user");
        if (null == user)
            return "fail";

        List<OrderItem> ois = orderItemService.listByUserId(user.getId());
        for (OrderItem oi : ois) {
            if (oi.getProduct().getId().intValue() == product_id) {
                oi.setNumber(number);
                orderItemService.update(oi);
                break;
            }
        }
        return "success";
    }

    /**
     * 删除订单项
     * 通过session获取到当前的用户
     *
     * @param session
     * @param model
     * @param orderItemId
     * @return
     */
    @RequestMapping("deleteOrderItem")
    @ResponseBody
    public String deleteOrderItem(Model model, HttpSession session, Integer orderItemId) {
        User user = (User) session.getAttribute("user");
        if (null == user)
            return "fail";
        orderItemService.delete(orderItemId);
        return "success";
    }

    /**
     * 显示用户的全部订单
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("bought")
    public String bought(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderService.list(user.getId(), OrderService.delete);
        orderItemService.fill(orders);
        model.addAttribute("orders", orders);

        return "bought";
    }

    /**
     * 确认支付
     *
     * @param order_id
     * @param model
     * @return
     */
    @RequestMapping("confirmPay")
    public String confirmPay(Model model, Integer order_id) {
        Order order = orderService.get(order_id);
        orderItemService.fill(order);
        model.addAttribute("order", order);
        return "confirmPay";
    }

    /**
     * 确认订单
     *
     * @param order_id
     * @param model
     * @return
     */
    @RequestMapping("orderConfirmed")
    public String orderConfirmed(Model model, Integer order_id) {
        Order o = orderService.get(order_id);
        o.setStatus(OrderService.waitReview);
        o.setConfirm_date(new Date());
        orderService.update(o);
        return "orderConfirmedPage";
    }

    /**
     * 删除订单
     *
     * @param order_id
     * @param model
     * @return
     */
    @RequestMapping("deleteOrder")
    @ResponseBody
    public String deleteOrder(Model model, Integer order_id) {
        Order o = orderService.get(order_id);
        o.setStatus(OrderService.delete);
        orderService.update(o);
        return "success";
    }

    /**
     * 评价商品订单
     *
     * @param order_id
     * @param model
     * @return
     */
    @RequestMapping("review")
    public String review(Model model, Integer order_id) {
        Order order = orderService.get(order_id);
        orderItemService.fill(order);
        Product product = order.getOrderItems().get(0).getProduct();
        List<Review> reviews = reviewService.listByProductId(product.getId());
        productService.setReviewCount(product);
        model.addAttribute("product", product);
        model.addAttribute("order", order);
        model.addAttribute("reviews", reviews);
        return "reviewPage";
    }

    /**
     * 提交订单中的一件商品评价
     *
     * @param model
     * @param session
     * @param order_id
     * @param product_id
     * @param content
     * @return
     */
    @RequestMapping("doreview")
    public String doreview(Model model, HttpSession session,
                           @RequestParam("order_id") Integer order_id,
                           @RequestParam("product_id") Integer product_id,
                           String content) {

        Order order = orderService.get(order_id);
        order.setStatus(OrderService.finish);
        orderService.update(order);

        User user = (User) session.getAttribute("user");
        Review review = new Review();
        review.setContent(content);
        review.setProduct_id(product_id);
        review.setCreateDate(new Date());
        review.setUser_id(user.getId());
        reviewService.add(review);

        return "redirect:review?order_id=" + order_id + "&showonly=true";
    }

    /**
     * 显示某个茶园的信息
     *
     * @param model
     * @param teaGarden_id
     * @return
     */
    @RequestMapping("/showTeaGarden")
    public String showTeaGarden(Model model, Integer teaGarden_id) {
        TeaGarden teaGarden = teaGardenService.get(teaGarden_id);
        teaGardenService.setTeaGardenReviewCount(teaGarden);
        model.addAttribute("teaGarden", teaGarden);
        List<TeaGardenReview> teaGardenReviews = teaGardenReviewService.listByTeaGardenId(teaGarden_id);
        model.addAttribute("teaGardenReviews", teaGardenReviews);
        return "teaGarden";
    }

    /**
     * 显示所有茶园
     *
     * @param model
     * @return
     */
    @RequestMapping("/showAllTeaGarden")
    public String showAllTeaGarden(Model model) {
        List<TeaGardenCategory> categories = teaGardenCategoryService.list();
        teaGardenService.fill(categories);
        teaGardenService.fillByRow(categories);
        model.addAttribute("categories", categories);

        return "allTeaGarden";
    }


    /**
     * 立即预约某一茶旅体验
     *
     * @param teaGarden_id
     * @param number
     * @param session
     * @return
     */
    @RequestMapping("/appointone")
    public String appointone(Integer teaGarden_id, Integer number, HttpSession session) {
        TeaGarden teaGarden = teaGardenService.get(teaGarden_id);
        int appointmentItemId = 0;

        User user = (User) session.getAttribute("user");
        boolean found = false;

        List<AppointmentItem> appointmentItems = appointmentItemService.listByUserId(user.getId());
        for (AppointmentItem appointmentItem : appointmentItems) {
            if (appointmentItem.getTeaGarden_id().intValue() == teaGarden.getId().intValue()) {
                found = true;//我加的
                appointmentItem.setNumber(number);
                appointmentItemService.update(appointmentItem);
                appointmentItemId = appointmentItem.getId();
                break;
            }
        }

        if (!found) {
            AppointmentItem appointmentItem = new AppointmentItem();
            appointmentItem.setUser_id(user.getId());
            appointmentItem.setNumber(number);
            appointmentItem.setTeaGarden_id(teaGarden_id);
            appointmentItemService.add(appointmentItem);
            appointmentItemId = appointmentItem.getId();
        }

        return "redirect:appoint?appointmentItemId=" + appointmentItemId;

    }

    /**
     * 预约茶旅体验
     *
     * @param model
     * @param appointmentItemId
     * @param session
     * @return
     */
    @RequestMapping("appoint")
    public String appoint(Model model, String appointmentItemId, HttpSession session) {
        List<AppointmentItem> appointmentItems = new ArrayList<>();
        float total = 0;

        int id = Integer.parseInt(appointmentItemId);
        AppointmentItem oi = appointmentItemService.getById(id);
        total = oi.getTeaGarden().getPrice() * oi.getNumber();
        appointmentItems.add(oi);

        session.setAttribute("appointmentItems", appointmentItems);
        model.addAttribute("total", total);
        return "appointPage";
    }


    /**
     * 创建预约
     *
     * @param model
     * @param appointment
     * @param session
     * @return
     */
    @RequestMapping("createAppointment")
    public String createAppointment(Model model, Appointment appointment, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String appointmentCode = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        appointment.setAppointment_code(appointmentCode);
        appointment.setCreate_date(new Date());
        appointment.setUser_id(user.getId());
        appointment.setStatus(AppointmentService.waitPay);
        List<AppointmentItem> appointmentItems = (List<AppointmentItem>) session.getAttribute("appointmentItems");
        float total = appointmentService.add(appointment, appointmentItems);
        return "redirect:teaGardenPayPage?appointment_id=" + appointment.getId() + "&total=" + total;
    }

    /**
     * 支付茶旅预约订单
     *
     * @param model
     * @param appointment_id
     * @param total
     * @return
     */
    @RequestMapping("teaGardenPayed")
    public String teaGardenPayed(int appointment_id, float total, Model model) {
        Appointment appointment = appointmentService.get(appointment_id);
        appointment.setStatus(AppointmentService.waitDelivery);
        appointment.setPay_date(new Date());
        appointmentService.update(appointment);
        model.addAttribute("o", appointment);
        return "teaGardenPayed";
    }


    /**
     * 显示用户的全部预约
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("appointed")
    public String appointed(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Appointment> appointments = appointmentService.list(user.getId(), AppointmentService.delete);
        appointmentItemService.fill(appointments);
        model.addAttribute("appointments", appointments);

        return "appointed";
    }

    /**
     * 确认体验完成
     *
     * @param appointment_id
     * @param model
     * @return
     */
    @RequestMapping("confirmAppoint")
    public String confirmAppoint(Model model, Integer appointment_id) {
        Appointment appointment = appointmentService.get(appointment_id);
        appointmentItemService.fill(appointment);
        model.addAttribute("appointment", appointment);
        return "confirmAppoint";
    }

    /**
     * 确认支付预约
     *
     * @param appointment_id
     * @param model
     * @return
     */
    @RequestMapping("appointmentConfirmed")
    public String appointmentConfirmed(Model model, Integer appointment_id) {
        Appointment o = appointmentService.get(appointment_id);
        o.setStatus(AppointmentService.waitTeaGardenReview);
        o.setConfirm_date(new Date());
        appointmentService.update(o);
        return "appointmentConfirmedPage";
    }

    /**
     * 删除预约
     *
     * @param appointment_id
     * @param model
     * @return
     */
    @RequestMapping("deleteAppointment")
    @ResponseBody
    public String deleteAppointment(Model model, Integer appointment_id) {
        Appointment o = appointmentService.get(appointment_id);
        o.setStatus(AppointmentService.delete);
        appointmentService.update(o);
        return "success";
    }

    /**
     * 通过溯源码查询溯源信息
     *
     * @param model
     * @param code
     * @return
     */
    @RequestMapping("traceByCode")
    public String traceByCode(Model model, String code) {
        model.addAttribute("code", code);
        return "traceResult";
    }

    /**
     * 评价茶旅体验
     *
     * @param appointment_id
     * @param model
     * @return
     */
    @RequestMapping("teaGardenReview")
    public String teaGardenReview(Model model, Integer appointment_id) {
        Appointment appointment = appointmentService.get(appointment_id);
        appointmentItemService.fill(appointment);
        TeaGarden teaGarden = appointment.getAppointmentItems().get(0).getTeaGarden();
        List<TeaGardenReview> teaGardenReviews = teaGardenReviewService.listByTeaGardenId(teaGarden.getId());
        teaGardenService.setTeaGardenReviewCount(teaGarden);
        model.addAttribute("teaGarden", teaGarden);
        model.addAttribute("appointment", appointment);
        model.addAttribute("teaGardenReviews", teaGardenReviews);
        return "teaGardenReviewPage";
    }

    /**
     * 提交茶园评价
     *
     * @param model
     * @param session
     * @param appointment_id
     * @param teaGarden_id
     * @param content
     * @return
     */
    @RequestMapping("doteaGardenReview")
    public String doteaGardenReview(Model model, HttpSession session,
                                    @RequestParam("appointment_id") Integer appointment_id,
                                    @RequestParam("teaGarden_id") Integer teaGarden_id,
                                    String content) {

        Appointment appointment = appointmentService.get(appointment_id);
        appointment.setStatus(AppointmentService.finish);
        appointmentService.update(appointment);

        User user = (User) session.getAttribute("user");
        TeaGardenReview teaGardenReview = new TeaGardenReview();
        teaGardenReview.setContent(content);
        teaGardenReview.setTeaGarden_id(teaGarden_id);
        teaGardenReview.setCreateDate(new Date());
        teaGardenReview.setUser_id(user.getId());
        teaGardenReviewService.add(teaGardenReview);

        return "redirect:teaGardenReview?appointment_id=" + appointment_id + "&showonly=true";
    }

    /**
     * 检查用户是否已评价过当前新品
     *
     * @param newProd_id
     * @return
     */
    @RequestMapping("newProdRevCheck")
    public String newProdRevCheck(HttpSession session, Integer newProd_id) {
        User user = (User) session.getAttribute("user");
        return newProdRevService.hasReviewed(user.getId(), newProd_id) ? "true" : "false";
    }

    /**
     * 评价新品
     *
     * @param model
     * @param newProd_id
     * @return
     */
    @RequestMapping("newProdRev")
    public String newProdRev(Model model, Integer newProd_id) {
        NewProd newProd = newProdService.get(newProd_id);
        List<NewProdRev> newProdRevs = newProdRevService.listByNewProdId(newProd_id);
        newProdService.setNewProdRevCount(newProd);
        model.addAttribute("newProd", newProd);
        model.addAttribute("newProdRevs", newProdRevs);

        return "newProdRevPage";
    }

    /**
     * 提交新品评价
     *
     * @param model
     * @param session
     * @param newProd_id
     * @param content
     * @return
     */
    @RequestMapping("donewProdRev")
    public String donewProdRev(Model model, HttpSession session,
                               @RequestParam("newProd_id") Integer newProd_id,
                               String content) {

        User user = (User) session.getAttribute("user");

        NewProdRev newProdRev = new NewProdRev();
        newProdRev.setContent(content);
        newProdRev.setNewProd_id(newProd_id);
        newProdRev.setCreateDate(new Date());
        newProdRev.setUser_id(user.getId());
        newProdRevService.add(newProdRev);
        return "redirect:newProdRev?newProd_id=" + newProd_id + "&showonly=true";


    }

    /**
     * 显示某个新品的信息
     *
     * @param model
     * @param newProd_id
     * @return
     */
    @RequestMapping("/showNewProd")
    public String showNewProd(HttpSession session, Model model, Integer newProd_id) {
        NewProd newProd = newProdService.get(newProd_id);
        newProdService.setNewProdRevCount(newProd);
        model.addAttribute("newProd", newProd);
        List<NewProdRev> newProdRevs = newProdRevService.listByNewProdId(newProd_id);
        model.addAttribute("newProdRevs", newProdRevs);
        User user = (User) session.getAttribute("user");
        if (!newProdRevService.hasReviewed(user.getId(), newProd_id)) {
            model.addAttribute("message", "您还未评价该新品");
        } else {
            model.addAttribute("message", "您已评价过该新品！");
        }
        return "newProd";
    }

    /**
     * 显示所有新品建议
     *
     * @param model
     * @return
     */
    @RequestMapping("/showAllNewProd")
    public String showAllNewProduct(Model model, Integer newProdCate_id) {
        List<NewProd> newProds = newProdService.list(1);
        newProds.addAll(newProdService.list(2));
        newProds.addAll(newProdService.list(3));
        model.addAttribute("newProds", newProds);
        return "allNewProd";
    }

    /**
     * 创建新产品，上传新品图片，提出自己的新品建议
     *
     * @param session
     * @param model
     * @param newProd
     * @return
     */
    @RequestMapping("createNewProd")
    public String createNewProd(Model model, @RequestParam("file") MultipartFile file, NewProd newProd, HttpSession session) {
        User user = (User) session.getAttribute("user");
        //创建一个对象
        Random df = new Random();
        //引用nextInt()方法
        int id = df.nextInt(1001);
        newProd.setId(id);
        newProd.setUser_id(user.getId());
        newProd.setNewProdCate_id(1);
        newProdService.add(newProd);
        model.addAttribute("newProd", newProd);

        // 获取上传文件名
        String filename = file.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        // 定义上传文件保存路径
        String filePath = "C:/Users/77878/IdeaProjects/teatour/src/main/resources/static/img/";
        String path = filePath + "newProd/";
        //生成新的文件名称
        String newImgName = newProd.getId().toString() + suffixName;
        // 新建文件
        File filepath = new File(path, newImgName);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + newImgName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "createPage";
    }

}
