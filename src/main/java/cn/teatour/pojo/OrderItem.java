package cn.teatour.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "orderItem")
public class OrderItem {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer product_id;

    private Integer order_id;

    private Integer user_id;

    private Integer number;

    private Product product;

    public Product getProduct() {
        return product;
    }

}