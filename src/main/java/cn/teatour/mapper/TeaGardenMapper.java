package cn.teatour.mapper;

import cn.teatour.pojo.TeaGarden;
import cn.teatour.pojo.TeaGardenExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeaGardenMapper extends BaseMapper<TeaGarden> {
    int deleteByPrimaryKey(Integer id);

    int insert(TeaGarden record);

    int insertSelective(TeaGarden record);

    List<TeaGarden> selectByExample(TeaGardenExample example);

    TeaGarden selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeaGarden record);

    int updateByPrimaryKey(TeaGarden record);
}