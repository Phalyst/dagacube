package rank.interactive.dagacube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rank.interactive.dagacube.model.PlayerDetails;
import rank.interactive.dagacube.model.Transaction;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{

    List<Transaction> findLast10ByPlayerDetailsAndWinningAmountIsNotNull(PlayerDetails playerDetails);

    List<Transaction> findLast10ByPlayerDetailsAndWinningAmountIsNotNullAndWagerAmountIsNotNull(PlayerDetails playerDetails);

    List<Transaction> findLast10ByPlayerDetails(PlayerDetails playerDetails);
}
