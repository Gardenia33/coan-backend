package org.coan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coan.mapper.ProductImageMapper;
import org.coan.pojo.ProductImages;
import org.coan.service.ProductImageService;
import org.coan.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl extends ServiceImpl<ProductImageMapper, ProductImages> implements ProductImageService {
}
