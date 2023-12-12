package aoc.jahr2021;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Day18_2021_Part1 {

    public static void main(String[] args) 
    {
        System.out.println(calculateSurfaceArea(parseParticles("input18_2021.txt")));
    }

    public static Cube parseParticles(String fileName) {
        InputStream resourceAsStream = Day18_2021_Part1.class.getResourceAsStream(fileName);
        assert resourceAsStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));

        return new Cube(reader.lines().map(Particle::new).collect(Collectors.toSet()));
    }

    public static int calculateSurfaceArea(Cube cube) {
        return cube.findExposedSides();
    }
}
