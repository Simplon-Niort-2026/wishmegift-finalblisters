package co.simplon.wishmegift.repository;

import co.simplon.wishmegift.entity.UserEntity;
import co.simplon.wishmegift.entity.WishListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WishListRepository extends JpaRepository<WishListEntity, UUID> {
}
