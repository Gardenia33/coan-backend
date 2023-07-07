package org.coan.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.coan.pojo.Category;
import org.coan.pojo.Company;
import org.coan.pojo.Product;
import org.coan.pojo.ProductImages;
import org.coan.pojo.vo.ProductVo;
import org.coan.service.CategoryService;
import org.coan.service.CompanyService;
import org.coan.service.ProductImageService;
import org.coan.service.ProductService;

import org.coan.util.QiNuUtils;
import org.coan.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NormalPropertyController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImageService productImageService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CompanyService companyService;

    int pictureName =7;


    @GetMapping("/normalproperty/shownormalproduct")
    public Result showNormalProduct(){
        LambdaQueryWrapper<Product> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Product::getCategory,"normal");
       List<Product> list =productService.list(lambdaQueryWrapper);
        List<ProductVo> productVos = new ArrayList<>();
        for (Product product : list) {
            ProductVo vo = new ProductVo();
            BeanUtils.copyProperties(product,vo);
            productVos.add(vo);
        }
        return Result.success(productVos);

    }
    @GetMapping("/normalproperty/showNFTproduct")
    public Result showNFTProduct(){
        LambdaQueryWrapper<Product> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Product::getCategory,"NFT");
        List<Product> list =productService.list(lambdaQueryWrapper);
        List<ProductVo> productVos = new ArrayList<>();
        for (Product product : list) {
            ProductVo vo = new ProductVo();
            BeanUtils.copyProperties(product,vo);
            productVos.add(vo);
        }
        return Result.success(productVos);

    }

//    @GetMapping("/normalproperty/picture/{productId}")
//    public Result showPicture(@PathVariable Long productId){
//
//       LambdaQueryWrapper<ProductImages> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//       lambdaQueryWrapper.eq(ProductImages::getProductId,productId);
//        ProductImages productImages = productImageService.getOne(lambdaQueryWrapper);
//
//        return Result.success(productImages);
//
//    }
//    @GetMapping("/normalproperty/category/{categoryId}")
//    public Result showCategory(@PathVariable Long categoryId){
//        System.out.println("成功");
//       Category category = categoryService.getById(categoryId);
//        return Result.success(category);
//
//    }
//    @GetMapping("/normalproperty/company/{companyId}")
//    public Result showCompany(@PathVariable Long companyId){
//        Company company =  companyService.getById(companyId);
//        return Result.success(company);
//
//    }

    @PostMapping("/normalproperty/upload")
    public Result uploadFile(String name , String description,Double price ,String category, String company, Long turnover,MultipartFile smfile) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category);
        product.setCompany(company);
        product.setTurnover(turnover);
        String fileUrl = QiNuUtils.upload2Qiniu(smfile.getBytes(),name);
        product.setImageUrl(fileUrl);
        productService.save(product);

        return Result.success(product);

    }
    @PostMapping("/normalproperty/return")
    public Result returnFile(@RequestBody MultipartFile smfile ) throws IOException {

        pictureName=pictureName +1;
        String fileUrl = QiNuUtils.upload2Qiniu(smfile.getBytes(),pictureName+"");

        return Result.success(fileUrl);

    }

}
