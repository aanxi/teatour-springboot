package cn.teatour.mapper;

import cn.teatour.pojo.TeaGardenCategory;
import cn.teatour.pojo.TeaGardenCategoryExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeaGardenCategoryMapper extends BaseMapper<TeaGardenCategory> {
    int deleteByPrimaryKey(Integer id);

    int insert(TeaGardenCategory record);

    int insertSelective(TeaGardenCategory record);

    List<TeaGardenCategory> selectByExample(TeaGardenCategoryExample example);

    TeaGardenCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeaGardenCategory record);

    int updateByPrimaryKey(TeaGardenCategory record);
}