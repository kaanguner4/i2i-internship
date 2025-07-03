package com.example.swaggerex;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    private final Map<Long, CustomerDTO> customerMap = new HashMap<>();
    private long idCounter = 1L;

    public CustomerDTO createCustomer(CustomerDTO dto) {
        dto.setId(idCounter++);
        customerMap.put(dto.getId(), dto);
        return dto;
    }

    public List<CustomerDTO> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    public CustomerDTO getCustomerById(Long id) {
        return customerMap.get(id);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        if (!customerMap.containsKey(id)) return null;
        dto.setId(id);
        customerMap.put(id, dto);
        return dto;
    }

    public boolean deleteCustomer(Long id) {
        return customerMap.remove(id) != null;
    }
}
