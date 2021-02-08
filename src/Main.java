import java.util.*;

public class Main {
    public static void main(String[] args) {
        getRandomArrays(5);

    }

    public static int[][] getRandomArrays(int number) {
        int[][] randomArrays = new int[number][];
        Set<Integer> randomSizesOfArrays = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < number; i++) {
            int randomSizeOfArray = random.nextInt(number) + 1;
            if (randomSizesOfArrays.contains(randomSizeOfArray)) {
                i--;
            } else {
                randomSizesOfArrays.add(randomSizeOfArray);
                randomArrays[i] = new int[randomSizeOfArray];
                for (int j = 0; j < randomArrays[i].length; j++) {
                    randomArrays[i][j] = random.nextInt();
                }
                Arrays.sort(randomArrays[i]);
                if (i % 2 != 0) {
                    for (int h = 0; h < randomArrays[i].length / 2; h++) {
                        int buffer = randomArrays[i][h];
                        randomArrays[i][h] = randomArrays[i][randomArrays[i].length - h - 1];
                        randomArrays[i][randomArrays[i].length - h - 1] = buffer;
                    }
                }
            }
        }
        return randomArrays;
    }
}
