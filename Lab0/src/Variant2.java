public class Variant2 {
    enum Mark{BAD, VERYBAD, GOOD, PERFECT, NORMAL; }

    /**
     * @param a is square side
     * @return area
     */
    public int inputOutputTask(int a) {
        return a * a;
    }

    /**
     * @param m is weight in kg
     * @return weight in t
     */

    public int integerNumbersTask(int m) {
        return m / 1000;
    }

    /**
     * @param a integer
     * @return true, if number is odd
     */
    public boolean booleanTask(int a) {
        if (a % 2 != 0)
            return true;
        else
            return false;
    }


    /**
     * @param b is integer number
     * @return transformed number, if number is possitive - add 1, else - subtract 2
     */
    public int ifTask(int b) {
        if (b > 0)
            b++;
        else b = b - 2;
        return b;
    }


    /**
     * @param number mark
     * @return description of the mark
     */

    public Mark switchTask(int number) {
        switch (number) {
            case 1: return Mark.VERYBAD;
            case 2: return Mark.BAD;
            case 3: return Mark.NORMAL;
            case 4: return Mark.GOOD;
            case 5: return Mark.PERFECT;
        }

        throw new RuntimeException("Wrong input");
    }


    /**
     *
     * @param a integer
     * @param b
     * @return Print in increasing order all integers located between A and B (including the numbers A and B themselves), as well as the number N of these numbers.
     */

    public int[] forTask(int a, int b) {
        //assert n > 0 : "Argument should be more than zero";
        int n=0;
        //String result = "";
        int[] res = new int[b-a+2];
        res[0] = b-a+1;
        int currentIndex = 1;
        for (int i = a; i <= b; i++) {
            //result += " " + i;
            res[currentIndex++]=i;
        }

        //re += " " + n;
        return res;
    }

    /**
     * @param a
     * @param b
     * @return Without using the operations of multiplication and division, find the number of segments B placed on segment A.
     */

    public int whileTask(int a, int b) {
        assert a > b : "Invalid numbers";

        int n = 0, sum = 0;

        while (sum + b <= a) {
            ++n;
            sum += b;
        }

        return n;
    }

    /**
     * @param n
     * @return Form and output an integer array of size N containing the powers of two from the first to the Nth: 2, 4, 8, 16, ....
     */

    public int[] arrayTask(int n) {
        int k = 1;
        int[] mass = new int[n];
        for(int i = 0; i < n; i++) {
            k = 2 * k;
            mass[i] = k;
        }
        return mass;
    }



    /**
     * @param array
     * @return Generate an integer matrix of size M x N for which all elements of the Jth column have a value of 5 * J (J = 1, ..., N).
     */
    public int[][]  twoDimensionArrayTask(int[][] array) {
      //  int res[][] = new int[m][n];

        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                array[i][j] = (j+1)*5;
                //   System.out.print(array[i][j]+"  ");
                System.out.print(array[i][j]+" ");
            }
            System.out.println("\n");
        }
        return array;
    }
}
