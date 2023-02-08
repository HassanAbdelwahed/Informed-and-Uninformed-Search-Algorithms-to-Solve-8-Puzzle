package com.example.lab1ai;

public class CheckSolvable {
    public static boolean isSolvable(String initialState) {

        int inv_count = 0;
        int x, y;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                x = Integer.parseInt(String.valueOf(initialState.charAt(i)));
                y = Integer.parseInt(String.valueOf(initialState.charAt(j)));
                // Value 0 is used for empty space
                if (x > 0 && y > 0 && x > y)
                    inv_count++;
            }
        }
        return inv_count % 2 == 0;

    }
}
