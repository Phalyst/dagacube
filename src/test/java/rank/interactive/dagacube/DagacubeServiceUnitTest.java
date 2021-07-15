package rank.interactive.dagacube;



import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import rank.interactive.dagacube.dto.DagacubeRequest;
import rank.interactive.dagacube.dto.DagacubeResponse;
import rank.interactive.dagacube.repository.PlayerDetailsRepository;
import rank.interactive.dagacube.service.DagacubeService;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DagacubeApplication.class)
public class DagacubeServiceUnitTest {


    @Autowired
    private DagacubeService dagacubeService;

    @Autowired
    private PlayerDetailsRepository playerDetailsRepository;

    @Test
    public void test_get_player_balance(){
        DagacubeRequest dagacubeRequest = new DagacubeRequest();
        dagacubeRequest.setWagerAmount(500);
        double balance = 500.0;
        DagacubeResponse response = new DagacubeResponse();
        response.setAvailableBalance(500);
        Mockito.when(dagacubeService.getPlayerBalance(1)).thenReturn(response);
        Assertions.assertEquals(response.getAvailableBalance(),balance);

    }

    @Test
    public void when_player_win_amount_is_provided_then_get_player_balance() {
        DagacubeRequest dagacubeRequest = new DagacubeRequest();
        dagacubeRequest.setWagerAmount(500);

        DagacubeResponse response = new DagacubeResponse();
        response.setAvailableBalance(1500);
        Mockito.when(dagacubeService.deposit(dagacubeRequest)).thenReturn(response);
        Assertions.assertEquals(1500,dagacubeService.deposit(dagacubeRequest).getAvailableBalance());
    }

    @Test
    public void when_player_wager_amount_is_provided_then_get_player_balance() {
        DagacubeRequest dagacubeRequest = new DagacubeRequest();
        dagacubeRequest.setWagerAmount(500);

        DagacubeResponse response = new DagacubeResponse();
        response.setAvailableBalance(500);
        Mockito.when(dagacubeService.withdraw(dagacubeRequest)).thenReturn(response);
        Assertions.assertEquals(500,dagacubeService.withdraw(dagacubeRequest).getAvailableBalance());
    }
}