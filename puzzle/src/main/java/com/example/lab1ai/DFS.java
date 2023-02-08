package com.example.lab1ai;

import java.util.*;


public class DFS extends Actions{
    public Stack<State> finalPath = new Stack<>();
    public  boolean dfs(String initialState){

        Stack<State> frontiers = new Stack<>();
        Set<State> explored = new HashSet<>();

        State INState = new State();
        INState.setBoardState(initialState);
        frontiers.push(INState);
        while (!frontiers.isEmpty()){
            State state = frontiers.pop();
            explored.add(state);

            if (state.isGoal()){
                printPath(INState, state);
                finalPath=getPath(INState, state);
                printExpanded(explored);
                return true;
            }
            expand(state);
            ArrayList<State> neighbors = state.getNeighbors();
            for (State neighbor : neighbors) {
                if (!(inFrontiers(frontiers, neighbor)) && !(inExplored(explored, neighbor))) {
                    frontiers.push(neighbor);
                }
            }
        }
        System.out.println("Failure");
        return false;

    }

    public static boolean inFrontiers(Stack<State> frontiers, State st){
        return frontiers.stream().map(State::getBoardState).anyMatch(st.getBoardState()::equals);
    }
    //check if state is explored (visited)
    public static boolean inExplored(Set<State> explored, State st){
        return explored.stream().map(State::getBoardState).anyMatch(st.getBoardState()::equals);
    }


}

