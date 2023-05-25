package br.com.makersweb.hexagonal.architecture.domain.adapters.services;

import br.com.makersweb.hexagonal.architecture.domain.Product;
import br.com.makersweb.hexagonal.architecture.domain.dtos.ProductDTO;
import br.com.makersweb.hexagonal.architecture.domain.dtos.StockDTO;
import br.com.makersweb.hexagonal.architecture.domain.ports.exceptions.NotFoundException;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.ProductServicePort;
import br.com.makersweb.hexagonal.architecture.domain.ports.repositories.ProductRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author aaristides
 */
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public List<ProductDTO> findProducts() {
        log.info("Init method findProducts.");
        var products = this.productRepositoryPort.findAll();
        return products.stream().map(Product::toProductDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findBySku(String sku) {
        log.info("Init method findBySku by sku - {}", sku);
        var product = this.productRepositoryPort.findBySku(sku);
        if (Objects.isNull(product))
            throw new NotFoundException("Produto não encontrado");
        return product.toProductDTO();
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        log.info("Init method createProduct by sku - {}", productDTO.getSku());
        var product = new Product(productDTO);
        this.productRepositoryPort.save(product);
    }

    @Override
    public void updateStock(String sku, StockDTO stockDTO) throws NotFoundException {
        log.info("Init method updateStock by sku - {}", sku);
        var product = this.productRepositoryPort.findBySku(sku);
        if (Objects.isNull(product))
            throw new NotFoundException("Produto não encontrado");

        product.updateStock(stockDTO.getQuantity());
        this.productRepositoryPort.save(product);
    }
}
