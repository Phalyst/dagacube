//package rank.interactive.dagacube;
//
//
//import org.aspectj.lang.annotation.Before;
//import org.junit.Ignore;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import rank.interactive.dagacube.dto.DagacubeRequest;
//import rank.interactive.dagacube.dto.DagacubeResponse;
//import rank.interactive.dagacube.model.PlayerDetails;
//import rank.interactive.dagacube.model.Transaction;
//import rank.interactive.dagacube.repository.PlayerDetailsRepository;
//import rank.interactive.dagacube.service.DagacubeService;
//import sun.jvm.hotspot.utilities.Assert;
//
//import java.util.Set;
//
////@SpringBootTest
////@RunWith(SpringRunner.class)
////@Ignore
//public class DagacubeServiceTest {
//
//    @Autowired
//    private DagacubeService dagacubeService;
//
//    @Autowired
//    private PlayerDetailsRepository playerDetailsRepository;
//
//    //@BeforeEach
//    public  void setUp(){
//        PlayerDetails playerDetails = new PlayerDetails();
//        playerDetails.setId((long) 2);
//        playerDetails.setBalance(1500);
//        playerDetails.setPlayerName("test");
//        Transaction trans = new Transaction();
//        trans.setId((long) 1);
//        trans.setPlayerDetails(playerDetails);
//        trans.setWagerAmount((double) 1500);
//        trans.setWinningAmount(2000);
//        //playerDetails.setTransaction((Set<Transaction>) trans);
//
//        playerDetailsRepository.save(playerDetails);
//
//
//
//    }
//
//    @Ignore @Test
//    public void test_get_player_balance(){
//        DagacubeResponse playerBalance = dagacubeService.getPlayerBalance(2);
//        double balance = 1500.0;
//        Assertions.assertEquals(playerBalance.getAvailableBalance(),balance);
//
//    }
//
//    @Ignore @Test
//    public void test_wager(){
//        DagacubeRequest dagacubeRequest = new DagacubeRequest();
//        dagacubeRequest.setPlayerId(2);
//        dagacubeRequest.setTransactionId(1);
//        dagacubeRequest.setWagerAmount(500);
//        Assertions.assertEquals(1500,dagacubeService.deposit(dagacubeRequest).getAvailableBalance());
//    }
//
//    @Ignore @Test
//    public void test_winning(){
//        DagacubeRequest dagacubeRequest = new DagacubeRequest();
//        dagacubeRequest.setPlayerId(2);
//        dagacubeRequest.setTransactionId(1);
//        dagacubeRequest.setWagerAmount(500);
//        Assertions.assertEquals(1000,dagacubeService.withdraw(dagacubeRequest).getAvailableBalance());
//    }
//
//}
