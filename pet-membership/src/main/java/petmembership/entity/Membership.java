package petmembership.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Data
@TableName("membership_record")

public class Membership implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    private Boolean gender;

    private Integer age;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String phoneNumber;

    private BigDecimal balance;

    private Integer memberLevel;

    private Date registrationDate;

}
