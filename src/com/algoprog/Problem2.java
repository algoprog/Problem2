package com.algoprog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem2 {

    private int n;

    private HashMap<Integer, Integer> covered_by; // stores the number of pizzerias that cover each block

    private ArrayList<Pizzeria> pizzerias;

    private int max_covered = 0; // the number of pizzerias that deliver to the block with the greatest coverage

    public Problem2() {
        covered_by = new HashMap<>();
        pizzerias = new ArrayList<>();
    }

    public void add_pizzeria(Pizzeria p) {
        pizzerias.add(p);
    }

    public void set_size(int n) {
        this.n = n;
    }

    static class Pizzeria {
        private int x;
        private int y;
        private int k;

        public Pizzeria(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getK() {
            return k;
        }
    }

    private void read_input(String input_file) {
        if (input_file.equals("")) return;

        try (BufferedReader br = new BufferedReader(new FileReader(input_file))) {
            // read the size of the city

            String line = br.readLine();
            String[] num = line.split(" ");

            n = Integer.parseInt(num[0]);

            // read the pizzerias

            while ((line = br.readLine()) != null) {
                num = line.split(" ");

                Pizzeria p = new Pizzeria(Integer.parseInt(num[0]),Integer.parseInt(num[1]),Integer.parseInt(num[2]));
                add_pizzeria(p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This function is called to update the cover number of a block
     * @param row
     * @param column
     */
    private void cover(int row, int column) {
        int position = column + row*n;

        if (row < 1 || row > n || column < 1 || column > n) return;

        int covered = covered_by.getOrDefault(position, 0)+1;

        covered_by.put(position, covered);

        if (covered > max_covered) {
            max_covered = covered;
        }
    }

    public int solve(String input_file) {
        read_input(input_file);

        for (Pizzeria p : pizzerias) {
            int x = p.getX();
            int y = p.getY();
            int k = p.getK();

            for (int row = x - k; row <= x + k; row++) {
                if (row <= x) {
                    int column_offset = row + k - x;
                    for (int column = y-column_offset; column <= y+column_offset; column++) {
                        cover(row, column);
                    }
                } else {
                    int column_offset = k - row + x;
                    for (int column = y-column_offset; column <= y+column_offset; column++) {
                        cover(row, column);
                    }
                }
            }
        }

        System.out.println("Max cover: " + max_covered);

        return max_covered;
    }

    public static void main(String[] args) {
        Problem2 p = new Problem2();
        p.solve("input");
    }
}
