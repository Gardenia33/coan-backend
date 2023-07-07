package org.coan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.coan.pojo.Product;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ProductService extends IService<Product> {
    public List<Map<String, Objects>> returnTurnover();
}
