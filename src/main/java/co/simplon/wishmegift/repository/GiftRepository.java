package co.simplon.wishmegift.repository;

import co.simplon.wishmegift.entity.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GiftRepository extends JpaRepository<GiftEntity, UUID> {


}
