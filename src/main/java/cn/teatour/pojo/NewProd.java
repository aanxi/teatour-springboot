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
@TableName(value = "newprod")
public class NewProd {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String sub_title;//具体描述

    private String price;

    private Integer newProdCate_id;//状态，待投票/已上线/未上线

    private Integer newProdRevCount;//已评价人数

    private Integer user_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

}