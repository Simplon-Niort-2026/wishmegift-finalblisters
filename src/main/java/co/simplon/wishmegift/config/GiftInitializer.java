package co.simplon.wishmegift.config;

import co.simplon.wishmegift.entity.GiftEntity;
import co.simplon.wishmegift.repository.GiftRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GiftInitializer implements CommandLineRunner {

    private final GiftRepository giftRepository;

    public GiftInitializer(GiftRepository giftRepositoryInjected) {
        this.giftRepository = giftRepositoryInjected;
    }

    @Override
    public void run(String... args) throws Exception {
        GiftEntity gift1 = new GiftEntity("Mon beau cadeau", "http://www.mon-lien.fr", 9.99F, 1);
        GiftEntity giftCreated = this.giftRepository.save(gift1);
    }

}
