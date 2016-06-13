package com.srini.service;

import com.srini.dao.CardDetailDao;
import com.srini.model.MCardDetail;
import com.srini.service.CardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CardDetailServiceImpl implements CardDetailService{

    @Autowired
    private CardDetailDao cardDetailDao;

    public void addCardDetail (MCardDetail cardDetail) {
    	cardDetailDao.addCardDetail(cardDetail);
    }

 
}
