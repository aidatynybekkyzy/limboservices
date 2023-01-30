package com.mycompany.customer.service;

import com.mycompany.customer.FraudCheckResponse;
import com.mycompany.customer.entity.Customer;
import com.mycompany.customer.entity.CustomerRegistrationRequest;
import com.mycompany.customer.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo check if email is valid
        //todo check if email is not taken
        customerRepo.saveAndFlush(customer);
        //todo check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http:localhost:8081/api/v1/fraud-chec/{customerId}k",
                FraudCheckResponse.class,
                customer.getId()
        );
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");

        }

        // todo send notification
    }
}
