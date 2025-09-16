package com.ityj.entity;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private volatile List<String> candidates = new ArrayList<>();
    private int votes;


public List<String> getCandidates () {
    return this.candidates;
}


public synchronized void addCandidate (String candidate) {
    if (candidates == null) {
      candidates = new  ArrayList<>();
    }
candidates.add(candidate);
}


public int getVotes () {
    return this.votes;
}


public void setVotes (int votes) {
  this.votes = votes;

}


    @Override
    public String toString() {
        return "Result{" +
                "candidates=" + candidates +
                ", votes=" + votes +
                '}';
    }
}
