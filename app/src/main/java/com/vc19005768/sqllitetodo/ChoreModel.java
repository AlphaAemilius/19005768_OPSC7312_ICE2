package com.vc19005768.sqllitetodo;

public class ChoreModel {
    private int cID;
    private String Chore;
    private String Time;

    public ChoreModel(int cID, String chore, String time) {
        this.cID = cID;
        Chore = chore;
        Time = time;
    }

    public ChoreModel() {
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getChore() {
        return Chore;
    }

    public void setChore(String chore) {
        Chore = chore;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
