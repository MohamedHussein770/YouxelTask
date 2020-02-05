package com.hussein.youxeltask.data.model;

public class Match {

  private int id;
  private String league_name;
  private String home_name;
  private String away_name;
  private String scheduled;
  private String score;
  private String status;

  public String getStatus() {
    return status;
  }

  public int getId() {
    return id;
  }

  public String getLeague_name() {
    return league_name;
  }

  public String getHome_name() {
    return home_name;
  }

  public String getAway_name() {
    return away_name;
  }

  public String getScheduled() {
    return scheduled;
  }

  public String getScore() {
    return score;
  }
}
