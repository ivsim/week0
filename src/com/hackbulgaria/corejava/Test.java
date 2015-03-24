package com.hackbulgaria.corejava;


public class Test {

    public static void main(String[] args) {
        
        int divider = 2;
        long result = 1;
        
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        
        
        
        while (true) {
        if (check(arr, divider)) {
            division(arr, divider);
            result = result * divider;
            } else {
                divider++;        
            }
        
        if (check1(arr)) {
            break;
            }
        }
        
        

        

        
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        System.out.println(result);
        
    }
    
    public static int[] division(int[] arr, int divider) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divider == 0) {
                arr[i] = arr[i] / divider;
            }
        }
        
        return arr;
    }
    
    public static boolean check1(int[] arr) {
        boolean temp = false;
        int counter = 0;
        for (int i : arr) {
            if (i == 1) {
                counter++;
            }
        }
        
        if (counter == arr.length) {
            temp = true;
        }
        
        return temp;
    }
    
    public static boolean check(int[] arr, int divider) {
        boolean temp = false;
        
        for (int i : arr) {
            if (isPrime(divider) && i % divider == 0) {
                temp = true;
                break;
            }
        }
        
        return temp;
    }

    public static boolean isPrime(int number) {
        boolean primeCheck = true;
        int divider = 2;
        
        int endOfIteration = (int)Math.sqrt(number);
        
        while (primeCheck == true && (divider <= endOfIteration)) {
            if (number % divider == 0) {
                primeCheck = false;
            }
            
            divider ++;
        }
        
        return primeCheck;
    }
      
}
    
    



