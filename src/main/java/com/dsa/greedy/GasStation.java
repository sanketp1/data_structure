package com.dsa.greedy;

public class GasStation {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0, currentTank = 0, startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int netGas = gas[i] - cost[i];
            totalTank += netGas;
            currentTank += netGas;

            // If current tank becomes negative, move to the next station
            if (currentTank < 0) {
                startIndex = i + 1;
                currentTank = 0;
            }
        }

        // Check if completing the circuit is possible
        return totalTank >= 0 ? startIndex : -1;

    }

}
