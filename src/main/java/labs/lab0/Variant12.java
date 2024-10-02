package labs.lab0;

public class Variant12 {

    /** Дано тризначне число. Вивести число, отримане під час прочитання вихідного числа 
     * праворуч наліво. */

    /**
    * 
    * @param k is initial number
    * @return k2 that is a representation of k1 from right to left
    */
    public int integerNumbersTask(int k) {
        assert k >= 0 : "Input should be a non-negative integer";
    
        int k2 = 0;
        while (k > 0) {
            int number = k % 10;
            k2 = k2 * 10 + number;
            k /= 10; 
        }
        return k2;
    }

    /** Дано три цілих числа: A, B, C. Перевірити істинність висловлювання: 
     * Кожне з чисел A, B, C позитивне. */
	
    /**
    * 
    * @param a
    * @param b
    * @param c
    * @return true if all numbers A, B, and C are positive; else return false
    */
    public boolean booleanTask(int a, int b, int c) {
        return (a > 0 && b > 0 && c > 0);
    }
	

	/* Дано три числа. Знайти найменше з них. */

    /**
    * 
    * @param n1
    * @param n2
    * @param n3
    * @return the smallest number
    */
    public int ifTask(int n1, int n2, int n3) {
        if (n1 <= n2 && n1 <= n3) return n1;
        if (n2 <= n1 && n2 <= n3) return n2;
        return n3;
    }

    /** Елементи кола пронумеровані в такий спосіб: 
    * 1 - радіус R, 2 - діаметр D = 2*R, 3 - довжина L = 2*p*R, 4 - площа кола S = p*R^2 . 
    * Даний номер одного з цих елементів і його значення. Вивести значення інших елементів даного кола
    * (в тому ж порядку). Як значення p використовувати 3.14.
    */

    /**
    * 
    * @param elem the number of the element (1 - radius, 2 - diameter, 3 - length, 4 - area)
    * @param value the value of the element
    * @return an array with the values of all elements
    */
    public double[] caseTask(int elementNumber, double value) {

        assert elementNumber >= 1 && elementNumber <= 4 : "Element number should be a number from 1 to 4";
        assert value > 0 : "Value has to be greater than 0";

        final double PI = 3.14;
        double radius = 0;
        double diameter = 0;
        double length = 0;
        double area = 0;

        switch (elementNumber) {
        case 1:
            radius = value;
            diameter = 2 * radius;
            length = 2 * PI * radius;
            area = PI * radius * radius;
            break;

        case 2:
            diameter = value;
            radius = diameter / 2;
            length = 2 * PI * radius;
            area = PI * radius * radius;
            break;

        case 3:
            length = value;
            radius = length / (2 * PI);
            diameter = 2 * radius;
            area = PI * radius * radius;
            break;

        case 4:
            area = value;
            radius = Math.sqrt(area / PI);
            diameter = 2 * radius;
            length = 2 * PI * radius;
            break;
    }

    return new double[] { radius, diameter, length, area };
}


/**
 * 
 * @param n is integer number
 * @return approximated value
 */
	public double forTask(int n) {
		assert n > 0: "Argument should be more than zero";

        double res = 1.0;
        double dod = 1.1;

        for (int i = 0; i < n; i++) {
            res *= dod;
            dod += 0.1;
        }

        return res;
    }




    /** Дане ціле число N<i>N</i> (&gt;&nbsp;1). Вивести найбільше з цілих чисел K, 
     * для яких сума 1+ +3 +K буде меншою або 
     * дорівнює N, і саму цю суму.*/

/**
 * 
 * @param a is integer number
 * @return K the biggest number that K!<=N
 */
    public int[] whileTask(int N) {
		assert (N > 0): "Argument should be more than zero";

        int K = 0;
        int sum = 0;
        int i = 1;
    
        while (i <= N) {
            sum += i;
            if (sum > N) break;
            K = i;
            sum = sum - i;
            i++;
        }
		return new int[]{K, sum};
	}
    

    /* Дано масив A  розміру&nbsp; N  ( N &nbsp;&#151; парне число). 
    Вивести його елементи з парними номерами в порядку зростання номерів. Умовний 
    оператор не використовує.</p> */

/**
 * 
 * @param a is an array
 * @return nothing, print out needed numbers
 */
    public int[] arrayTask(int[] a) {
        int size = (a.length + 1) / 2;
        int[] b = new int[size];
        int j = 0;
        for (int i = 0; i < a.length; i += 2) {
            b[j] = a[i];
            j++;
        }
        return b;
    }

    /*Дана матриця розміру M N. Вивести її елементи в наступному порядку: перший стовпець зверху вниз, 
    другий стовпець знaизу вгору, третій стовпець зверху вниз, 
    четвертий стовпець знизу вгору і т.д.</p>
     */
/**
 * 
 * @param mtrx is a matrix
 * @return matrix with correctly displayed columns
 */
    public int[][] matrixTask(int[][] mtrx) {
        assert (mtrx != null) : "Matrix should not be null";
        assert (mtrx.length > 0) : "Matrix should have at least 1 row";
        assert (mtrx[0].length > 0) : "Matrix should have at least 1 column";
    
        int m = mtrx.length;
        int n = mtrx[0].length;

        int[][] res = new int[m][n];

        for (int j = 0; j < n; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < m; i++) {
                    res[i][j] = mtrx[i][j];
                }
            } else {
                for (int i = 0; i < m; i++) {
                    res[i][j] = mtrx[m - 1 - i][j];
                }
            }
        }

        return res;
    }
    

	public static void main(String... strings) {
        System.out.println("Start of zero lab");
        Variant12 variant = new Variant12();

        int integerVar = variant.integerNumbersTask(158);
        System.out.println("Integer task: " + integerVar);

        boolean booleanVar = variant.booleanTask(2, 5, 9);
        System.out.println("Boolean task: " + booleanVar);

        int ifVar = variant.ifTask(10, 9, 1);
        System.out.println("If task: " + ifVar);
        
        double[] caseVar = variant.caseTask(2, 10);
        System.out.println("Case task: ");
        System.out.printf("Radius: %.2f, Diameter: %.2f, Length: %.2f, Area: %.2f%n", 
                        caseVar[0], caseVar[1], caseVar[2], caseVar[3]);

        double forVar = variant.forTask(8);
        System.out.println("For task: " + forVar);

        int[] whileVar = variant.whileTask(12);
        System.out.println("While task: ");
        System.out.println("K = " + whileVar[0] + ", Sum = " + whileVar[1]);

        int[] A = {56, 9, 25, 92, 13, 57};
        int[] arrayVar = variant.arrayTask(A);
        System.out.println("Array task: ");
        for (int i = 0; i < arrayVar.length; i++) {
            System.out.print(arrayVar[i] + " ");
        }
        System.out.println();

        int[][] mtrx = {
            {45, 16, 17, 94},
            {21, 19, 73, 32},
            {72, 50, 92, 12}
        };

        int[][] matrixVar = variant.matrixTask(mtrx);
        System.out.println("Matrix task: ");
        for (int i = 0; i < matrixVar.length; i++) {
            for (int j = 0; j < matrixVar[i].length; j++) {
                System.out.print(matrixVar[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Done!!!");
    }
}