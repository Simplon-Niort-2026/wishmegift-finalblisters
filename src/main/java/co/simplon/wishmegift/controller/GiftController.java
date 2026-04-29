package co.simplon.wishmegift.controller;

import co.simplon.wishmegift.entity.GiftEntity;
import co.simplon.wishmegift.repository.GiftRepository;
import co.simplon.wishmegift.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/gifts")
@RestController
public class GiftController {

    private final GiftRepository giftRepository;
    @Autowired
    private GiftService giftService;

    GiftController(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    @GetMapping("/allgifts")
    public List<GiftEntity> getAllGifts() {
       if (giftRepository.findAll() == null) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Exterminé !");
       }
        return giftService.getAllGifts();
    }

    @PostMapping("")
    public ResponseEntity<GiftEntity> addOneGift(@RequestBody GiftEntity gift) {
        GiftEntity giftSaved = this.giftService.createGift(gift);
        return new ResponseEntity<>(giftSaved, HttpStatus.CREATED);
    }
}
