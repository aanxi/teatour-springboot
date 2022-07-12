package cn.teatour.mapper;

import cn.teatour.pojo.TeaGardenReview;
import cn.teatour.pojo.TeaGardenReviewExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeaGardenReviewMapper extends BaseMapper<TeaGardenReview> {
    int deleteByPrimaryKey(Integer id);

    int insert(TeaGardenReview record);

    int insertSelective(TeaGardenReview record);

    List<TeaGardenReview> selectByExample(TeaGardenReviewExample example);

    TeaGardenReview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeaGardenReview record);

    int updateByPrimaryKey(TeaGardenReview record);
}