package labs.lab0;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestVariant12 {
	
	@Test(dataProvider = "integerProvider")
    public void integerNumbersTest(int a, int value) {
        assertEquals(new Variant12().integerNumbersTask(a), value);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] {
            { 34, 43 },
            { 746, 647 },
            { 112, 211 },
            {0, 0}
        };
    }

    @Test(expectedExceptions = AssertionError.class)
	public void negativeIntegerTest() {
		new Variant12().integerNumbersTask(-25);
	}

    ///////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int a, int b, int c, boolean boolres) {
        assertEquals(new Variant12().booleanTask(a, b, c), boolres);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] {
            { 10, 23, 7, true },
            { 53, 77, 1, true },
            { 0, 35, 21, false },
            { 5, 44, -91, false },
        };
    }

    ///////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int n1, int n2, int n3, int min) {
        assertEquals(new Variant12().ifTask(n1, n2, n3), min);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] {
            { 5, 23, 67, 5 },
            { 45, 45, 45, 45 },
            { 34, 0, 101, 0 },
            { -77, -6, 122, -77 }
        };
    }

    ///////////////////////////////////

    @Test(dataProvider = "caseProvider")
    public void caseTest(int elementNumber, double value, double[] expected) {
        assertEquals(new Variant12().caseTask(elementNumber, value), expected);
    }

    @DataProvider
    public Object[][] caseProvider() {
        return new Object[][] {
            { 1, 3.5, new double[] {3.5, 7.0, 21.98, 38.485} },
            { 2, 11.67, new double[] {5.835, 11.67, 36.067, 107.92} },
            { 3, 56, new double[] {8.9, 17.8, 56.0, 249.5} },
            { 4, 14.8, new double[] {2.18, 4.36, 13.8, 14.8} }
        };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void invalidCaseElementNumberTest() {
        new Variant12().caseTask(5, 45.7);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void invalidCaseValueTest() {
        new Variant12().caseTask(1, -5.74);
    }

    ///////////////////////////////////

	@Test(dataProvider = "forProvider")
    public void forTest(int n, double expected) {
        assertEquals(new Variant12().forTask(n), expected);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] {
            { 3, 1.443 }, // 1.1 * 1.2 * 1.3 = 1.716
            { 5, 3.6006}
        };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void nullForTest() {
        new Variant12().forTask(0);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeForTest() {
        new Variant12().forTask(-1);
    }

    ///////////////////////////////////

	@Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
        public void negativeWhileTest(int N) {
            new Variant12().whileTask(N);
        }

        @DataProvider
        public Object[][] negativeWhileProvider() {
            return new Object[][] {
                { 0 }, 
                { -1 }
        };
    }  

    @Test(dataProvider = "whileProvider")
    public void whileTaskTest(int N, int K, int sum) {
        assertEquals(new Variant12().whileTask(N), new int[]{K, sum});
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] {
            { 12, 4, 10 },
            { 20, 5, 15 },
            { 23, 6, 21 }
        };
    }

    ///////////////////////////////////

    @Test(dataProvider = "arrayProvider")
    public void arrayTaskTest(int[] array, int[] value) {
        assertEquals(new Variant12().arrayTask(array), value);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] {
            { new int[]{1, 2, 3, 4}, new int[]{1, 3} },
            { new int[]{52, 66, 73, 40, 14, 29}, new int[]{52, 73, 14} },
        };
    }
    
    ///////////////////////////////////
	
	@Test(dataProvider = "matrixProvider")
	public void matrixTaskTest(int[][] input, int[][] output) {
		assertEquals(new Variant12().matrixTask(input), output);
	}

	@DataProvider
	public Object[][] matrixProvider() {
		int[][] input = {{2, 3, 6, 9, -9},
				        {34, 98, -9, 2, 1},
				         {-4, 2, 1, 6, 1},
				         {-98, 8, 1, 5, 3}};
		
		int[][] output = {{2, 8, 6, 5, -9},
				          {-4, 2, -9, 6, 1},
				          {34, 98, 1, 2, 1},
				          {-98, 3, 1, 9, 3}};
		
		return new Object[][] { {input, output}};
		
	}
}