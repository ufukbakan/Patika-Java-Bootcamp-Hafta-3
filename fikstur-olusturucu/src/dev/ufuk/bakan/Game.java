package dev.ufuk.bakan;

import java.util.Objects;

public class Game{ // oynanan bir oyunu temsil eder
    private String homeTeam; // ev sahibi takım
    private String awayTeam; // konuk takım

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    // aynı maçın oynandığını karşılaştırabilmek için hashcode ve equalsi
    // homeTeam ve awayTeam değişkenlerine göre oluştur :

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }
}
