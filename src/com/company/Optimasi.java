package com.company;

import java.util.ArrayList;

public class Optimasi {
    ArrayList<Integer> result = new ArrayList<>();
    int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Optimasi(ArrayList<Integer> result) {
        this.result = result;
        total=0;
    }

    public ArrayList<Integer> getResult() {
        return result;
    }

    public void setResult(ArrayList<Integer> result) {
        this.result = result;
    }
}
