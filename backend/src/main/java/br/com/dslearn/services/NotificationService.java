package br.com.dslearn.services;

import br.com.dslearn.dto.NotificationDTO;
import br.com.dslearn.entities.Notification;
import br.com.dslearn.entities.User;
import br.com.dslearn.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public Page<NotificationDTO> getNotificationForCurrentUser(Pageable pageable){
        User user = authService.authenticated();
        Page<Notification> page = notificationRepository.findByUser(user, pageable);
        return page.map(x -> new NotificationDTO(x));
    }
}
