package com.sales.promotion.service;

import com.sales.promotion.model.Promotion;
import com.sales.promotion.repository.PromotionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepositoryImpl promotionRepository;

    @Autowired
    private ClientService clientService;

    public Promotion save(Promotion promotion){
        return promotionRepository.save(promotion);
    }

    public List<Promotion> findAll(){
        return promotionRepository.findAll();
    }
}
