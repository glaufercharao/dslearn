package br.com.dslearn.resources;

import br.com.dslearn.dto.NotificationDTO;
import br.com.dslearn.dto.UserDTO;
import br.com.dslearn.services.NotificationService;
import br.com.dslearn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/notifications")
public class NotificationResource {

    @Autowired
    private NotificationService service;

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> getNotificationForCurrentUser(Pageable pageable){
        return ResponseEntity.ok().body(service.getNotificationForCurrentUser(pageable));
    }
}
