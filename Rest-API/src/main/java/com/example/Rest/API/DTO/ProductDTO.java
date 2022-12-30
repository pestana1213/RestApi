package com.example.Rest.API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private String name;
    private String description;
    private float preco_compra;
    private float preco_venda;
}
