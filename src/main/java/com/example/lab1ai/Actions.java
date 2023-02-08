package com.example.lab1ai;

import java.util.*;

public class Actions {

    public void expand(State st){
        moveUp(st);
        moveLeft(st);
        moveDown(st);
        moveRight(st);
    }

    public  void moveUp(State st){
        int indexZero = st.getBlankSpacePos();
        if (indexZero - 3 >= 0){
            char ch = st.getBoardState().charAt(indexZero - 3);
            StringBuilder sb = new StringBuilder(st.getBoardState());
            sb.setCharAt(indexZero, ch);
            sb.setCharAt(indexZero - 3, '0');
            String neighbourBoard = sb.toString();

            addNeighbour(neighbourBoard, st);

        }
    }

    public  void moveDown(State st){
        int indexZero = st.getBlankSpacePos();
        if (indexZero <= 5){
            char ch = st.getBoardState().charAt(indexZero + 3);
            StringBuilder sb = new StringBuilder(st.getBoardState());
            sb.setCharAt(indexZero, ch);
            sb.setCharAt(indexZero + 3, '0');
            String neighbourBoard = sb.toString();

            addNeighbour(neighbourBoard, st);


        }
    }
    public  void moveRight(State st){
        int indexZero = st.getBlankSpacePos();
        if (indexZero % 3 < 2){
            char ch = st.getBoardState().charAt(indexZero + 1);
            StringBuilder sb = new StringBuilder(st.getBoardState());
            sb.setCharAt(indexZero, ch);
            sb.setCharAt(indexZero + 1, '0');
            String neighbourBoard = sb.toString();


            addNeighbour(neighbourBoard, st);


        }
    }
    public void moveLeft(State st){
        int indexZero = st.getBlankSpacePos();
        if (indexZero % 3 > 0){
            char ch = st.getBoardState().charAt(indexZero - 1);
            StringBuilder sb = new StringBuilder(st.getBoardState());
            sb.setCharAt(indexZero, ch);
            sb.setCharAt(indexZero  - 1, '0');
            String neighbourBoard = sb.toString();

            addNeighbour(neighbourBoard, st);

        }
    }
    public void addNeighbour(String boardState, State st){

        State neighbour = new State();
        neighbour.setBoardState(boardState);
        neighbour.setG(st.getG() + 1);

        st.getNeighbors().add(neighbour);
        neighbour.parentState = st;
    }


    public static void printPath(State initialState, State goal){
        System.out.println("\t\t\tSuccess");
        State st = goal;
        Stack<State> path = new Stack<>();
        while (st != null){
            path.push(st);
            st = st.parentState;
        }
        System.out.println("\t\t\tPath");
        while (!path.isEmpty()){
            System.out.print(path.pop().getBoardState() + ", ");
        }
        System.out.println("\n\t\t\tCost" + "\n" + goal.getG());
    }

    public static Stack<State> getPath(State initialState, State goal){
        State st = goal;
        Stack<State> path = new Stack<>();
        while (st != null){
            path.push(st);
            st = st.parentState;
        }
        return path;
    }
    public static void printExpanded(Set<State> expanded){
        System.out.println("\t\t\tExpanded");
        int max = 0;
        for (State state : expanded) {
            if (state.getG() > max)
                max = state.getG();
            System.out.print(state.getBoardState() + ", ");
        }
        System.out.println("\n\t\t\tMax depth" + "\n" + max);
    }

}
