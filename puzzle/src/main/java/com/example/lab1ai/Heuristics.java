package com.example.lab1ai;

import java.util.HashMap;
import java.util.Map;

public class Heuristics {

    public static void manhattanDistance(State st){
        String str = st.getBoardState();
        int manh = 0;

        for (int i = 0; i < str.length(); i++){

            char tile = str.charAt(i);
            if (tile == '0')
                continue;
            String coord = coordinate(i);
            int x, y;
            x = Integer.parseInt(String.valueOf(coord.charAt(0)));
            y = Integer.parseInt(String.valueOf(coord.charAt(1)));

            int x_goal, y_goal;
            coord = coordinate(Integer.parseInt(String.valueOf(str.charAt(i))));
            x_goal = Integer.parseInt(String.valueOf(coord.charAt(0)));
            y_goal = Integer.parseInt(String.valueOf(coord.charAt(1)));

            manh += Math.abs(x - x_goal) + Math.abs(y - y_goal);
            st.setManh(manh);
        }
    }
    public static void euclideanDistance(State st){
        String str = st.getBoardState();
        double h = 0;

        for (int i = 0; i < str.length(); i++){
            char tile = str.charAt(i);
            if (tile == '0')
                continue;
            String coord = coordinate(i);
            int x, y;
            x = Integer.parseInt(String.valueOf(coord.charAt(0)));
            y = Integer.parseInt(String.valueOf(coord.charAt(1)));

            int x_goal, y_goal;
            coord = coordinate(Integer.parseInt(String.valueOf(str.charAt(i))));
            x_goal = Integer.parseInt(String.valueOf(coord.charAt(0)));
            y_goal = Integer.parseInt(String.valueOf(coord.charAt(1)));

            h += Math.sqrt(Math.pow((x - x_goal), 2) + Math.pow((y - y_goal), 2));
            st.setEuclideanDistance(h);
        }
    }

    public static String coordinate(int i){
        String x, y;
        y = String.valueOf(i % 3);
        if (i <= 2)
            x = "0";
        else if (i <= 5)
            x = "1";
        else
            x = "2";

        return x + y;
    }
}
