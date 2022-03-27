package dev.ufuk.bakan;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<String> teamsOdd = new HashSet<String>(){{
            add("Beşiktaş");
            add("Galatasaray");
            add("Fenerbahçe");
            add("Trabzonspor");
            add("Konyaspor");
            add("Başakşehir");
            add("Adana Demirspor");
        }};
        Set<String> teamsEven = new HashSet<String>(){{
            add("Beşiktaş");
            add("Galatasaray");
            add("Fenerbahçe");
            add("Trabzonspor");
            add("Konyaspor");
            add("Başakşehir");
        }};
        System.out.println("Fixture with odd number of teams:");
        Simulation sim = new Simulation(teamsOdd);
        sim.simulate();

        System.out.println("Fixture with even number of teams:");
        Simulation sim2 = new Simulation(teamsEven);
        sim.simulate();
    }
}
