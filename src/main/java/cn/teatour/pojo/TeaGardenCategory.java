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
@TableName(value = "teagardencategory")
public class TeaGardenCategory {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private List<TeaGarden> teaGardens;

    private List<List<TeaGarden>> teaGardenByRow;

}