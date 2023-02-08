package com.example.lab1ai;

public class ActionsAStar extends Actions {

    boolean manh;
    @Override
    public void addNeighbour(String boardState, State st){

        State neighbour = new State();
        neighbour.setBoardState(boardState);
        neighbour.setG(st.getG() + 1);
        if (manh){
            Heuristics.manhattanDistance(neighbour);
        }else {
            Heuristics.euclideanDistance(neighbour);
        }
        st.getNeighbors().add(neighbour);
        neighbour.parentState = st;
    }
}
