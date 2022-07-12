package cn.teatour.mapper;

import cn.teatour.pojo.NewProd;
import cn.teatour.pojo.NewProdExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewProdMapper extends BaseMapper<NewProd> {
    int deleteByPrimaryKey(Integer id);

    int insert(NewProd record);

    int insertSelective(NewProd record);

    List<NewProd> selectByExample(NewProdExample example);

    NewProd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewProd record);

    int updateByPrimaryKey(NewProd record);
}