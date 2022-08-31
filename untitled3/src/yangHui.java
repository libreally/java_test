public class yangHui {
    public static void main(String[] args) {
        int[][] yang = new int[10][];
        for (int i = 0; i < yang.length; i++) {
            yang[i] = new int[i + 1];
            yang[i][0] = yang[i][i] = 1;
            if (i > 1) {
                for (int j = 1; j < yang[i].length - 1; j++) {
                    yang[i][j] = yang[i - 1][j - 1] + yang[i - 1][j];
                }
            }
        }
        for (int i = 0; i < yang.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.printf("%4d", yang[i][j]);
            }
            System.out.println(" ");
        }
    }
}