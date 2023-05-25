package br.com.makersweb.hexagonal.architecture.domain.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author aaristides
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private String sku;
    private String name;
    private BigDecimal price;
    private Integer quantity;


}
