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
@TableName(value = "newprodrev")
public class NewProdRev {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String content;

    private Integer user_id;

    private Integer newProd_id;

    private Date createDate;

    private User user;

}