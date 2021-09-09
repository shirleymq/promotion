package com.sales.promotion.service;

import com.sales.promotion.model.Client;
import com.sales.promotion.repository.ClientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepositoryImpl clientRepository;

    public Client getById(Long id){
        return clientRepository.getById(id);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public List<Client> findAllByBirthday(String day, String month){
        return clientRepository.findAllByBirthday(day, month);
    }
}
