package rank.interactive.dagacube.dto;

public class DagacubeRequest {

    private long transactionId;
    private long playerId;
    private double wagerAmount;
    private double winAmount;

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public double getWagerAmount() {
        return wagerAmount;
    }

    public void setWagerAmount(double wagerAmount) {
        this.wagerAmount = wagerAmount;
    }

    public double getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(double winAmount) {
        this.winAmount = winAmount;
    }
}
