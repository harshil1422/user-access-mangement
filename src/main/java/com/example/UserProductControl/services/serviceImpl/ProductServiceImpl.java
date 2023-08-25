package com.example.UserProductControl.services.serviceImpl;

import com.example.UserProductControl.dtos.ProductDTO;
import com.example.UserProductControl.entities.Product;
import com.example.UserProductControl.exception.ResourceNotFoundException;
import com.example.UserProductControl.repository.ProductRepository;
import com.example.UserProductControl.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {

    private ModelMapper modelMapper;
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDtoList = productList.stream().map(product -> mapToDto(product))
                                                               .collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = mapToEntity(productDTO);
        Product result = productRepository.save(product);
        return mapToDto(result);
    }

    @Override
    public List<ProductDTO> searchProductsByName(String name) {
        List<Product> productsByName = productRepository.findProductsByName(name);
        List<ProductDTO> productDtoByName = productsByName.stream().map(product -> mapToDto(product))
                .collect(Collectors.toList());
        return productDtoByName;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return mapToDto(product);
    }

    private  Product mapToEntity(ProductDTO productDTO){
        return modelMapper.map(productDTO,Product.class);
    }

    private  ProductDTO mapToDto(Product product){
        return modelMapper.map(product,ProductDTO.class);
    }
}
