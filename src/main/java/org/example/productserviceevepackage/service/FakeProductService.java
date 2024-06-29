package org.example.productserviceevepackage.service;

import org.example.productserviceevepackage.FakeStoreProductDto;
import org.example.productserviceevepackage.models.Category;
import org.example.productserviceevepackage.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeProductService implements ProductService {

    private RestTemplate restTemplate;
    public FakeProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    Product convertFakestoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getDescription());
        product.setCategory(category);

        return product;

    }

    @Override
    public Product getProductById(Long id) {
        //call fakestore Api to get the product detail of given id.
       FakeStoreProductDto fakeStoreProductDto= restTemplate.getForObject("https://fakestoreapi.com/products/"+id,FakeStoreProductDto.class); //(url,return object)

        if(fakeStoreProductDto==null) return null;

       //convert fakestore product dto into product
        return convertFakestoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
