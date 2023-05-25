package br.com.makersweb.hexagonal.architecture.domain.ports.interfaces;

import br.com.makersweb.hexagonal.architecture.domain.dtos.ProductDTO;
import br.com.makersweb.hexagonal.architecture.domain.dtos.StockDTO;
import br.com.makersweb.hexagonal.architecture.domain.ports.exceptions.NotFoundException;

import java.util.List;

/**
 * @author aaristides
 */
public interface ProductServicePort {

    List<ProductDTO> findProducts();

    ProductDTO findBySku(String sku);

    void createProduct(ProductDTO productDTO);

    void updateStock(String sku, StockDTO stockDTO) throws NotFoundException;

}
