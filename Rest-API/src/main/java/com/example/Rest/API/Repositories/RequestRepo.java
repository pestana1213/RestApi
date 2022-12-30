package com.example.Rest.API.Repositories;

import com.example.Rest.API.Components.Request;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface RequestRepo extends CrudRepository<Request, UUID> {
    Request getRequestById(UUID id);
    ArrayList<Request> getAllByCustomerId(String customerId);
    Request save(Request request);
}
