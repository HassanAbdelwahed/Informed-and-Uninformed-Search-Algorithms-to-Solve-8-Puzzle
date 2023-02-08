package com.example.lab1ai;

import java.util.*;

public class AStarManhattan extends ActionsAStar{
    public Stack<State> finalPath = new Stack<>();
    public boolean aStarManhattan(String initialState){
        this.manh = true;
        PriorityQueue<State> frontiers = new PriorityQueue<>(new StateComparatorForMan());
        Set<State> explored = new HashSet<>();


        State INState = new State();
        INState.setBoardState(initialState);

        INState.setG(0);
        Heuristics.manhattanDistance(INState);

        frontiers.add(INState);

        while (!frontiers.isEmpty()){

            State state = frontiers.poll();
            if (inExplored(explored, state))
            {
                continue;
            }
            explored.add(state);

            if (state.isGoal()){
                printPath(INState, state);
                finalPath=getPath(INState, state);
                printExpanded(explored);
                return true;
            }
            expand(state);
            ArrayList<State> neighbors = state.getNeighbors();

            for (State neighbor : neighbors){

                if (!(inFrontiers(frontiers, neighbor)) && !(inExplored(explored, neighbor))){
                    frontiers.add(neighbor);
                } else if (inFrontiers(frontiers, neighbor)) {
                      frontiers.add(neighbor);
//                    int cost = neighbor.getCostManh();
//                    System.out.println("secondIF");
//                    System.out.println(neighbor.getBoardState());
//
//                    System.out.println(cost);
//                    System.out.println(1 + " " + map.get(neighbor.getBoardState()));
//                    if (map.get(neighbor.getBoardState()) > cost){
//                        frontiers.add(neighbor);
//                        map.replace(neighbor.getBoardState(), cost);
//
//                    }
                }
            }

        }
        return false;

    }
    public static boolean inFrontiers(PriorityQueue<State> frontiers, State st){
        return frontiers.stream().map(State::getBoardState).anyMatch(st.getBoardState()::equals);
    }
    //check if state is explored (visited)
    public static boolean inExplored(Set<State> explored, State st){
        return explored.stream().map(State::getBoardState).anyMatch(st.getBoardState()::equals);
    }
}
