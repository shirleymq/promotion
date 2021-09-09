package com.sales.promotion.repository;

import com.sales.promotion.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepositoryImpl extends ClientRepository{
    default List<Client> findAllByBirthday(String day, String month){
        List<Client> list = new ArrayList<Client>();
        Client client;
        List<Client> clients = findAll();
        int size = clients.size();
        for (int i =0; i<size; i++){
            client = clients.get(i);
            if((client.getBirthDay().equals(day))&&client.getBirthMonth().equals(month)) {
                list.add(client);
            }
        }
        return list;
    }
}
