package cn.teatour.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "appointment")
public class Appointment {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String appointment_code;

    private String receiver;

    private String mobile;

    private String user_message;

    private Date create_date;

    private Date pay_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")  //,timezone=”GMT+8”
    private Date delivery_date;//预约日期

    private Date confirm_date;//订单完成时间

    private Integer user_id;

    private String status;

    /*如下是非数据库字段*/
    private List<AppointmentItem> appointmentItems;

    private User user;

    private float total;

    private int totalNumber;


}