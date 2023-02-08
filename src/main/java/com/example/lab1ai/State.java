package com.example.lab1ai;

import java.util.*;

public class State {
    private String boardState;
    private ArrayList<State> neighbors = new ArrayList<>();
    //index of blank space
    private int blankSpacePos;

    private int manh;
    private double euclideanDistance;


    //cost = number of steps to reach this state
    private int g;
    State parentState;



    public void setBoardState(String boardState) {
        this.boardState = boardState;
        setBlankSpacePos();
    }

    public String getBoardState() {
        return boardState;
    }

    public ArrayList<State> getNeighbors() {
        return neighbors;
    }

    public int getBlankSpacePos() {
        return blankSpacePos;
    }

    public void setBlankSpacePos() {
        this.blankSpacePos = this.boardState.indexOf("0");
    }

    public int getManh() {
        return manh;
    }

    public void setManh(int manh) {
        this.manh = manh;
    }

    public double getEuclideanDistance() {
        return euclideanDistance;
    }

    public void setEuclideanDistance(double euclideanDistance) {
        this.euclideanDistance = euclideanDistance;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getCostManh(){
        return this.g + this.manh;
    }

    public double getCostEuclidean(){
        return this.g + this.euclideanDistance;
    }

    public boolean isGoal(){
        return this.boardState.equals("012345678");
    }
}
