package co.simplon.wishmegift.controller;

import co.simplon.wishmegift.entity.GiftEntity;
import co.simplon.wishmegift.repository.GiftRepository;
import co.simplon.wishmegift.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RequestMapping("/gifts")
@RestController
public class GiftController {

    private final GiftRepository giftRepository;
    @Autowired
    private GiftService giftService;

    GiftController(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    @GetMapping("")
    public List<GiftEntity> getAllGifts() {
        if (giftRepository.findAll() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pas de cadeaux enregistrés");
        }
        return giftService.getAllGifts();
    }

    @PostMapping("")
    public ResponseEntity<GiftEntity> addOneGift(@RequestBody GiftEntity gift) {
        GiftEntity giftSaved = this.giftService.createGift(gift);
        return new ResponseEntity<>(giftSaved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{gift_id}")
    public void deleteGift(@PathVariable("gift_id") final UUID id) {
        if(giftRepository.existsById(id)) {
            giftRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Suppression impossible");
        }
    }
}
