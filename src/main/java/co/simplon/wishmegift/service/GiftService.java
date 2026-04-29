package co.simplon.wishmegift.service;

import co.simplon.wishmegift.entity.GiftEntity;
import co.simplon.wishmegift.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    @Autowired
    private GiftRepository giftRepository;

    public List<GiftEntity> getAllGifts() {
        return giftRepository.findAll();
    }

    public GiftEntity createGift(GiftEntity gift) {
        return giftRepository.save(gift);
    }
}
