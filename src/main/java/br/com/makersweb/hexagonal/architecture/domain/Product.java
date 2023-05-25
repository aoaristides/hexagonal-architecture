package br.com.makersweb.hexagonal.architecture.domain;

import br.com.makersweb.hexagonal.architecture.domain.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author aaristides
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private UUID id;
    private String sku;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public Product(ProductDTO productDTO) {
        this.sku = productDTO.getSku();
        this.name = productDTO.getName();
        this.price = productDTO.getPrice();
        this.quantity = productDTO.getQuantity();
    }

    public void updateStock(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDTO toProductDTO() {
        return new ProductDTO(this.sku, this.name, this.price, this.quantity);
    }

}
