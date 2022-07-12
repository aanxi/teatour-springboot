package cn.teatour.service.serviceImpl;

import cn.teatour.mapper.AppointmentItemMapper;
import cn.teatour.pojo.Appointment;
import cn.teatour.pojo.AppointmentItem;
import cn.teatour.pojo.AppointmentItemExample;
import cn.teatour.pojo.TeaGarden;
import cn.teatour.service.AppointmentItemService;
import cn.teatour.service.TeaGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AppointmentItemService 实现类
 *
 * @author: @zj
 * @create: 2022-04-29-上午 10:15
 */
@Service
public class AppointmentItemServiceImpl implements AppointmentItemService {

    @Autowired
    AppointmentItemMapper appointmentItemMapper;

    @Autowired
    TeaGardenService teaGardenService;

    @Override
    public void add(AppointmentItem appointmentItem) {
        appointmentItemMapper.insert(appointmentItem);
    }

    @Override
    public AppointmentItem getById(Integer id) {
        AppointmentItem appointmentItem = appointmentItemMapper.selectByPrimaryKey(id);
        setTeaGarden(appointmentItem);
        return appointmentItem;
    }

    @Override
    public List<AppointmentItem> getByAppointmentId(Integer appointment_id) {
        AppointmentItemExample example = new AppointmentItemExample();
        example.or().andAppointment_idEqualTo(appointment_id);
        List<AppointmentItem> result = appointmentItemMapper.selectByExample(example);
        setTeaGarden(result);
        return result;
    }

    @Override
    public void update(AppointmentItem appointmentItem) {
        appointmentItemMapper.updateByPrimaryKey(appointmentItem);
    }

    @Override
    public List<AppointmentItem> listByUserId(Integer user_id) {
        AppointmentItemExample example = new AppointmentItemExample();
        example.or().andUser_idEqualTo(user_id);
        List<AppointmentItem> result = appointmentItemMapper.selectByExample(example);
        setTeaGarden(result);
        return result;
    }

    @Override
    public List<AppointmentItem> listForCart(Integer user_id) {
        AppointmentItemExample example = new AppointmentItemExample();
        example.or().andUser_idEqualTo(user_id).andAppointment_idIsNull();
        List<AppointmentItem> result = appointmentItemMapper.selectByExample(example);
        setTeaGarden(result);
        return result;
    }

    public void setTeaGarden(List<AppointmentItem> ois) {
        for (AppointmentItem oi : ois) {
            setTeaGarden(oi);
        }
    }

    private void setTeaGarden(AppointmentItem oi) {
        TeaGarden p = teaGardenService.get(oi.getTeaGarden_id());
        oi.setTeaGarden(p);
    }

    @Override
    public void delete(Integer id) {
        appointmentItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void fill(List<Appointment> appointments) {
        for (Appointment o : appointments) {
            fill(o);
        }
    }

    @Override
    public void fill(Appointment appointment) {
        AppointmentItemExample example = new AppointmentItemExample();
        example.or().andAppointment_idEqualTo(appointment.getId());
        example.setAppointmentByClause("id desc");
        List<AppointmentItem> appointmentItems = appointmentItemMapper.selectByExample(example);
        setTeaGarden(appointmentItems);

        float total = 0;
        int totalNumber = 0;
        for (AppointmentItem oi : appointmentItems) {
            total += oi.getNumber() * oi.getTeaGarden().getPrice();
            totalNumber += oi.getNumber();
        }
        appointment.setTotal(total);
        appointment.setTotalNumber(totalNumber);
        appointment.setAppointmentItems(appointmentItems);
    }
}
