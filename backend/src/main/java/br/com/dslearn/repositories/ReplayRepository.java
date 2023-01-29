package br.com.dslearn.repositories;

import br.com.dslearn.entities.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplayRepository extends JpaRepository<Reply, Long> {
}
