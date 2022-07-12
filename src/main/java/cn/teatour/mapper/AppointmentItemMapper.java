package cn.teatour.mapper;

import cn.teatour.pojo.AppointmentItem;
import cn.teatour.pojo.AppointmentItemExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppointmentItemMapper extends BaseMapper<AppointmentItem> {
    int deleteByPrimaryKey(Integer id);

    int insert(AppointmentItem record);

    int insertSelective(AppointmentItem record);

    List<AppointmentItem> selectByExample(AppointmentItemExample example);

    AppointmentItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppointmentItem record);

    int updateByPrimaryKey(AppointmentItem record);
}