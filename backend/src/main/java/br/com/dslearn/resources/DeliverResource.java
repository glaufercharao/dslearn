package br.com.dslearn.resources;

import br.com.dslearn.dto.DeliverRevisionDTO;
import br.com.dslearn.services.DeliverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliverResource {

    @Autowired
    private DeliverService service;

    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id,
                                                                   @RequestBody DeliverRevisionDTO deliverRevisionDTO){
        service.saveRevision(id, deliverRevisionDTO);
        return ResponseEntity.noContent().build();
    }
}
