package cn.teatour.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "product")
public class Product {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String sub_title;

    private Float price;

    private Integer sale;

    private Integer stock;

    private Integer category_id;

    private Date create_date;

    private Integer reviewCount;

    public Integer getSaleXReviewCount() {
        return this.reviewCount * this.sale;
    }

}