package cn.teatour.service;

import cn.teatour.pojo.Appointment;
import cn.teatour.pojo.AppointmentItem;

import java.util.List;

public interface AppointmentService {

    String waitPay = "waitPay";//待支付
    String waitDelivery = "waitDelivery";//待使用
    String waitConfirm = "waitConfirm";//待确认
    String waitTeaGardenReview = "waitTeaGardenReview";//待评价
    String finish = "finish";
    String delete = "delete";

    /**
     * 根据ID返回对应的Appointment
     *
     * @param id
     * @return
     */
    Appointment get(int id);

    /**
     * 返回所有的订单
     *
     * @return
     */
    List<Appointment> listAll();

    /**
     * 按照用户、订单状态来查询
     *
     * @param user_id
     * @param excludedStatus
     * @return
     */
    List<Appointment> list(Integer user_id, String excludedStatus);

    /**
     * 返回user_id下的所有预约
     *
     * @param user_id
     * @return
     */
    List<Appointment> listByUserId(Integer user_id);

    /**
     * 更新订单
     *
     * @param appointment
     */
    void update(Appointment appointment);

    /**
     * 增加订单
     *
     * @param appointment
     */
    void add(Appointment appointment);

    /**
     * 增加订单，返回一个float类型的数值用来表示该订单的总价
     *
     * @param appointment
     * @param appointmentItems
     * @return
     */
    float add(Appointment appointment, List<AppointmentItem> appointmentItems);
}
