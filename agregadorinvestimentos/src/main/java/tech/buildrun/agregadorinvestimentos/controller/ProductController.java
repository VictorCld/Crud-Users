package tech.buildrun.agregadorinvestimentos.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.buildrun.agregadorinvestimentos.dto.UserDto.CreateProductDto;
import tech.buildrun.agregadorinvestimentos.dto.UserDto.ProductDto;
import tech.buildrun.agregadorinvestimentos.service.ProductService;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    public ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(value = "product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(dto));
    }
    
    @GetMapping(value = "product")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<List<ProductDto>> getProductsByUser(@PathVariable UUID userId){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductsByUser(userId));
    }


}
