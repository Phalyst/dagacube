package rank.interactive.dagacube.service;

import org.springframework.stereotype.Component;
import rank.interactive.dagacube.dto.DagacubeRequest;
import rank.interactive.dagacube.dto.DagacubeResponse;
import rank.interactive.dagacube.dto.TransactionReportRequest;
import rank.interactive.dagacube.dto.TransactionReportResponse;

import java.util.List;

@Component
public interface DagacubeService {
    DagacubeResponse getPlayerBalance(long id);
    DagacubeResponse withdraw(DagacubeRequest request);
    DagacubeResponse deposit(DagacubeRequest request);

    List<TransactionReportResponse> winTransactions(TransactionReportRequest request);
}
