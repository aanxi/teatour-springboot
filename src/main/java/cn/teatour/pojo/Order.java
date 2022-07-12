package cn.teatour.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "order")
public class Order {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String order_code;

    private String address;

    private String post;

    private String receiver;

    private String mobile;

    private String user_message;

    private Date create_date;

    private Date pay_date;

    private Date delivery_date;

    private Date confirm_date;

    private Integer user_id;

    private String status;

    /*如下是非数据库字段*/
    private List<OrderItem> orderItems;

    private User user;

    private float total;

    private int totalNumber;

}