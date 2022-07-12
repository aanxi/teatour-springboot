package cn.teatour.service;

import cn.teatour.pojo.Order;
import cn.teatour.pojo.OrderItem;

import java.util.List;

public interface OrderService {

    //订单流程：支付 —> 发货 -> 收货确认 —> 评价 -> 完成
    String waitPay = "waitPay";//待支付
    String waitDelivery = "waitDelivery";//待发货
    String waitConfirm = "waitConfirm";//待收货确认
    String waitReview = "waitReview";//待评价
    String finish = "finish";//完成
    String delete = "delete";//已删除

    /**
     * 根据ID返回对应的Order
     *
     * @param id
     * @return
     */
    Order get(int id);

    /**
     * 返回所有的订单
     *
     * @return
     */
    List<Order> listAll();

    /**
     * 按照用户、订单状态来查询
     * 默认排除已删除的订单
     *
     * @param user_id
     * @param excludedStatus
     * @return
     */
    List<Order> list(Integer user_id, String excludedStatus);

    /**
     * 返回user_id下的所有订单
     *
     * @param user_id
     * @return
     */
    List<Order> listByUserId(Integer user_id);

    /**
     * 更新订单
     *
     * @param order
     */
    void update(Order order);

    /**
     * 增加订单
     *
     * @param order
     */
    void add(Order order);

    /**
     * 增加订单，返回一个float类型的数值用来表示该订单的总价
     *
     * @param order
     * @param orderItems
     * @return
     */
    float add(Order order, List<OrderItem> orderItems);
}
