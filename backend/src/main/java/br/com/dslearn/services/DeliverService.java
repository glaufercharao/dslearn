package br.com.dslearn.services;

import br.com.dslearn.dto.DeliverRevisionDTO;
import br.com.dslearn.entities.Deliver;
import br.com.dslearn.repositories.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeliverService {

    @Autowired
    private DeliverRepository deliverRepository;

    @Transactional
    public void saveRevision(Long id, DeliverRevisionDTO revisionDTO){
        Deliver deliver = deliverRepository.getOne(id);
        deliver.setStatus(revisionDTO.getStatus());
        deliver.setFeedback(revisionDTO.getFeedback());
        deliver.setCorrectCount(revisionDTO.getCorrectCount());

        deliverRepository.save(deliver);
    }

}
