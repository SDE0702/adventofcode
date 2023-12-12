package aoc.jahr2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class Day20_2021_Part1_Reddit {

	public static void main(String[] args) throws IOException 
	{
			String in = Day20_2021_Part1.inputImage + "\n\n" + Day20_2021_Part1.input;
			
			ArrayList<String> list = new ArrayList<>();
			
			for(String s: in.split("\n"))
			{
				list.add(s);
			}
			
	        var imageEnhancementAlgorithm = list.get(0);

	        Map<String, Node> nodes = new TreeMap<>();

	        for (int i = 2; i < list.size(); i++) {
	            var line = list.get(i);
	            for (int j = 0; j < line.length(); j++) {
	                nodes.put((i - 2) + "," + j, new Node(i - 2, j, line.charAt(j)));
	            }
	        }
	        enhanceMap(nodes, imageEnhancementAlgorithm, 2);
	    }

	    private static String print(Map<String, Node> nodes) {
	        int minX = nodes.values().stream().map(node -> node.x).min(Integer::compareTo).orElse(0);
	        int maxX = nodes.values().stream().map(node -> node.x).max(Integer::compareTo).orElse(0);
	        int minY = nodes.values().stream().map(node -> node.y).min(Integer::compareTo).orElse(0);
	        int maxY = nodes.values().stream().map(node -> node.y).max(Integer::compareTo).orElse(0);

	        StringBuilder sb = new StringBuilder();
	        for (int i = minX; i <= maxX; i++) {
	            for (int j = minY; j <= maxY; j++) {
	                sb.append(nodes.getOrDefault(i + "," + j, new Node(i, j, '.')).value);
	            }
	            sb.append("\n");
	        }
	        return sb.toString();
	    }

	    private static void enhanceMap(Map<String, Node> nodes, String imageEnhancementAlgorithm, int times) {
	        int minX = 0;
	        int maxX = 0;
	        int minY = 0;
	        int maxY = 0;
	        for (int i = 0; i < times; i++) {
	            var newNodes = new TreeMap<>(nodes);
	            minX = nodes.values().stream().map(node -> node.x).min(Integer::compareTo).orElse(0) - 5;
	            maxX = nodes.values().stream().map(node -> node.x).max(Integer::compareTo).orElse(0) + 5;
	            minY = nodes.values().stream().map(node -> node.y).min(Integer::compareTo).orElse(0) - 5;
	            maxY = nodes.values().stream().map(node -> node.y).max(Integer::compareTo).orElse(0) + 5;
	            for (int x = minX; x <= maxX; x++) {
	                for (int y = minY; y <= maxY; y++) {
	                    var decimalPosition = calculateDecimalRepresentation(x, y, nodes);
	                    if (i % 2 == 1 && (x <= minX + 5 || x >= maxX - 5 || y <= minY + 5 || y >= maxY - 5)) {
	                        newNodes.put(x + "," + y, new Node(x, y, '.'));
	                    } else {
	                        newNodes.put(x + "," + y, new Node(x, y, imageEnhancementAlgorithm.charAt(decimalPosition)));
	                    }
	                }
	            }
	            nodes = newNodes;
//	            System.out.println(print(nodes));
	            System.out.println("Step " + i);
	        }
	        final int fminX = minX + 5;
	        final int fmaxX = maxX - 5;
	        final int fminY = minY + 5;
	        final int fmaxY = maxY - 5;
	        var litPixelsCount = nodes.values().stream()
	                .filter(node -> node.x > fminX && node.y > fminY && node.x < fmaxX && node.y < fmaxY)
	                .map(node -> node.value).filter(val -> val == '#').count();
	        System.out.println(litPixelsCount);

	    }

	    private static int calculateDecimalRepresentation(int x, int y, Map<String, Node> nodes) {
	        final StringBuilder sb = new StringBuilder();
	        Consumer<Node> append = node -> sb.append(node.value == '#' ? "1" : "0");
	        append.accept(nodes.getOrDefault((x - 1) + "," + (y - 1), new Node(x - 1, y - 1, '.')));
	        append.accept(nodes.getOrDefault((x - 1) + "," + (y), new Node(x - 1, y, '.')));
	        append.accept(nodes.getOrDefault((x - 1) + "," + (y + 1), new Node(x - 1, y + 1, '.')));
	        append.accept(nodes.getOrDefault((x) + "," + (y - 1), new Node(x, y - 1, '.')));
	        append.accept(nodes.getOrDefault((x) + "," + (y), new Node(x, y, '.')));
	        append.accept(nodes.getOrDefault((x) + "," + (y + 1), new Node(x, y + 1, '.')));
	        append.accept(nodes.getOrDefault((x + 1) + "," + (y - 1), new Node(x + 1, y - 1, '.')));
	        append.accept(nodes.getOrDefault((x + 1) + "," + (y), new Node(x + 1, y, '.')));
	        append.accept(nodes.getOrDefault((x + 1) + "," + (y + 1), new Node(x + 1, y + 1, '.')));
	        return Integer.parseInt(sb.toString(), 2);
	    }

	    static class Node {
	        int x;
	        int y;
	        char value;

	        public Node(int x, int y, char value) {
	            this.x = x;
	            this.y = y;
	            this.value = value;
	        }

	        @Override
	        public String toString() {
	            return "Node{" +
	                    "x=" + x +
	                    ", y=" + y +
	                    ", value=" + value +
	                    '}';
	        }
	    }
}
