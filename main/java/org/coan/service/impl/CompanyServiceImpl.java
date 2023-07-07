package org.coan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coan.mapper.CompanyMapper;
import org.coan.pojo.Company;
import org.coan.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {
}
