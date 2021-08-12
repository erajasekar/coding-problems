package com.erajasekar.interview;

public class MinimumDollarBills {

    private static final int [] DOLLAR_BILLS = new int[]{100,50,10,5,1};
    public static void main(String[] args) {

        System.out.println(numberOfBills(679));

    }

    public static int numberOfBills(int amount){
        int total = 0, count = 0;
        int remaining = amount;

        for(int bill : DOLLAR_BILLS){
            count =  remaining / bill;
            total = total + count;
            remaining = remaining % bill;
            System.out.println(bill + " --> " + count);
        }
        return total;
    }
}
