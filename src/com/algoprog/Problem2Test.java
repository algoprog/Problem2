package com.algoprog;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @org.junit.jupiter.api.Test
    void solve() {
        Problem2 p = new Problem2();
        p.add_pizzeria(new Problem2.Pizzeria(3,3,2));
        p.add_pizzeria(new Problem2.Pizzeria(1, 1, 2));
        p.set_size(5);
        int result = p.solve("");

        assertEquals(2, result);
    }
}