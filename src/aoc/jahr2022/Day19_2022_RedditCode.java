package aoc.jahr2022;

public class Day19_2022_RedditCode {

	    static String input = 
"""
Blueprint 1: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 16 clay. Each geode robot costs 3 ore and 9 obsidian.
Blueprint 2: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 5 clay. Each geode robot costs 4 ore and 8 obsidian.
Blueprint 3: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 14 clay. Each geode robot costs 2 ore and 16 obsidian.
Blueprint 4: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 2 ore and 18 clay. Each geode robot costs 4 ore and 20 obsidian.
Blueprint 5: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 16 clay. Each geode robot costs 2 ore and 15 obsidian.
Blueprint 6: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 14 clay. Each geode robot costs 3 ore and 8 obsidian.
Blueprint 7: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 15 clay. Each geode robot costs 4 ore and 17 obsidian.
Blueprint 8: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 10 clay. Each geode robot costs 2 ore and 7 obsidian.
Blueprint 9: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 8 clay. Each geode robot costs 2 ore and 18 obsidian.
Blueprint 10: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 11 clay. Each geode robot costs 2 ore and 19 obsidian.
Blueprint 11: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 9 clay. Each geode robot costs 4 ore and 16 obsidian.
Blueprint 12: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 2 ore and 16 clay. Each geode robot costs 4 ore and 16 obsidian.
Blueprint 13: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 18 clay. Each geode robot costs 2 ore and 11 obsidian.
Blueprint 14: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 7 clay. Each geode robot costs 2 ore and 9 obsidian.
Blueprint 15: Each ore robot costs 2 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 17 clay. Each geode robot costs 4 ore and 20 obsidian.
Blueprint 16: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 9 clay. Each geode robot costs 2 ore and 20 obsidian.
Blueprint 17: Each ore robot costs 2 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 20 clay. Each geode robot costs 4 ore and 18 obsidian.
Blueprint 18: Each ore robot costs 4 ore. Each clay robot costs 3 ore. Each obsidian robot costs 4 ore and 18 clay. Each geode robot costs 4 ore and 11 obsidian.
Blueprint 19: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 16 clay. Each geode robot costs 2 ore and 18 obsidian.
Blueprint 20: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 17 clay. Each geode robot costs 4 ore and 16 obsidian.
Blueprint 21: Each ore robot costs 4 ore. Each clay robot costs 3 ore. Each obsidian robot costs 4 ore and 6 clay. Each geode robot costs 3 ore and 11 obsidian.
Blueprint 22: Each ore robot costs 3 ore. Each clay robot costs 3 ore. Each obsidian robot costs 2 ore and 16 clay. Each geode robot costs 3 ore and 14 obsidian.
Blueprint 23: Each ore robot costs 2 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 19 clay. Each geode robot costs 2 ore and 18 obsidian.
Blueprint 24: Each ore robot costs 2 ore. Each clay robot costs 3 ore. Each obsidian robot costs 3 ore and 9 clay. Each geode robot costs 3 ore and 9 obsidian.
Blueprint 25: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 8 clay. Each geode robot costs 2 ore and 15 obsidian.
Blueprint 26: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 10 clay. Each geode robot costs 2 ore and 13 obsidian.
Blueprint 27: Each ore robot costs 3 ore. Each clay robot costs 4 ore. Each obsidian robot costs 3 ore and 6 clay. Each geode robot costs 4 ore and 11 obsidian.
Blueprint 28: Each ore robot costs 4 ore. Each clay robot costs 4 ore. Each obsidian robot costs 4 ore and 7 clay. Each geode robot costs 2 ore and 19 obsidian.
Blueprint 29: Each ore robot costs 4 ore. Each clay robot costs 3 ore. Each obsidian robot costs 4 ore and 11 clay. Each geode robot costs 3 ore and 15 obsidian.
Blueprint 30: Each ore robot costs 2 ore. Each clay robot costs 2 ore. Each obsidian robot costs 2 ore and 20 clay. Each geode robot costs 2 ore and 14 obsidian.		
""";

    static int[] cost;

    int geodeBest;

    int maxTime;

    public String part1() {
        int quality = 0;
        String[] lines = input.split("\n");
        for(int i = 0; i < lines.length; i++) {
            String s = lines[i];
            cost = new int[6];
            geodeBest = 0;
            String[] bots = s.split(": |\\. ");
            //ore bot
            cost[0] = Integer.parseInt(bots[1].split(" ")[4]);
            //clay bot
            cost[1] = Integer.parseInt(bots[2].split(" ")[4]);
            //obsidian bot
            cost[2] = Integer.parseInt(bots[3].split(" ")[4]);
            cost[3] = Integer.parseInt(bots[3].split(" ")[7]);
            //geode bot
            cost[4] = Integer.parseInt(bots[4].split(" ")[4]);
            cost[5] = Integer.parseInt(bots[4].split(" ")[7]);

            maxTime = 24;

            quality += (i+1) * mostGeodes(0,0,0,0,1,0,0,0,0);
        }
        return Integer.toString(quality);
    }

    //ore, clay, obsidian, geodes, ore robots, clay robots, obsidian robots, geode robots, current time
    public int mostGeodes(int o, int c, int ob, int g, int or, int cr, int obr, int gr, int time) {
        if(time == maxTime) {
            geodeBest = Math.max(geodeBest,g);
            return g;
        }

        //prune calls that can't realistically beat the best geode score
        //using the unrealistic heuristic of producing 1 geode robot for each turn remaining
        //this still gets rid of enough cases to bring runtime from days into seconds
        int minsLeft = maxTime - time;
        int maxGeodesPossible = g;
        for(int i = 0; i < minsLeft; i++)
            maxGeodesPossible += gr + i;
        if(maxGeodesPossible < geodeBest)
            return 0;

        //calculate new materials values for after this cycle
        int no = o + or;
        int nc = c + cr;
        int nob = ob + obr;
        int ng = g + gr;

        //overall, we can make a few assumptions to prune and reduce the solution space:
        //1. if we have more than the maximum ore cost of a bot, always make a bot
        //2. we only ever need as many bots to produce the maximum cost for that material in one turn
        // for example, if the geode bot costs 5 obsidian, we never need more than 5 obsidian bots, because we can only craft one geode bot per turn
        //between these optimizations, plus usually prioritizing making the most advanced bot available, we vastly trim the recursion tree and get an answer in just a few seconds

        //two guaranteed conditions that we know will always be the best:
        //we always want to make a geode robot whenever possible
        //and if we have enough clay robots, we always want to make an obsidian robot if possible
        //we almost always want to make an obsidian robot whenever possible, but there's a few edge cases where one more clay bot is better
        if(o >= cost[4] && ob >= cost[5])
            return mostGeodes(no-cost[4], nc, nob - cost[5], ng, or, cr, obr, gr + 1, time + 1);
        if(cr >= cost[3] && obr < cost[5] && o >= cost[2] && c >= cost[3])
            return mostGeodes(no-cost[2], nc - cost[3], nob, ng, or, cr, obr + 1, gr, time + 1);

        //for the non-guaranteed conditions, take the maximum of any
        int best = 0;
        //if not too many obsidian bots and enough to make one, make one
        if(obr < cost[5] && o >= cost[2] && c >= cost[3])
            best = Math.max(best,mostGeodes(no-cost[2], nc - cost[3], nob, ng, or, cr, obr + 1, gr, time + 1));
        //if not too many clay bots and enough to make one, make one
        if(cr < cost[3] && o >= cost[1])
            best = Math.max(best,mostGeodes(no-cost[1],nc,nob,ng,or,cr+1,obr,gr,time + 1));
        //if not too many ore bots and enough to make one, make one
        if(or < 4 && o >= cost[0])
            best = Math.max(best,mostGeodes(no-cost[0],nc,nob,ng,or+1,cr,obr,gr,time+1));
        //if not holding on to more ore than maximum bot cost, wait and see if we can make a better bot later
        if(o <= 4)
            best = Math.max(best,mostGeodes(no,nc,nob,ng,or,cr,obr,gr,time+1));

        return best;
    }

    public String part2() {
        int quality = 1;
        String[] lines = input.split("\n");
        for(int i = 0; i < 3; i++) {
            String s = lines[i];
            cost = new int[6];
            geodeBest = 0;
            String[] bots = s.split(": |\\. ");
            //ore bot
            cost[0] = Integer.parseInt(bots[1].split(" ")[4]);
            //clay bot
            cost[1] = Integer.parseInt(bots[2].split(" ")[4]);
            //obsidian bot
            cost[2] = Integer.parseInt(bots[3].split(" ")[4]);
            cost[3] = Integer.parseInt(bots[3].split(" ")[7]);
            //geode bot
            cost[4] = Integer.parseInt(bots[4].split(" ")[4]);
            cost[5] = Integer.parseInt(bots[4].split(" ")[7]);

            maxTime = 32;

            quality *= mostGeodes(0,0,0,0,1,0,0,0,0);
        }
        return Integer.toString(quality);
    }

    public static void main(String[] args) 
    {
    	Day19_2022_RedditCode c = new Day19_2022_RedditCode();
    	System.out.println(c.part2());
    }
}
