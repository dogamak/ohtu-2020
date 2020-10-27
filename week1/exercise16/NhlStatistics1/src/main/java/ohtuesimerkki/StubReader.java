package ohtuesimerkki;

import java.util.List;

public class StubReader implements Reader {
    private List<Player> players;

    StubReader(List<Player> pPlayers) {
        players = pPlayers;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
