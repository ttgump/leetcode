/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0) return -1;
        for(int i = 0; i < gas.length; i++) {
            if(canTravel(i, gas, cost)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean canTravel(int gasStation, int[] gas, int[] cost) {
        int i = gasStation;
        if(gas[i] < cost[i]) return false;
        int totalGas = gas[i] - cost[i];
        while(true) {
            i++;
            if(i > gas.length - 1) i = i % gas.length;
            if(i == gasStation) break;
            totalGas += gas[i] - cost[i];
            if(totalGas < 0) return false;
        }
        return true;
    }
}