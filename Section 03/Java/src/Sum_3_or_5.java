public class Sum_3_or_5 {
    public static void main(String[] args) {

        System.out.println("The sum of the Common Factors for 3 or 5 is : " + getSum());

    }

    private static int getSum() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
                System.out.println(i+" ");
            }
        }

        return sum;
    }
}