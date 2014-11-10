package de.datepoller.data;

import de.datepoller.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dsy on 02.11.14.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
