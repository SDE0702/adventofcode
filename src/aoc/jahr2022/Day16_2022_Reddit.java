package aoc.jahr2022;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Day16_2022_Reddit {

public static String input = 
"""
Valve EJ has flow rate=25; tunnel leads to valve MC
Valve WC has flow rate=0; tunnels lead to valves OW, RU
Valve NP has flow rate=0; tunnels lead to valves VR, KL
Valve AA has flow rate=0; tunnels lead to valves QT, AP, EZ, AK, XV
Valve VO has flow rate=6; tunnels lead to valves KM, RF, HS, LJ, IA
Valve CB has flow rate=0; tunnels lead to valves UI, UP
Valve TE has flow rate=18; tunnel leads to valve JT
Valve CZ has flow rate=0; tunnels lead to valves UP, OW
Valve LJ has flow rate=0; tunnels lead to valves DV, VO
Valve UP has flow rate=7; tunnels lead to valves SK, CB, CZ
Valve FP has flow rate=0; tunnels lead to valves OW, RE
Valve KM has flow rate=0; tunnels lead to valves SE, VO
Valve DV has flow rate=0; tunnels lead to valves LJ, UM
Valve FL has flow rate=0; tunnels lead to valves AH, TS
Valve VR has flow rate=24; tunnels lead to valves DM, TF, NP
Valve IA has flow rate=0; tunnels lead to valves VS, VO
Valve RF has flow rate=0; tunnels lead to valves VO, JF
Valve RT has flow rate=0; tunnels lead to valves UM, SE
Valve RU has flow rate=0; tunnels lead to valves AR, WC
Valve SE has flow rate=4; tunnels lead to valves GU, KM, CX, RT
Valve MC has flow rate=0; tunnels lead to valves EJ, AR
Valve TF has flow rate=0; tunnels lead to valves AH, VR
Valve CX has flow rate=0; tunnels lead to valves SE, TO
Valve GL has flow rate=11; tunnels lead to valves UY, KL, CY
Valve GU has flow rate=0; tunnels lead to valves SE, EZ
Valve VS has flow rate=0; tunnels lead to valves XN, IA
Valve EZ has flow rate=0; tunnels lead to valves AA, GU
Valve GK has flow rate=0; tunnels lead to valves FI, HZ
Valve JT has flow rate=0; tunnels lead to valves TE, XN
Valve DM has flow rate=0; tunnels lead to valves VR, HZ
Valve AR has flow rate=16; tunnels lead to valves UI, RU, MC
Valve XN has flow rate=9; tunnels lead to valves XP, JT, VS, GT, CY
Valve CY has flow rate=0; tunnels lead to valves XN, GL
Valve QT has flow rate=0; tunnels lead to valves UM, AA
Valve KL has flow rate=0; tunnels lead to valves GL, NP
Valve SK has flow rate=0; tunnels lead to valves XV, UP
Valve OW has flow rate=12; tunnels lead to valves CZ, WC, FP
Valve AK has flow rate=0; tunnels lead to valves AA, HS
Valve XV has flow rate=0; tunnels lead to valves AA, SK
Valve GT has flow rate=0; tunnels lead to valves XN, UM
Valve FI has flow rate=0; tunnels lead to valves JF, GK
Valve UY has flow rate=0; tunnels lead to valves JF, GL
Valve UM has flow rate=5; tunnels lead to valves DV, GT, RT, QT
Valve IQ has flow rate=0; tunnels lead to valves HZ, AH
Valve JF has flow rate=10; tunnels lead to valves RF, FI, UY, RE, TS
Valve TS has flow rate=0; tunnels lead to valves JF, FL
Valve AH has flow rate=23; tunnels lead to valves IQ, FL, TF
Valve HS has flow rate=0; tunnels lead to valves AK, VO
Valve HZ has flow rate=20; tunnels lead to valves IQ, DM, GK
Valve TO has flow rate=15; tunnel leads to valve CX
Valve XP has flow rate=0; tunnels lead to valves AP, XN
Valve AP has flow rate=0; tunnels lead to valves XP, AA
Valve RE has flow rate=0; tunnels lead to valves JF, FP
Valve UI has flow rate=0; tunnels lead to valves AR, CB
""";	
	
	public static class Tunnel {
	    public int rate;
	    public String name;
	    public boolean open;
	    public ArrayList<String> neighbors;
	    public HashMap<String, Integer> neighborsWithWeight;
	 
	 
	    public Tunnel(String name, int rate, ArrayList<String> neighbors) {
	        this.name = name;
	        this.rate = rate;
	        this.neighbors = neighbors;
	        this.open = (rate <= 0);
	    }
	 
	    public String toString() {
	        return "(name: " + name + ",rate: " + rate + ",neighbors: " + neighbors + ", open: " + open + ", neighborsWithWeight: " + neighborsWithWeight + ")";
	    }
	}
	 
    public static void ex16() {
        String[] inhalt;
        TreeSet<String> tunnelNames = new TreeSet<>();
        TreeSet<String> tunnelNamesReallyNeeded = new TreeSet<>();
        HashMap<String, Tunnel> tunnels = new HashMap<>();

        inhalt = input.split("\n");
        String zeilenPart;
        String valveName;
        int rate;
        ArrayList<String> leadingTo;
        for (String zeile : inhalt) {
            valveName = zeile.split(" has flow rate=")[0].replace("Valve ", "");
            zeilenPart = zeile.split(" has flow rate=")[1];
            rate = Integer.parseInt(zeilenPart.split("; tunnel(s)? lead(s)? to valve(s)? ")[0]);
            leadingTo = new ArrayList<>(List.of(zeilenPart.split("; tunnel(s)? lead(s)? to valve(s)? ")[1].split(", ")));
            tunnelNames.add(valveName);
            tunnels.put(valveName, new Tunnel(valveName, rate, leadingTo));
        }
 
        for (String tunnelName : tunnelNames) {
            tunnels.get(tunnelName).neighborsWithWeight = ex16_createNeighborWeight(tunnels.get(tunnelName), tunnelNames, tunnels, 30);
            System.out.println(tunnelName + ": " + tunnels.get(tunnelName).neighborsWithWeight);
            if(tunnels.get(tunnelName).rate > 0) {
                tunnelNamesReallyNeeded.add(tunnelName);
            }
        }
 
 
        String currentTunnel = "AA";
        int maxMinutes = 30;
        System.out.println("ex16: " + ex16_findHighestRelease(currentTunnel, maxMinutes, tunnels, tunnelNamesReallyNeeded, 0));
        currentTunnel = "AA";
        maxMinutes = 26;
        System.out.println("ex16_2: " + ex16_findHighestReleaseWithElephant(currentTunnel, currentTunnel, maxMinutes, maxMinutes, tunnels, tunnelNamesReallyNeeded, 0));
        // works, but took around 10 hours xD
    }
 
    public static int ex16_findHighestReleaseWithElephant(String currentTunnel, String currentTunnelEl, int minutes, int minutesEl, HashMap<String, Tunnel> tunnels, TreeSet<String> tunnelNames, int maxRelease) {
        int currentTunnelRateTimesMinutesLeft, currentWeight, currentTunnelRateTimesMinutesLeftEl, currentWeightEl;
        TreeSet<String> shortTunnelNames;
        int newMaxRelease = 0, meNext = 0, elNext = 0;
        if(minutes <= 0 && minutesEl <= 0) {
            return maxRelease;
        }
        for (String nextTunnel : tunnelNames) {
            shortTunnelNames = new TreeSet<>(tunnelNames);
            shortTunnelNames.remove(nextTunnel);
            currentWeight = tunnels.get(currentTunnel).neighborsWithWeight.get(nextTunnel);
            currentWeightEl = tunnels.get(currentTunnelEl).neighborsWithWeight.get(nextTunnel);
            currentTunnelRateTimesMinutesLeft = (minutes - currentWeight) * tunnels.get(nextTunnel).rate;
            currentTunnelRateTimesMinutesLeftEl = (minutesEl - currentWeightEl) * tunnels.get(nextTunnel).rate;
            if((minutes - currentWeight) >= 0 && !nextTunnel.equals(currentTunnel)) {
                meNext = currentTunnelRateTimesMinutesLeft + ex16_findHighestReleaseWithElephant(nextTunnel, currentTunnelEl, (minutes - currentWeight), minutesEl, tunnels, shortTunnelNames, maxRelease);
            }
            if((minutesEl - currentWeightEl) >= 0 && !nextTunnel.equals(currentTunnelEl)) {
                elNext = currentTunnelRateTimesMinutesLeftEl + ex16_findHighestReleaseWithElephant(currentTunnel, nextTunnel, minutes, (minutesEl - currentWeightEl), tunnels, shortTunnelNames, maxRelease);
            }
            newMaxRelease = Math.max(Math.max(meNext, elNext), newMaxRelease);
        }
        return Math.max(maxRelease, newMaxRelease);
    }
 
    public static int ex16_findHighestRelease(String currentTunnel, int minutes, HashMap<String, Tunnel> tunnels, TreeSet<String> tunnelNames, int maxRelease) {
        int currentTunnelRateTimesMinutesLeft, currentWeight;
        TreeSet<String> shortTunnelNames;
        int newMaxRealease = 0;
        if(minutes <= 0) {
            return maxRelease;
        }
        for (String neigh : tunnelNames) {
            if(neigh.equals(currentTunnel)) {
                continue;
            }
            currentWeight = tunnels.get(currentTunnel).neighborsWithWeight.get(neigh);
            if((minutes - currentWeight) < 0) {
                continue;
            }
            shortTunnelNames = new TreeSet<>(tunnelNames);
            shortTunnelNames.remove(neigh);
            currentTunnelRateTimesMinutesLeft = (minutes - currentWeight) * tunnels.get(neigh).rate;
            newMaxRealease = Math.max(currentTunnelRateTimesMinutesLeft + ex16_findHighestRelease(neigh, (minutes - currentWeight), tunnels, shortTunnelNames, maxRelease), newMaxRealease);
        }
        return Math.max(maxRelease, newMaxRealease);
    }
 
    public static HashMap<String, Integer> ex16_createNeighborWeight(Tunnel tunnel, TreeSet<String> tunnelNames, HashMap<String, Tunnel> tunnels, int maxPath) {
        HashMap<String, Integer> neighborWeights = new HashMap<>();
 
        int weight = 1, weightToOpen = 1;
        for (String tunnelName : tunnelNames) {
            if(tunnelName.equals(tunnel.name) || tunnels.get(tunnelName).rate == 0) {
                continue;
            }
            if(tunnel.neighbors.contains(tunnelName)) {
                neighborWeights.put(tunnelName, weight + weightToOpen);
                continue;
            }
            neighborWeights.put(tunnelName, ex16_shortestPath(tunnel, tunnelName, tunnels, new TreeSet<>(), maxPath, weight, weightToOpen, weight));
        }
 
        return neighborWeights;
    }
 
    public static int ex16_shortestPath(Tunnel tunnel, String tunnelName, HashMap<String, Tunnel> tunnels, TreeSet<String> visited, int maxPath, int weight, int weightToOpen, int path) {
 
        TreeSet<String> newVisited = new TreeSet<String>(visited);
        int returnPath = Integer.MAX_VALUE;
        for (String neigh : tunnel.neighbors) {
            if(visited.contains(neigh)) {
                continue;
            }
            if(path > maxPath) {
                continue;
            }
            if(neigh.equals(tunnelName)) {
                returnPath = Math.min(path + weightToOpen, maxPath);
            }
            newVisited.add(neigh);
            int shortestPath = ex16_shortestPath(tunnels.get(neigh), tunnelName, tunnels, newVisited, maxPath, weight, weightToOpen, path + weight);
            if(shortestPath < maxPath) {
                int shortestPathNew = ex16_shortestPath(tunnels.get(neigh), tunnelName, tunnels, newVisited, shortestPath, weight, weightToOpen, path + weight);
                returnPath = Math.min(Math.min(shortestPath, shortestPathNew), returnPath);
            }
        }
        return returnPath;
    }

    public static void main(String[] args) throws Exception 
    {
		ex16();
	}
}
