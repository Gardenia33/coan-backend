package org.coan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coan.mapper.ProductMapper;
import org.coan.pojo.Product;
import org.coan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Map<String, Objects>> returnTurnover() {

        return productMapper.returnTurnover();
    }
}
