package br.com.makersweb.hexagonal.architecture.infrastructure.adapters.repositories.impl;

import br.com.makersweb.hexagonal.architecture.domain.Product;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.ProductRepositoryPort;
import br.com.makersweb.hexagonal.architecture.infrastructure.adapters.entity.ProductEntity;
import br.com.makersweb.hexagonal.architecture.infrastructure.adapters.repositories.ProductJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author aaristides
 */
@Slf4j
@AllArgsConstructor
@Component
public class ProductRepository implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public List<Product> findAll() {
        log.info("Init method findAll.");
        var productEntities = this.productJpaRepository.findAll();
        return productEntities.stream().map(ProductEntity::toProduct).collect(Collectors.toList());
    }

    @Override
    public Product findBySku(String sku) {
        log.info("Init method findBySku by sku - {}", sku);
        var productEntity = this.productJpaRepository.findBySku(sku);

        if (productEntity.isPresent())
            return productEntity.get().toProduct();

        throw new RuntimeException("Produto não existe");
    }

    @Override
    public void save(Product product) {
        log.info("Init method save by sku - {}", product.getSku());
        ProductEntity productEntity;
        if (Objects.isNull(product.getId())) {
            productEntity = new ProductEntity(product);
        } else {
            productEntity = this.productJpaRepository.findById(product.getId()).get();
            productEntity.update(product);
        }

        this.productJpaRepository.save(productEntity);
    }
}
