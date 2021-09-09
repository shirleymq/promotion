package com.sales.promotion.service;

import com.sales.promotion.model.Client;
import com.sales.promotion.model.Promotion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(properties = { "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect" })
class PromotionServiceTest {

    private String day = "9";
    private String month = "9";

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmailServiceImpl emailService;

    @Test
    void sendEmail(){
        Client client1 = new Client();
        Client client2 = new Client();

        client1.setName("Shirley");
        client1.setBirthDay("9");
        client1.setBirthMonth("9");
        client1.setEmail("shirley.quelali@gmail.com");

        client2.setName("Carla");
        client2.setBirthDay("24");
        client2.setBirthMonth("3");
        client2.setEmail("shirley.quelali@gmail.com");

        Client finalClient1 = clientService.save(client1);
        Client finalClient2 = clientService.save(client2);

        List<Client> clientList = clientService.findAllByBirthday(day,month);
        System.out.println("BIRTHDAY CLIENTS:");
        for (int i = 0; i<clientList.size(); i++){
            Client birthdayClient = clientList.get(i);
            String name= birthdayClient.getName();
            System.out.println(name);
            Promotion promotion = new Promotion();
            promotion.setDescription(name +", Hoy es su cumpleaños y usted es importante para nosotros,\" +\n" +
                    "                \" queremos celebralo ofreciendo un descuento y delivery gratuito. Valido por 24 hrs");
            Promotion finalPromotion = promotionService.save(promotion);
            emailService.sendSimpleMessage(birthdayClient.getEmail(),"PROMOTION",finalPromotion.getDescription());
            System.out.println(finalPromotion.getDescription());
        }
    }
}