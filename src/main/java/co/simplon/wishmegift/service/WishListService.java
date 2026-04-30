package co.simplon.wishmegift.service;

import co.simplon.wishmegift.entity.WishListEntity;
import co.simplon.wishmegift.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;
    private WishListEntity wishListEntity;

    public WishListEntity saveWishList(WishListEntity wishListEntity) {
        return wishListRepository.save(wishListEntity);
    }
    public Optional<WishListEntity> getWishList(@PathVariable UUID id) {return wishListRepository.findById(id);}

}
