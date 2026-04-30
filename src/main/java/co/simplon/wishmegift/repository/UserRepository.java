package co.simplon.wishmegift.repository;

import co.simplon.wishmegift.entity.UserEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<@NonNull UserEntity,@NonNull UUID> {

    UserEntity findByEmail(String email);
}
