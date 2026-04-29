package co.simplon.wishmegift.controller;

import co.simplon.wishmegift.entity.WishListEntity;
import co.simplon.wishmegift.repository.WishListRepository;
import co.simplon.wishmegift.service.WishListService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/lists")
public class WishListController {
    private final WishListRepository wishListRepository;
    private final WishListService wishListService;

    public WishListController(WishListRepository wishListRepositoryInjected, WishListService wishListService) {
        this.wishListRepository = wishListRepositoryInjected;
        this.wishListService = wishListService;
    }

    //    POST /lists/user/{userId}
    @PostMapping("")
    public WishListEntity saveWishList( @RequestBody WishListEntity wishListEntity) {
        return wishListService.saveWishList(wishListEntity);
    }
//    GET /lists/{listId}/user/{userId}
//    GET /lists/user/{userId}
//    PUT /lists/{listId}/user/{userId}
//    DELETE /lists/{listId}/user/{userId}
}
