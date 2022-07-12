package cn.teatour.mapper;

import cn.teatour.pojo.Product;
import cn.teatour.pojo.ProductExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    void updateSaleAndStock(@Param("productId") Integer product_id,
                            @Param("newStock") Integer newStock,
                            @Param("newSale") Integer newSale);

    Integer selectProductStockAndLock(@Param("productId") Integer productId);

    Integer selectProductSaleAndLock(@Param("productId")Integer productId);
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Product record);
//
//    int insertSelective(Product record);

//    List<Product> selectByKeyword(ProductExample example);

//    Product selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Product record);
//
//    int updateByPrimaryKey(Product record);
}