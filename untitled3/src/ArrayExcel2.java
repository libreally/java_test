public class ArrayExcel2 {
    public static void main(String[] args) {
        int[] array1, array2;
        array1 = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        for (int j : array1) {
            System.out.print(j+"  ");
        }
        //将array1复制给array2；
        System.out.println();
        array2 =new int[array1.length];
        System.arraycopy(array1, 0, array2, 0, array2.length);
        for (int j : array2) {
            System.out.print(j+"  ");
        }
        //替换偶数下标并使其等于其下标数
        for (int k=0;k<array2.length;k++) {
            if (k % 2 == 0) {
                array2[k] = k;
            }
        }
            System.out.println();
            for (int i : array2) {
                System.out.print(i+ " ");
        }
    }
}
