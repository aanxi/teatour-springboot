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
@TableName(value = "teagarden")
public class TeaGarden {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String sub_title;

    private Float price;

    private Integer sale;

    private Integer stock;

    private String introduction;

    private Integer teaGardenCategory_id;

    private Integer teaGardenReviewCount;


}