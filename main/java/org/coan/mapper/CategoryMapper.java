package org.coan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.coan.pojo.Category;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
