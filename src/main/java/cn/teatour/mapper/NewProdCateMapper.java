package cn.teatour.mapper;

import cn.teatour.pojo.NewProdCate;
import cn.teatour.pojo.NewProdCateExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewProdCateMapper extends BaseMapper<NewProdCate> {
    int deleteByPrimaryKey(Integer id);

    int insert(NewProdCate record);

    int insertSelective(NewProdCate record);

    List<NewProdCate> selectByExample(NewProdCateExample example);

    NewProdCate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewProdCate record);

    int updateByPrimaryKey(NewProdCate record);
}