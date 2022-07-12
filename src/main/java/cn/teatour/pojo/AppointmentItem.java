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
@TableName(value = "appointment_item")
public class AppointmentItem {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer teaGarden_id;

    private Integer appointment_id;

    private Integer user_id;

    private Integer number;

    private TeaGarden teaGarden;

}