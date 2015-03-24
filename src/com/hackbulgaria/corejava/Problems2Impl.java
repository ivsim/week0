package com.hackbulgaria.corejava;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        boolean isOdd = true;
        
        if (number % 2 == 0) {
            isOdd = true;
        } else {
            isOdd = false;
        }
        
        return isOdd;
    }

    @Override
    public boolean isPrime(int number) {
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

    @Override
    public int min(int... array) {
        
        Arrays.sort(array);
        
        return array[0];
    }

    @Override
    public int kthMin(int k, int[] array) {

        Arrays.sort(array);
        
        return array[k-1];
    }

    @Override
    public float getAverage(int[] array) {
        
        int sum = 0;
        
        for (int i : array) {
            sum = sum + i;
        }
        
        float average = (float)sum / array.length;
        
        return average;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        int divider = 2;
        long result = 1;
        
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        
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
        
        return result;
    }
    
    public int[] division(int[] arr, int divider) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divider == 0) {
                arr[i] = arr[i] / divider;
            }
        }
        
        return arr;
    }
    
    public boolean check1(int[] arr) {
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
    
    public boolean check(int[] arr, int divider) {
        boolean temp = false;
        
        for (int i : arr) {
            if (isPrime(divider) && i % divider == 0) {
                temp = true;
                break;
            }
        }
        
        return temp;
    }

    @Override
    public long getLargestPalindrome(long N) {  
        long largestPalindrome = 0;
        
        for (long k = N; k > 11; k--) {            
            
            String textNum = Long.toString(k);
            
            StringBuilder reverseTextNum = new StringBuilder();
            
            for (int i = textNum.length() - 1; i >= 0; i--) {
                reverseTextNum.append(textNum.charAt(i));
            }
            
            String test = reverseTextNum.toString();
            
            if (textNum.equals(test)) {
                largestPalindrome = k;
                break;
            }
        }
        
        return largestPalindrome;
        
    }

    @Override
    public int[] histogram(short[][] image) {
        HashMap<Short, Integer> histogramDistribution = new HashMap<Short, Integer>();
        int[] result = new int[256];
        short temp = 0;
        
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                
                temp = image[i][j];
                
                Integer count = histogramDistribution.get(temp);
                
                if (count == null) {
                    count = 0;
                }
                
                histogramDistribution.put(temp, count+1);
                
                result[temp] = histogramDistribution.get(temp);
            }
        }
       
        return result;
    }

    @Override
    public long doubleFac(int n) {
        long output;
        long temp = factorial(n);
        output = factorial(temp);
        return output;
    }
    
    public long factorial(long n) {
        long result = 1;
        while (true) {
            if (n == 1) {
                break;
            }
            result *= n;
            n--;
            
        }
        return result;
    }

    @Override
    public long kthFac(int k, int n) {
        long result = 1;
        while (true) {
            if (n <= 0) {
                break;
            }
            result *= n;
            n -= k;
            
        }
        return result;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        HashMap<Integer, Integer> occurenceCheck = new HashMap<Integer, Integer>();
        int foundNum = 0;
        
        for (int i : array) {
            Integer count = occurenceCheck.get(i);
            
            if (count == null) {
                count = 0;
            }
            
            occurenceCheck.put(i, count+1);
            
            count = occurenceCheck.get(i);
            
            if (!(count % 2 == 0 || count == 1)) {
                foundNum = i;
                break;
            }
        }

        return foundNum;
    }

    @Override
    public long pow(int a, int b) {

        long aLong = a;
        long result = 0;
        long temporary = 1;
        
        if (b == 0) {
            result = temporary * 1;
        } else if (b == 1) {
            result = temporary * aLong;
        } else if (b < 0) {
            System.out.println("Positive integers are needed...");
        }
        
            while (b >= 2) {
                if (b % 2 != 0) {
                    temporary = temporary * aLong;
                    aLong = aLong * aLong;
                    b = (b - 1) / 2;
                } else {                
                    aLong = aLong * aLong;
                    b = b / 2;
                }           
      
            }
            
            result = temporary * aLong;

        return result;
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        long maximalScalarProduct = 0;
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        for (int i = 0; i < a.length; i++) {
            maximalScalarProduct += a[i] * b[i];
        }
        
        return maximalScalarProduct;
    }

    @Override
    public int maxSpan(int[] array) {
        int maxSpanValue = 1;
        
        for (int j = 0; j < array.length; j++) {
            int tempVal = spanValue(array, j);
            if (tempVal > maxSpanValue) {
                maxSpanValue = tempVal;
            }
        }
        
        return maxSpanValue;
    }
    
    public int spanValue(int[] arr, int beginIndex) {
        int spanValue = 1;
        
        for (int i = beginIndex; i < arr.length; i++) {//iterate from certain index to the end of the array...
            if (arr[i] == arr[beginIndex]) {
                spanValue = (i - beginIndex) + 1;
            }
        }
        
        return spanValue;
    }

    @Override
    public boolean canBalance(int[] array) {
        boolean isThereBalance = false;
        
        long leftSum = 0;
        long rightSum = sum(array);
        
        for (int each : array) {
            leftSum += each;
            rightSum -= each;
            
            if (leftSum == rightSum) {
                isThereBalance = true;
                break;
            }
        }       
        
        return isThereBalance;
    }
    
    public long sum(int[] arr) {
        long sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        
        return sum;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        
        int[][] outputMatrix = new int[newHeight][newWidth];
        
        int sizeX = original[0].length / outputMatrix[0].length;
        int sizeY = original.length / outputMatrix.length;

        for (int y = 0; y < outputMatrix.length; y++) {
            for (int x = 0; x < outputMatrix[0].length; x++) {
                outputMatrix[y][x] = getAverage(original, y * sizeY, x * sizeX, sizeY, sizeX);
            }
        }    
        
        print(outputMatrix);
        
        return outputMatrix;
    }
    
    public int getAverage(int[][] original,int indexY, int indexX, int sizeY, int sizeX) {
        int average = 0;
        int sum = 0;
        
        for (int y = indexY; y < sizeY + indexY; y++) {
            for (int x = indexX; x < sizeX + indexX; x++) {
                
                sum = sum + original[y][x];
                
            }
        }
        
        average = sum / (sizeY * sizeX);
        
        return average;
    }
    
    public static void print(int[][] array) {

        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                System.out.printf("| %4d ", array[y][x]);
            }
            
            System.out.println("|");
        }
    }

    @Override
    public String reverseMe(String argument) {
        char temp;
        char[] tempChar = argument.toCharArray();
        
        for (int i = 0; i < tempChar.length / 2; i++) {
            temp = tempChar[tempChar.length - 1 - i];
            tempChar[tempChar.length - 1 - i] = tempChar[i];
            tempChar[i] = temp;
            
        }
        
        String outPut = new String(tempChar);        
        
        return outPut;
    }

    @Override
    public String copyEveryChar(String input, int k) {
        char[] tempChar = new char[k * input.length()];
        
        for (int i = 0; i < input.length(); i++) {
            for (int j = i*k; j < i*k + k; j++) {
                tempChar[j] = input.charAt(i);
            }
 
        }
        
        return new String(tempChar);
    }

    @Override
    public String reverseEveryWord(String arg) {
        StringBuilder outPut = new StringBuilder();
        
        Scanner input = new Scanner(arg);
        input.useDelimiter("[ ]+");
        
        while (input.hasNext()) {
            outPut.append(reverseMe(input.next()) + " ");
        }
        
        input.close();
        
        return outPut.toString().trim();
    }

    @Override
    public boolean isPalindrome(String argument) {
        boolean temp = false;
        
        for (int i = 0; i < argument.length() / 2; i++) {
            temp = argument.substring(i,i+1).equals(argument.substring(argument.length()-1-i,argument.length()-i));
            if (temp == false) {
                break;
            }
        }
        
        return temp;
    }

    @Override
    public boolean isPalindrome(int number) {
        int temp = number;
        int digitCount = 0;
        
        boolean compare = true;
        
        for (int i = 1; temp != 0; i = i * 10) {
            temp /= 10;
            digitCount = i;
        }
        
        temp = number;
        
        while (compare == true && digitCount != 0) {
            int start = temp / digitCount;
            int end = temp % 10;
            compare = (start) == (end);
            temp = (temp - (start * digitCount)) / 10;
            digitCount /= 100;
        }
                
        return compare;
    }

    @Override
    public int getPalindromeLength(String input) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        return (haystack.length() - (haystack.replaceAll(needle, "")).length()) / needle.length();
    }

    @Override
    public String decodeURL(String input) {
        return input.replaceAll("%21", "!").replaceAll("%23", "#").replaceAll("%24", "$").replaceAll("%26", "&").replaceAll("%27", "'")
                .replaceAll("%28", "(").replaceAll("%29", ")").replaceAll("%2A", "*").replaceAll("%2B", "+").replaceAll("%2C", ",").replaceAll("%2F", "/")
                .replaceAll("%3A", ":").replaceAll("%3B", ";").replaceAll("%3D", "=").replaceAll("%3F", "?").replaceAll("%40", "@").replaceAll("%5B", "[")
                .replaceAll("%5D", "]");
    }

    @Override
    public int sumOfNumbers(String input) {
        int sum = 0;
        Scanner inputString = new Scanner(input);
        
        inputString.useDelimiter("[^0-9]+");
        
        while (inputString.hasNext()) {
            sum = sum + Integer.parseInt(inputString.next());
        }
        
        inputString.close();
        
        return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        char[] a1 = A.toCharArray();
        char[] b1 = B.toCharArray();
        
        Arrays.sort(a1);
        Arrays.sort(b1);
        return new String(a1).equals(new String(b1));
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        boolean hasAnagram = false;
        int sizeString = string.length();
        
        for (int i = 0; i < string2.length() - sizeString + 1; i++) {
            hasAnagram = areAnagrams(string2.substring(i, sizeString + i), string);
            if (hasAnagram == true) {
                break;
            }
        }
        
        return hasAnagram;
    }
    
    public File convertToGreyscale(String imgPath) { //pls, add \ char before every \ char...
        BufferedImage img = null;
        File f = null;
        
        try {
            f = new File(imgPath);
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        
        int width = img.getWidth();
        int height = img.getHeight();
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                
                int avg = (r + g + b) / 3;
                
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                
                img.setRGB(x, y, p);
            }
        }
        
        String newImgPath = "C:\\Users\\Ivailo\\Desktop\\img.jpg";
        
        try {
            f = new File(newImgPath);
            ImageIO.write(img, "jpg", f);
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return f;
    }

}
