package rank.interactive.dagacube.model;


import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable=false, nullable=false)
    private Long id;

    @Column(name = "wager_amount", nullable = true)
    private Double wagerAmount;

    @Column(name = "winning_amount", nullable = true)
    private Double winningAmount;

    @ManyToOne
    @JoinColumn(name="player_id", nullable=false)
    private PlayerDetails playerDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWagerAmount() {
        return wagerAmount;
    }

    public void setWagerAmount(Double wagerAmount) {
        this.wagerAmount = wagerAmount;
    }

    public Double getWinningAmount() {
        return winningAmount;
    }

    public void setWinningAmount(double winningAmount) {
        this.winningAmount = winningAmount;
    }

    public PlayerDetails getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(PlayerDetails playerDetails) {
        this.playerDetails = playerDetails;
    }
}
