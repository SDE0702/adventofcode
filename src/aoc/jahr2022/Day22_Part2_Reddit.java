package aoc.jahr2022;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Objects;

public class Day22_Part2_Reddit 
{
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String fileName = "input22.txt";
        int Phase1Answer;
        int Phase2Answer;
        BufferedReader reader;
        char[][] grid = new char[0][];
        Object[] instructions = null;
        try {
            reader = new BufferedReader(new java.io.FileReader(fileName));
            String line = reader.readLine();
            ArrayList<ArrayList<Character>> gridList = new ArrayList<>();
            ArrayList<Character> preRow = new ArrayList<>();
            preRow.add(' ');
            gridList.add(preRow); // starting at 1,1 makes it easier on me later
            while (!line.isEmpty()) {
                ArrayList<Character> row = new ArrayList<>();
                row.add(' ');
                for (char c : line.toCharArray()) {
                    row.add(c);
                }
                gridList.add(row);
                line = reader.readLine();
            }
            int maxCol = 0;
            for (ArrayList<Character> row : gridList) {
                if (row.size() > maxCol) {
                    maxCol = row.size();
                }
            }
            grid = new char[gridList.size()][maxCol];
            for (int i = 1; i < gridList.size(); i++) {
                for (int j = 1; j < maxCol; j++) {
                    grid[i][j] = j < gridList.get(i).size() ? gridList.get(i).get(j) : ' ';
                }
            }
            instructions = parseInstructions(reader.readLine());
//            instructions = parseInstructions(Day22_2022_Part2_SecondTry.realMoves);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int startingX = 1;
        while(grid[1][startingX] != '.') {
            startingX++;
        }
        Day22_Part2_Reddit_Player player = new Day22_Part2_Reddit_Player(startingX, 1);
        for(Object instruction : Objects.requireNonNull(instructions)) {
            if(instruction instanceof Integer) {
                player.move((Integer) instruction, grid);
            } else {
                player.turn(((String) instruction).charAt(0));
            }
        }
        int[] coordinates = player.getCoodinates();
        Phase1Answer = (4*(coordinates[0])) + (1000*(coordinates[1])) + player.getDirection();
        System.out.println("Phase 1 Answer: " + Phase1Answer);
        player = new Day22_Part2_Reddit_Player(startingX, 1);
        player.setPhase2(true);
        for(Object instruction : instructions) {
            if(instruction instanceof Integer) {
                player.move((Integer) instruction, grid);
            } else {
                player.turn(((String) instruction).charAt(0));
            }
        }
        coordinates = player.getCoodinates();
        Phase2Answer = (4*(coordinates[0])) + (1000*(coordinates[1])) + player.getDirection();
        System.out.println("Phase 2 Answer: " + Phase2Answer);
        long currentTime = System.currentTimeMillis();
        double elapsedTime = (currentTime - startTime) / 1000.0;
        System.out.println("Time in seconds : " + elapsedTime);
    }
    private static Object[] parseInstructions(String directions) {
        ArrayList<Object> directionsArray = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (start < directions.length()) {
            if (directions.charAt(start) != 'L' && directions.charAt(start) != 'R') {
                while(end < directions.length() && directions.charAt(end) != 'L' && directions.charAt(end) != 'R') {
                    end++;
                }
                directionsArray.add(Integer.parseInt(directions.substring(start, end)));
            } else if (directions.charAt(start) == 'L' || directions.charAt(start) == 'R') {
                directionsArray.add(directions.substring(start, ++end));
            }
            start = end;
        }
        return directionsArray.toArray();
    }

}
