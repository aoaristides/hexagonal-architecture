package br.com.makersweb.hexagonal.architecture.application.adapters.controllers;

import br.com.makersweb.hexagonal.architecture.domain.dtos.ProductDTO;
import br.com.makersweb.hexagonal.architecture.domain.dtos.StockDTO;
import br.com.makersweb.hexagonal.architecture.domain.ports.exceptions.NotFoundException;
import br.com.makersweb.hexagonal.architecture.domain.ports.interfaces.ProductServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author aaristides
 */
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductServicePort productServicePort;

    @PostMapping
    void createProduct(@RequestBody ProductDTO productDTO) {
        log.info("Init method createProduct by sku - {}", productDTO.getSku());
        this.productServicePort.createProduct(productDTO);
    }

    @GetMapping
    List<ProductDTO> getProducts() {
        log.info("Init method getProducts.");
        return this.productServicePort.findProducts();
    }

    @GetMapping(value = "/{sku}")
    ProductDTO getProduct(@PathVariable String sku) {
        log.info("Init method getProduct by sku - {}", sku);
        return this.productServicePort.findBySku(sku);
    }

    @PutMapping(value = "/{sku}")
    void updateStock(@PathVariable String sku, @RequestBody StockDTO stockDTO) throws NotFoundException {
        log.info("Init method updateStock by sku - {}", sku);
        this.productServicePort.updateStock(sku, stockDTO);
    }

}
