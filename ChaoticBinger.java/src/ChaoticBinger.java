import java.util.*;
    public class ChaoticBinger {

        public static int longestBingeStreak(int[] episodes) {
            Set<Integer> episodeSet = new HashSet<>();
            for (int ep : episodes) {
                episodeSet.add(ep);
            }

            int maxStreak = 0;

            for (int ep : episodeSet) {
                if (!episodeSet.contains(ep - 1)) { // start of a streak
                    int current = ep;
                    int streak = 1;
                    while (episodeSet.contains(current + 1)) {
                        current++;
                        streak++;
                    }
                    maxStreak = Math.max(maxStreak, streak);
                }
            }

            return maxStreak;
        }

        public static void main(String[] args) {
            int[][] testCases = {
                    {1,2,3,4,5},
                    {10,12,11,14,13},
                    {100,4,200,1,3,2,5,6,5,77},
                    {7,3,1,2,4,6,5},
                    {20,30,10,40,50},
                    {5,5,5,5,5},
                    {1,3,5,7,9},
                    {8,9,1,2,3,4,5},
                    {15,16,17,14,13,12,11},
                    {1000,1001,1002,500,501,502,503}
            };

            for (int i = 0; i < testCases.length; i++) {
                System.out.println("Test Case " + (i+1) + ": " + longestBingeStreak(testCases[i]));
            }
        }
    }
