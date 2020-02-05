package com.hussein.youxeltask.data.remote.response;

import com.hussein.youxeltask.data.model.Match;
import java.util.List;

public class MatchesResponse {


  private boolean success;
  private Data data;

  public boolean isSuccess() {
    return success;
  }

  public Data getData() {
    return data;
  }

  public class Data{


    private List<Match> match ;

    public List<Match> getMatch() {
      return match;
    }
  }
}
