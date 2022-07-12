package cn.teatour.mapper;

import cn.teatour.pojo.NewProd;
import cn.teatour.pojo.NewProdRev;
import cn.teatour.pojo.NewProdRevExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewProdRevMapper extends BaseMapper<NewProdRev> {
    int deleteByPrimaryKey(Integer id);

    int insert(NewProdRev record);

    int insertSelective(NewProdRev record);

    List<NewProdRev> selectByExample(NewProdRevExample example);

    NewProdRev selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewProdRev record);

    int updateByPrimaryKey(NewProdRev record);
}