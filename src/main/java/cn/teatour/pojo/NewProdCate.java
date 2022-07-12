package cn.teatour.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "newprodcate")
public class NewProdCate {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private List<NewProd> newProds;

    private List<List<NewProd>> newProdByRow;

}