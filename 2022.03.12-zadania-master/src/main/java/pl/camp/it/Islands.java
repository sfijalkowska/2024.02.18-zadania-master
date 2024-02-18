package pl.camp.it;

public class Islands {
    public static void main(String[] args) {
        int[][] map = {
                {1,0,0,0,0,0},
                {0,1,0,1,1,1},
                {0,1,1,0,1,0},
                {1,1,0,0,1,0},
                {1,0,1,1,0,0},
                {1,0,0,0,0,1}
        };

        int[][] result = islands(map);
        for(int[] row : map) {
            for(int place : row) {
                System.out.print(place + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for(int[] row : result) {
            for(int place : row) {
                System.out.print(place + " ");
            }
            System.out.println();
        }
    }

    public static int[][] islands(int[][] startMap) {
        int[][] finalMap = new int[startMap.length][startMap[0].length];

        for(int i = 0; i < startMap.length; i++) {
            explorePlace(i, 0, startMap, finalMap);
            explorePlace(0, i, startMap, finalMap);
            explorePlace(i, startMap.length - 1, startMap, finalMap);
            explorePlace(startMap.length - 1, i, startMap, finalMap);
        }

        return finalMap;
    }

    public static void explorePlace(int i, int j, int[][] startMap, int[][] finalMap) {
        if(finalMap[i][j] == 1) {
            return;
        }

        if(startMap[i][j] == 1) {
            finalMap[i][j] = 1;

            //check UP
            if(i > 0 && startMap[i-1][j] == 1) {
                explorePlace(i-1, j, startMap, finalMap);
            }

            //check BOTTOM
            if(i < startMap.length - 1 && startMap[i+1][j] == 1) {
                explorePlace(i+1, j, startMap ,finalMap);
            }

            //check LEFT
            if(j > 0 && startMap[i][j-1] == 1) {
                explorePlace(i, j-1, startMap, finalMap);
            }

            //check RIGHT
            if (j < startMap.length - 1 && startMap[i][j + 1] == 1) {
                explorePlace(i, j+1, startMap, finalMap);
            }

        }
    }
}
