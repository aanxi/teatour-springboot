package cn.teatour.service;

import cn.teatour.pojo.Appointment;
import cn.teatour.pojo.AppointmentItem;

import java.util.List;

public interface AppointmentItemService {

    /**
     * 通过id返回AppointmentItem项
     *
     * @param id
     * @return
     */
    AppointmentItem getById(Integer id);

    /**
     * 增加一条订单数据
     *
     * @param appointmentItem
     */
    void add(AppointmentItem appointmentItem);

    /**
     * 通过订单id查询到该订单下所有的Item
     *
     * @param appointment_id
     * @return
     */
    List<AppointmentItem> getByAppointmentId(Integer appointment_id);

    /**
     * 更新AppointmentItem，也只是更新number属性
     *
     * @param appointmentItem
     */
    void update(AppointmentItem appointmentItem);

    /**
     * 根据user_id来该用户下对应的所有预约项
     *
     * @param user_id
     * @return
     */
    List<AppointmentItem> listByUserId(Integer user_id);

    /**
     * 返回当前user_id下的购物车订单列表
     *
     * @param user_id
     * @return
     */
    List<AppointmentItem> listForCart(Integer user_id);

    /**
     * 通过id删除订单项
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 为List<Appointment>填充订单项
     *
     * @param appointments
     */
    void fill(List<Appointment> appointments);

    /**
     * 为Appointment填充订单项
     *
     * @param o
     */
    void fill(Appointment o);
}
