package com.example.Rest.API.Components;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String productId;
    private String customerId;
}
