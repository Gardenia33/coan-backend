package org.coan.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVo {
    private Long productId;
    private String name;
    private  String description;
    private  Double price;
    private  String category;
    private  String company;
    private Long turnover;
    private String imageUrl;
}
