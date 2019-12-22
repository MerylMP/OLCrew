package com.devmini.olcrew.modelData;

import java.util.List;

public class APIMainResponse {

    private int current;
    private int total;
    private List<OompaLoompa> results;

    public APIMainResponse() {

    }

    public APIMainResponse(int current, int total, List<OompaLoompa> results) {
        this.current = current;
        this.total = total;
        this.results = results;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<OompaLoompa> getResults() {
        return results;
    }

    public void setResults(List<OompaLoompa> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "APIMainResponse{" +
                "current=" + current +
                ", total=" + total +
                ", results=" + results +
                '}';
    }
}
