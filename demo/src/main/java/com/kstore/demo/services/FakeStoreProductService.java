package com.kstore.demo.services;

import com.kstore.demo.Models.Category;
import com.kstore.demo.Models.Products;
import com.kstore.demo.dto.FakeStoreResponseDto;
//import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service

public class FakeStoreProductService implements ProductServices{

    private  final RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate ;
    }




    @Override
    public Products createProduct(Products products) {

       FakeStoreResponseDto fdto= convertProductToFakeStoreDto(products);

       //return products;

        fdto=restTemplate.postForObject("https://fakestoreapi.com/products/",fdto, FakeStoreResponseDto.class );

        if (fdto != null) {
            return convertFakeStoreDtotoProduct(fdto);
        }


        return products;
    }

    @Override
    public Products getProductById(long id) {


        FakeStoreResponseDto fstd=restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreResponseDto.class);

        if(fstd==null) {
            return null;
        }
        return convertFakeStoreDtotoProduct(fstd);
    }

    @Override
    public Products updateProduct(Products products) {

      FakeStoreResponseDto fdto= convertProductToFakeStoreDto(products);
      long id=fdto.getId();
      restTemplate.put("https://fakestoreapi.com/products/"+id,fdto);
      return getProductById(fdto.getId());
    }

    @Override
    public Products deleteProduct(long id) {
        return null;
    }

    @Override
    public Products[] getAllProducts(){

        FakeStoreResponseDto[] fdto=restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreResponseDto[].class);
        Products[] product=new Products[fdto.length];
        for(int i=0;i<fdto.length;i++)
        {
            product[i]=convertFakeStoreDtotoProduct(fdto[i]);
        }
       return product;
    }


    public Products convertFakeStoreDtotoProduct(FakeStoreResponseDto ftdo){

        Products p=new Products();
        p.setId(ftdo.getId());
        p.setPrice(ftdo.getPrice());
        p.setTitle(ftdo.getTitle());
        p.setDescription(ftdo.getDescription());
        p.setImage(ftdo.getImage());

        Category c=new Category();
        c.setId(ftdo.getId());
        c.setTitle(ftdo.getCategory());

        p.setCategory(c);

        return p;
    }

    public FakeStoreResponseDto convertProductToFakeStoreDto(Products p){

        FakeStoreResponseDto fdto=new FakeStoreResponseDto();
        fdto.setPrice(p.getPrice());
        fdto.setDescription(p.getDescription());
        fdto.setImage(p.getImage());
        fdto.setTitle(p.getTitle());
        fdto.setCategory(p.getCategory().getTitle());

       return fdto;
    }
}
