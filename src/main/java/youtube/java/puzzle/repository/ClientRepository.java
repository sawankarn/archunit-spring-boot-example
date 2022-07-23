package youtube.java.puzzle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import youtube.java.puzzle.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
