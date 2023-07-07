package org.coan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.coan.mapper.ProductMapper;
import org.coan.pojo.Product;
import org.coan.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class CoanBackEndApplicationTests {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy("company");
        List list = productMapper.selectList(queryWrapper);
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i));
        }
    }
    @Test
    void test2(){
       List list =  productService.returnTurnover();
       int i = list.size();
        System.out.println(i);

    }

}

