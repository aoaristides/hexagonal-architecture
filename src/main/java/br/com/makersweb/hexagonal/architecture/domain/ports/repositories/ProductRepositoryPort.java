package br.com.makersweb.hexagonal.architecture.domain.ports.repositories;

import br.com.makersweb.hexagonal.architecture.domain.Product;

import java.util.List;

/**
 * @author aaristides
 */
public interface ProductRepositoryPort {

    List<Product> findAll();

    Product findBySku(String sku);

    void save(Product product);

}
