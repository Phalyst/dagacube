package rank.interactive.dagacube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rank.interactive.dagacube.model.PlayerDetails;

import java.util.Optional;


@Repository
public interface PlayerDetailsRepository extends JpaRepository<PlayerDetails, Long>{
   Optional<PlayerDetails> findByPlayerName(String playerName);

}
