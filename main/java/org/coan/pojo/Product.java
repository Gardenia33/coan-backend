package org.coan.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "products")
public class Product {
    @TableId(type = IdType.AUTO)
    private Long productId;
    private String name;
    private  String description;
    private  Double price;
    private  String category;
    private  String company;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Long turnover;
    private String imageUrl;

}
