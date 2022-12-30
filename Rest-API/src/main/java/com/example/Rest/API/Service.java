package com.example.Rest.API;

import com.example.Rest.API.Components.Customer;
import com.example.Rest.API.Components.Product;
import com.example.Rest.API.Components.Request;
import com.example.Rest.API.DTO.CustomerDTO;
import com.example.Rest.API.DTO.ProductDTO;
import com.example.Rest.API.DTO.RequestDTO;
import com.example.Rest.API.Repositories.CustomerRepo;
import com.example.Rest.API.Repositories.ProductRepo;
import com.example.Rest.API.Repositories.RequestRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private CustomerRepo customers;
    @Autowired
    private ProductRepo products;
    @Autowired
    private RequestRepo requests;
    private ModelMapper modelMapper = new ModelMapper();

    public CustomerDTO getCustomerById(String id) throws Exception {
        Customer customer = customers.getCustomerById(UUID.fromString(id));
        if(customer!=null){
            return modelMapper.map(customer,CustomerDTO.class);
        }
        else{
            throw new Exception("Ulitizador invalido");
        }
    }

    public CustomerDTO addCustomer(CustomerDTO customer) throws Exception {
        Customer cust = customers.save( modelMapper.map(customer,Customer.class));

        if(cust!=null){
            return modelMapper.map(cust,CustomerDTO.class);
        }
        else{
            throw new Exception("Customer cant be null");
        }
    }

    public void deleteCustomer(String id) throws Exception {
        getCustomerById(id);
        customers.deleteById(UUID.fromString(id));
    }

    public ProductDTO getProduct(String produto) throws Exception {
        Product product = products.getProductById(UUID.fromString(produto));
        if(!Objects.isNull(product)){
            return modelMapper.map(product,ProductDTO.class);
        }
        else{
            throw new Exception("Produto desconhecido");
        }
    }

    public ProductDTO addProduct(ProductDTO produto) throws Exception {
        Product product = products.save(modelMapper.map(produto,Product.class));
        if (!Objects.isNull(product)){
            return modelMapper.map(product,ProductDTO.class);
        }
        else{
            throw new Exception("Produto nao adicionado");
        }
    }

    public void deleteProduct(String id) throws Exception {
        getProduct(id);
        products.deleteById(UUID.fromString(id));
    }

    public RequestDTO getRequest(String id) throws Exception {
        RequestDTO requestDTO =modelMapper.map(requests.getRequestById(UUID.fromString(id)),RequestDTO.class);
        if(!Objects.isNull(requestDTO)){
            return requestDTO;
        }
        else {
            throw new Exception("Request nao encontrado");
        }
    }

    public ArrayList<RequestDTO> getRequestsCustomer(String id) throws Exception {
        getCustomerById(id);
        return requests.getAllByCustomerId(id).stream().map(e->modelMapper.map(e,RequestDTO.class)).collect(Collectors.toCollection(ArrayList::new));
    }

    public RequestDTO addRequest(RequestDTO request) throws Exception {
        Request request1 = requests.save(modelMapper.map(request,Request.class));
        if(!Objects.isNull(request1)){
            return modelMapper.map(request1,RequestDTO.class);
        }
        else{
            throw new Exception("Request nao adicionado");
        }
    }

    public void addProductToRequest(String idRequest, String productDTO) throws Exception {
        RequestDTO req = getRequest(idRequest);
        Request aux = new Request(UUID.fromString(idRequest),productDTO,req.getCustomerId());
        requests.save(aux);
    }
}
