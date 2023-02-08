package com.example.lab1ai;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            String initialState = input.next().replace(",", "");
            if (!CheckSolvable.isSolvable(initialState)){
                System.out.println("Failure");
                return;
            }
            long start = System.currentTimeMillis();
            System.out.println("\t\t\tA* search(Manh):");
            AStarManhattan s = new AStarManhattan();
            s.aStarManhattan(initialState);
            long end = System.currentTimeMillis();
            long execution = end - start;
            System.out.println("Execution time: " + execution + " milliseconds");
            System.out.println("*******************************************************************************");

            start = System.currentTimeMillis();
            System.out.println("\t\t\tA* search(Eucli)");
            AStarEuclidean ec = new AStarEuclidean();
            ec.AStarEuclidean(initialState);
            end = System.currentTimeMillis();
            execution = end - start;
            System.out.println("Execution time: " + execution + " milliseconds");
            System.out.println("******************************************************************************");

            start = System.currentTimeMillis();
            System.out.println("\t\t\tBFS search");
            BFS st = new BFS();
            st.bfs(initialState);
            end = System.currentTimeMillis();
            execution = end - start;
            System.out.println("Execution time: " + execution + " milliseconds");
            System.out.println("******************************************************************************");

            start = System.currentTimeMillis();
            System.out.println("\t\t\tDFS search");
            DFS df = new DFS();
            df.dfs(initialState);
            end = System.currentTimeMillis();
            execution = end - start;
            System.out.println("Execution time: " + execution  + " milliseconds");
            System.out.println("******************************************************************************");

        }catch (Exception e){
            System.out.println(e.getMessage());

        }


    }
}
