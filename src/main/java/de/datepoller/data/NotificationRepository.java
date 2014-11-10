package de.datepoller.data;

import de.datepoller.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dsy on 10.11.14.
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Notification findNotificationById(Long id);
}
