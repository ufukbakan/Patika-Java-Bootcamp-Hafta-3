package dev.ufuk.bakan;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Simulation {
    public Set<String> teams; // Simülasyonda yer alan tüm takımlar
    private final Set<Game> allGames = new HashSet<>(); // Simülasyonda oynanacak tüm maçlar
    private static final Random RANDOMIZER = new Random(); // randomizer
    private int weekLimit; // hafta limiti takım sayısına göre belirlenecek
    private Set<Game> firstLegGames = new HashSet<>(); // Ligin llk yarısında oynanacak maçlar
    private Set<Game> secondLegGames = new HashSet<>(); // Ligin ikinci yarısında oynanacak maçlar

    public Simulation(Set<String> teams){
        this.teams = teams;
        if(teams.size() % 2 != 0)
            teams.add("Bay"); // takım sayısı çift değilse Bay eklenir
        weekLimit = (teams.size() - 1 ) * 2; // hafta limiti: (2'li kombinasyonlar)*2 / (teams size/2) ' sadeleştirilmiş hali (t-1*2):
        // weeklimit mümkün maç sayısının kaç haftada tamamlanacağını temsil eder
    }

    public void simulate(){
        calculateAllGames(); // mümkün bütün maçları hesapla
        distributeLegs(); // mümkün maçları iki devreye böl
        int week = 1; // birinci haftadan başlayarak
        while(week <= weekLimit/2){ // ligin ilk yarısındaki maçları simüle et
            System.out.printf("Week %d\n", week);
            printGames(simulateOneWeek(firstLegGames));
            week++;
        }
        while(week <= weekLimit){ // ligin ikinci (kalan) yarısındaki maçları simüle et
            System.out.printf("Week %d\n", week);
            printGames(simulateOneWeek(secondLegGames));
            week++;
        }
    }

    private void calculateAllGames(){
        for(String team: teams){ // her bir takım için
            Set<String> opponents = new HashSet<String>(){{ addAll(teams); }}; // rakipler seti oluştur
            opponents.remove(team); // kendisini rakip setinden çıkart
            for(String opponent: opponents){
                allGames.add(new Game(team, opponent)); // takım vs rakip şeklindeki her oyunu allGames setine ekle
            }
        }
    }

    private void distributeLegs(){
        Set<Game> remainingGames = new HashSet<Game>(){{addAll(allGames);}}; // kalan maçlar = remainingGames
        while(remainingGames.size() > 0){ // oynanmayan maç varken
            Game firstLeg = pickRandomGame(remainingGames); // kalan maçlardan rastgele birini seç örn: Game=A takımı vs B takımı
            // B takımı vs A takımı karşılaşmasının ligin ilk yarısında oynanmasını engellemek için bu maçı hafızaya al:
            Game secondLeg = new Game(firstLeg.getAwayTeam(), firstLeg.getHomeTeam());
            firstLegGames.add(firstLeg); // A vs B oyununu first leg games e ekle
            secondLegGames.add(secondLeg); // B vs A oyununu second leg games e ekle
            remainingGames.remove(firstLeg); // kalan maçlardan A vs B oyununu çıkart
            remainingGames.remove(secondLeg); // kalan maçlardan B vs A oyununu çıkart
        }
    }

    private void printGames(Set<Game> games){
        for(Game game: games){
            System.out.printf("%s - %s\n",game.getHomeTeam(), game.getAwayTeam());
        }
        System.out.println("================================");
    }

    private Set<Game> simulateOneWeek(Set<Game> gamesOfLeg){ // ligin hangi yarısının maçları oynanacaksa parametre olarak verilir
        Set<String> availableTeams = new HashSet<String>(){{addAll(teams);}}; // hafta başında tüm takımlar maç yapmaya uygun
        Set<Game> thisWeeksGames = new HashSet<>(); // bu hafta oynanan maçlar seti şimdilik boş
        boolean gamesAvailable = true; // bu hafta oynanabilir maç var
        while(gamesAvailable){
            // parametre olarak gelen maçlar içerisinden şu anda uygun olan takımların maçlarını filtrele
            // ilk önüne geleni nextAvailableGame olarak al
            Game nextAvailableGame = gamesOfLeg.stream().filter(game -> availableTeams.contains(game.getHomeTeam()) && availableTeams.contains(game.getAwayTeam())).findFirst().orElse(null);
            if(nextAvailableGame == null) // filtrelenen herhangi bir maç bulunamadıysa
                gamesAvailable = false; // döngüyü kır
            else{ // filtrelenen bir maç bulunduysa
                thisWeeksGames.add(nextAvailableGame); // bu hafta oynanan maçlara bulunan maçı ekle
                // bu maçı oynayan takımları bu hafta sıradaki döngü için artık uygun değil olarak işaretle :
                availableTeams.remove(nextAvailableGame.getHomeTeam());
                availableTeams.remove(nextAvailableGame.getAwayTeam());
            }
        }
        return thisWeeksGames;
    }

    private Game pickRandomGame(Set<Game> gameSet){
        int random = RANDOMIZER.nextInt(gameSet.size());
        // set içerisinde bir index varmış gibi random bir eleman seç:
        int fakeindex = 0;
        Game result = null;
        for(Game game: gameSet){
            if(fakeindex == random){
                result = game;
                break;
            }
            fakeindex++;
        }
        return result;
    }
}
