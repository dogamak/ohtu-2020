package ohtuesimerkki;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StatisticsTest {
    ArrayList<Player> players;
    Statistics statistics;

    @Before
    public void setupStatistics() {
        players = new ArrayList<Player>();
        players.add(new Player("Claude Giroux",    "PHI", 10, 12));
        players.add(new Player("Connor Bunnaman",  "PHI",  0,  0));
        players.add(new Player("Connor McDavid",   "EDM", 20, 37));
        players.add(new Player("Jakub Voracek",    "PHI",  6, 16));
        players.add(new Player("Leon Draisaitl",   "EDM", 20, 35));
        players.add(new Player("Nathan MacKinnon", "COL", 20, 30));
        StubReader reader = new StubReader(players);
        statistics = new Statistics(reader);
    }

    @Test
    public void searchReturnsPlayerWhoseNamesContainTheQuery() {
        Player match = statistics.search("Mc");
        assertTrue(match.getName().contains("Mc"));
    }

    @Test
    public void searchReturnsNullIfNoMatches() {
        Player match = statistics.search("XYZ");
        assertNull(match);
    }

    @Test
    public void teamMethodReturnsOnlyPlayersInTheTeam() {
        List<Player> players = statistics.team("PHI");

        for (Player member : players) {
            assertEquals(member.getTeam(), "PHI");
        }
    }

    @Test
    public void allOtherPlayers() {
        List<Player> top = statistics.topScorers(3);
        assertEquals(4, top.size());

        Integer lowestTop = null;

        for (Player topPlayer : top) {
            if (lowestTop == null || lowestTop < topPlayer.getPoints()) {
                lowestTop = topPlayer.getPoints();
            }
        }

        for (Player player : players) {
            if (!top.contains(player)) {
                assertTrue(player.getPoints() <= lowestTop);
            }
        }
    }
}
