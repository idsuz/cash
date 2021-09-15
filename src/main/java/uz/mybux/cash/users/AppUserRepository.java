package uz.mybux.cash.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUserName(final String username);
}
