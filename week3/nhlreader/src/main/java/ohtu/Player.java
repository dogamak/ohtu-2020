
package ohtu;

public class Player {
  private String name;
  private String nationality;
  private String team;
  private int assists;
  private int games;
  private int goals;
  private int penalties;

  public void setName(String name) {
      this.name = name;
  }

  public String getName() {
      return name;
  }

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}

  @Override
  public String toString() {
      return name;
  }
}
