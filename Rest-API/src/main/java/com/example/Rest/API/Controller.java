package com.example.Rest.API;

import com.example.Rest.API.Components.Customer;
import com.example.Rest.API.DTO.CustomerDTO;
import com.example.Rest.API.DTO.ProductDTO;
import com.example.Rest.API.DTO.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {
    @Autowired
    private Service servico;

    @PutMapping("customer")
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customer) throws Exception {
        return this.servico.addCustomer(customer);
    }

    @DeleteMapping("customer")
    public void deleteCustomer(@RequestHeader String id) throws Exception {
       servico.deleteCustomer(id);
    }

    @GetMapping("customer")
    public CustomerDTO getCustomer(@RequestHeader String id) throws Exception {
        return servico.getCustomerById(id);
    }

    @GetMapping("product")
    public ProductDTO getProduct(@RequestHeader String id) throws Exception {
        return servico.getProduct(id);
    }

    @PutMapping("product")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) throws Exception {
        return servico.addProduct(productDTO);
    }

    @DeleteMapping("product")
    public void deleteProduct(@RequestHeader String id) throws Exception {
        servico.deleteProduct(id);
    }

    @GetMapping("request")
    public RequestDTO getRequest(@RequestHeader String id) throws Exception {
        return servico.getRequest(id);
    }

    @GetMapping("request/customer")
    public ArrayList<RequestDTO> getRequestCustomer(@RequestHeader String customerId) throws Exception {
        return servico.getRequestsCustomer(customerId);
    }

    @PutMapping("request")
    public RequestDTO addRequest(@RequestBody RequestDTO requestDTO) throws Exception {
        return servico.addRequest(requestDTO);
    }

    @PutMapping("request/Product")
    public void addProductRquest(@RequestHeader String idReq, @RequestHeader String productId) throws Exception {
        servico.addProductToRequest(idReq,productId);
    }
}
