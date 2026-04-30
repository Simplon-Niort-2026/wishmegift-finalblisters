package co.simplon.wishmegift.controller;

import co.simplon.wishmegift.entity.GiftEntity;
import co.simplon.wishmegift.entity.Theme;
import co.simplon.wishmegift.entity.UserEntity;
import co.simplon.wishmegift.entity.WishListEntity;
import co.simplon.wishmegift.errorsHandler.WishListNotFoundException;
import co.simplon.wishmegift.repository.WishListRepository;
import co.simplon.wishmegift.service.WishListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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
    public WishListEntity saveWishList(@RequestBody WishListEntity wishListEntity) {
        return wishListService.saveWishList(wishListEntity);
    }

    //    GET /lists/{listId}/user/{userId}
//    GET /lists/user/{userId}
//    PUT /lists/{listId}/user/{userId}
    @PutMapping("{listId}")
    public WishListEntity updateWishList(@PathVariable UUID listId, @RequestBody WishListEntity wishListEntity) {

        Optional<WishListEntity> w = wishListService.getWishList(listId);
        if (w.isEmpty()) {
            String errorMessage = String.format("WishList with id %s not found", listId);
            throw new WishListNotFoundException(errorMessage);
        }

        WishListEntity currentWishList = w.get();

        String name = wishListEntity.getName();
        if (name != null) {
            currentWishList.setName(name);
        }

        Theme theme = wishListEntity.getTheme();
        if (theme != null) {
            currentWishList.setTheme(theme);
        }

        String description = wishListEntity.getDescription();
        if (description != null) {
            currentWishList.setDescription(description);
        }

        LocalDate eventDate = wishListEntity.getEventDate();
        if (eventDate != null) {
            currentWishList.setEventDate(eventDate);
        }

        Boolean active = wishListEntity.isActive();
        if (active != currentWishList.isActive()) {
            currentWishList.toggleActive();
        }

        List<GiftEntity> gifts = wishListEntity.getGifts();
        if (gifts != null) {
            currentWishList.setGifts(gifts);
        }
//            users
        List<UserEntity> users = wishListEntity.getUsers();
        if (users != null) {
            currentWishList.setUsers(users);
        }
        return wishListService.saveWishList(currentWishList);

//    DELETE /lists/{listId}/user/{userId}
    }
}
