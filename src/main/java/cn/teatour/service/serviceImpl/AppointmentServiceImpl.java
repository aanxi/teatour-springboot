package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.AppointmentMapper;
import cn.teatour.pojo.Appointment;
import cn.teatour.pojo.AppointmentExample;
import cn.teatour.pojo.AppointmentItem;
import cn.teatour.service.AppointmentItemService;
import cn.teatour.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * AppointmentService 实现类
 *
 * @author: @zj
 * @create: 2022-04-29-上午 10:19
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentMapper appointmentMapper;

    @Autowired
    AppointmentItemService appointmentItemService;

    @Override
    public Appointment get(int id) {
        return appointmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Appointment> listAll() {
        AppointmentExample example = new AppointmentExample();
        return appointmentMapper.selectByExample(example);
    }

    @Override
    public List<Appointment> list(Integer user_id, String excludedStatus) {
        AppointmentExample example = new AppointmentExample();
        example.or().andUser_idEqualTo(user_id).andStatusNotEqualTo(excludedStatus);
        example.setAppointmentByClause("id desc");
        return appointmentMapper.selectByExample(example);
    }

    @Override
    public List<Appointment> listByUserId(Integer user_id) {
        AppointmentExample example = new AppointmentExample();
        example.or().andUser_idEqualTo(user_id);
        return appointmentMapper.selectByExample(example);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentMapper.updateByPrimaryKey(appointment);
    }

    @Override
    public void add(Appointment c) {
        appointmentMapper.insert(c);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public float add(Appointment appointment, List<AppointmentItem> appointmentItems) {
        float total = 0;
        add(appointment);

        // 用来模拟当增加订单后出现异常，观察事务管理是否预期发生
        if (false)
            throw new RuntimeException();

        for (AppointmentItem oi : appointmentItems) {
            oi.setAppointment_id(appointment.getId());
            appointmentItemService.update(oi);
            total += oi.getTeaGarden().getPrice() * oi.getNumber();
        }
        return total;
    }
}
