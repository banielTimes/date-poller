package de.datepoller.services;

import de.datepoller.data.NotificationRepository;
import de.datepoller.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dsy on 10.11.14.
 */

@Service
@Transactional
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification findNotificationById(long id) {
        return notificationRepository.findNotificationById(id);
    }

    public List<Notification> findAllNotifications() {
        return notificationRepository.findAll();
    }

    public void update(Notification notification) {
        notificationRepository.save(notification);
    }

    public void save(Notification notification) {
        notificationRepository.save(notification);
    }

    public void delete(Notification notification) {
        notificationRepository.delete(notification);
    }
}
