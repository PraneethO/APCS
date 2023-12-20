package Projects.RandomFRQs;

public class AP09_3 {
    private int[] rateTable;

    private int getChargingCost(int startHour, int chargeTime) {
        int elapsed = 0;
        int totalNumOfHours = 0;

        while (elapsed < chargeTime) {
            totalNumOfHours += rateTable[startHour];
            startHour++;

            if (startHour == 24) {
                startHour = 0;
            }

            elapsed++;
        }

        return totalNumOfHours;
    }

    public int getChargeStartTime(int chargeTime) {
        int minHour = 0;
        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i <= 23; i++) {
            if (getChargingCost(i, chargeTime) < minimum) {
                minimum = getChargingCost(i, chargeTime);
                minHour = i;
            }
        }

        return minHour;
    }
}
