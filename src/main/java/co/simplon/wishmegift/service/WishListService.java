package co.simplon.wishmegift.service;

import co.simplon.wishmegift.entity.WishListEntity;
import co.simplon.wishmegift.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;
    private WishListEntity wishListEntity;

    public WishListEntity saveWishList(WishListEntity wishListEntity) {

//        dans la requete post de creation de la wishlist il faudra lui fournir l'id de l'utilisateur
        WishListEntity wishListEntitysaved = wishListRepository.save(wishListEntity);
     

        return wishListEntitysaved;
    }
}
