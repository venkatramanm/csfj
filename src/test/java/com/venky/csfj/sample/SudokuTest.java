package com.venky.csfj.sample;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.venky.csfj.sample.Sudoku.CellVariable;
import com.venky.csfj.solver.Solution;
import com.venky.csfj.solver.Solver;
import com.venky.csfj.solver.variable.Variable;

/**
 *
 * @author Venky
 */
public class SudokuTest {

    public SudokuTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testSudoku(){
        Sudoku s = new Sudoku();
        int[][] init_values =  {
            {0,7,0,0,4,0,0,0,0},
            {9,4,0,1,0,0,0,0,0},
            {0,0,0,0,9,3,8,0,0},
            {2,3,0,0,0,7,5,0,0},
            {4,5,0,0,0,0,0,3,2},
            {0,0,9,2,0,0,0,1,6},
            {0,0,2,8,7,0,0,0,0},
            {0,0,0,0,0,4,0,6,8},
            {0,0,0,0,2,0,0,5,0}
        };
        s.register_initial_values(init_values);
        Solver<Integer> solver = new Solver<Integer>(s);
        Solution<CellVariable,Integer> solution = solver.solve();
        print(solution);
    }
    public void print(HashMap<CellVariable,Integer> h){
        int [][] solution = new int[9][9];
        for (Variable<Integer> v : h.keySet()){
        	CellVariable var = (CellVariable)v;
            solution[var.row][var.col] = h.get(var);
        }
        for (int row = 0 ; row < 9 ; row ++){
            StringBuffer buff = new StringBuffer();
            for (int col = 0 ; col < 9 ; col ++) {
                buff.append(solution[row][col]);
                if (col < 8) {
                    buff.append(",");
                }
            }
            System.out.println(buff);
        }
    }
    
}