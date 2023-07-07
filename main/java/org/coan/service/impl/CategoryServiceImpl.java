package org.coan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coan.mapper.CategoryMapper;
import org.coan.pojo.Category;
import org.coan.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
