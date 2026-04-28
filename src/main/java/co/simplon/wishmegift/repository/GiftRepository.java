package co.simplon.wishmegift.repository;

import co.simplon.wishmegift.entity.GiftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<GiftEntity, Long> {
}
