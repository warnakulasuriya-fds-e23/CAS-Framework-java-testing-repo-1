package org.psnbtech;

public class DataFlowTestCases {

    public void testDataFlow() {
        int a = 5; // Define variable 'a'
        int b = a + 10; // 'b' depends on 'a'
        int c = b * 2; // 'c' depends on 'b'
        
        System.out.println("Value of c: " + c); // Use 'c'
    }

    public void funcA(int x){
        System.out.println("x=" + Integer.toString(x));
    }
    
    public void funcB (){
        int b = 10;
        b= b + b;
        funcA(b);
    }
}