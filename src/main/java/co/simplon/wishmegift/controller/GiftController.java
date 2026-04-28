package co.simplon.wishmegift.controller;

import co.simplon.wishmegift.entity.GiftEntity;
import co.simplon.wishmegift.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GiftController {

    @Autowired
    private GiftService giftService;

    @PostMapping("/gifts/list/{list_id}/users/{users_id}")
    public ResponseEntity<GiftEntity> addOneGift(@RequestBody GiftEntity gift) {
        GiftEntity giftSaved = this.giftService.addGift(gift);
        return new ResponseEntity<>(giftSaved, HttpStatus.CREATED);
    }
}
