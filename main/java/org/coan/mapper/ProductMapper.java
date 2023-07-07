package org.coan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.coan.pojo.Product;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    @Select("SELECT company, SUM(turnover) as totalTurnover\n" +
            "FROM products\n" +
            "GROUP BY company;")
    public List<Map<String, Objects>> returnTurnover();
}
