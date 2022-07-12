package cn.teatour.mapper;

import cn.teatour.pojo.NewProdImage;
import cn.teatour.pojo.NewProdImageExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewProdImageMapper extends BaseMapper<NewProdImage> {
    int deleteByPrimaryKey(Integer id);

    int insert(NewProdImage record);

    int insertSelective(NewProdImage record);

    List<NewProdImage> selectByExample(NewProdImageExample example);

    NewProdImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewProdImage record);

    int updateByPrimaryKey(NewProdImage record);
}