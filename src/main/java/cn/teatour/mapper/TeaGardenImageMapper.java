package cn.teatour.mapper;

import cn.teatour.pojo.TeaGardenImage;
import cn.teatour.pojo.TeaGardenImageExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeaGardenImageMapper extends BaseMapper<TeaGardenImage> {
    int deleteByPrimaryKey(Integer id);

    int insert(TeaGardenImage record);

    int insertSelective(TeaGardenImage record);

    List<TeaGardenImage> selectByExample(TeaGardenImageExample example);

    TeaGardenImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeaGardenImage record);

    int updateByPrimaryKey(TeaGardenImage record);
}