package rank.interactive.dagacube.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import rank.interactive.dagacube.dto.DagacubeRequest;
import rank.interactive.dagacube.dto.DagacubeResponse;
import rank.interactive.dagacube.dto.TransactionReportRequest;
import rank.interactive.dagacube.dto.TransactionReportResponse;
import rank.interactive.dagacube.exceptionhandling.CustomException;
import rank.interactive.dagacube.model.PlayerDetails;
import rank.interactive.dagacube.model.Transaction;
import rank.interactive.dagacube.repository.PlayerDetailsRepository;
import rank.interactive.dagacube.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DagacubeServiceImpl implements DagacubeService{

    @Value("${top.secret.password}")
    private String password;

    private final PlayerDetailsRepository playerDetailsRepository;
    private final TransactionRepository transactionRepository;

    public DagacubeServiceImpl(PlayerDetailsRepository playerDetailsRepository, TransactionRepository transactionRepository) {
        this.playerDetailsRepository = playerDetailsRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public DagacubeResponse getPlayerBalance(long id){
        DagacubeResponse balanceResponse = new DagacubeResponse();
        PlayerDetails playerDetails = getPlayerDetails(id);
        balanceResponse.setPlayerName(playerDetails.getPlayerName());
        balanceResponse.setAvailableBalance(playerDetails.getBalance());
        return balanceResponse;
    }

    @Override
    public DagacubeResponse withdraw(DagacubeRequest request) {
        DagacubeResponse balanceResponse = new DagacubeResponse();
        PlayerDetails playerDetails = getPlayerDetails(request.getPlayerId());
        if(playerDetails.getBalance() < request.getWagerAmount()){
            throw new CustomException("Insufficient funds for player with id : " + request.getPlayerId());
        }
        playerDetails.setBalance(playerDetails.getBalance() - request.getWagerAmount());
        playerDetailsRepository.save(playerDetails);
        balanceResponse.setPlayerName(playerDetails.getPlayerName());
        balanceResponse.setAvailableBalance(playerDetails.getBalance());
        return balanceResponse;
    }

    @Override
    public DagacubeResponse deposit(DagacubeRequest request) {
        DagacubeResponse balanceResponse = new DagacubeResponse();
        PlayerDetails playerDetails = getPlayerDetails(request.getPlayerId());
        playerDetails.setBalance(playerDetails.getBalance() + request.getWinAmount());
        playerDetailsRepository.save(playerDetails);
        balanceResponse.setPlayerName(playerDetails.getPlayerName());
        balanceResponse.setAvailableBalance(playerDetails.getBalance());
        return balanceResponse;
    }

    @Override
    public List<TransactionReportResponse> winTransactions(TransactionReportRequest request) {

        List<TransactionReportResponse> responseList = new ArrayList<>();
        if(request.getPassword().equalsIgnoreCase(password)){
            PlayerDetails playerDetails = playerDetailsRepository.findByPlayerName(request.getPlayerName())
                    .orElseThrow(() -> {
                        return new IllegalArgumentException("No player found with name : " + request.getPlayerName());
                    });
            List<Transaction> transactionList = transactionRepository.findLast10ByPlayerDetails(playerDetails);
            for (Transaction trans : transactionList) {
                TransactionReportResponse response = new TransactionReportResponse();
                response.setPlayerId(playerDetails.getId());
                response.setTransactionId(trans.getId());
                if(trans.getWinningAmount() != null){
                    response.setWinningAmount(trans.getWinningAmount());
                }

                if(trans.getWagerAmount() != null){
                    response.setWagerAmount(trans.getWagerAmount());
                }
                responseList.add(response);
            }

        }else{
            throw new IllegalArgumentException("Invalid password : ");
        }

        return responseList;
    }

    private PlayerDetails getPlayerDetails(long id) {
        return playerDetailsRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("No player found with id : " + id);
                });
    }
}
