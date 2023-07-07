package org.coan.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.coan.mapper.ProductMapper;
import org.coan.pojo.Product;
import org.coan.service.CategoryService;
import org.coan.service.CompanyService;
import org.coan.service.ProductImageService;
import org.coan.service.ProductService;
import org.coan.util.QiNuUtils;
import org.coan.util.R;
import org.coan.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Api(tags = "后台接口")
@RestController
public class ManagerController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProductMapper productMapper;
    @ApiOperation(value = "后台获取产品")
    @GetMapping("manager/showproduct")
    public Result showProduct(){
        List<Product> list = productService.list();
        return Result.success(list);
    }
    @ApiOperation(value = "后台根据id删除产品")
    @DeleteMapping("manager/deleteproduct/{id}")
    public Result deleteProduct(@PathVariable Long id) {
        productService.removeById(id);

        return Result.success();
    }
    @ApiOperation(value = "后台表单上传产品")
    @PostMapping("manager/uploadproduct")
    public Result uploadFile(String name , String description, Double price , String category, String company, Long turnover, MultipartFile smfile) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);
        product.setCompany(company);
        product.setTurnover(turnover);
        String fileUrl = QiNuUtils.upload2Qiniu(smfile.getBytes(), name);
        product.setImageUrl(fileUrl);
        productService.save(product);
        //System.out.println("上传成功");
        return Result.success(product);

    }

    @GetMapping("manager/echarts/normal")
    public Result echarts1(){
        long total =0;
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category","normal");
        List<Product> list = productService.list(queryWrapper);
        for (Product p : list) {
            total = total + p.getTurnover();
        }
        System.out.println(total);
        return Result.success(total);

    }
    @GetMapping("manager/echarts/nft")
    public Result echarts2(){
        long total =0;
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category","NFT");
        List<Product> list = productService.list(queryWrapper);
        for (Product p : list) {
            total = total + p.getTurnover();
        }
        System.out.println(total);
        return Result.success(total);

    }
    @GetMapping("manager/echarts/company")
    public Result echarts3(){



        return Result.success(productService.returnTurnover());

    }



}
