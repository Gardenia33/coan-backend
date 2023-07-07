package org.coan.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "company")
public class Company {
    @TableId(type = IdType.AUTO)
    private Long companyId;
    private String companyName;
    private String companyEmail;
    private Long companyPhone;
}
