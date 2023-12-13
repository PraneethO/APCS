package Projects.RandomFRQs;

public class AP09_3 {
    private int[] rateTable;

    private int getChargingCost(int startHour, int chargeTime) {
        int counter = 0;
        int total = 0;

        while (counter < chargeTime) {
            total += rateTable[startHour];
            startHour++;

            if (startHour == 24) {
                startHour = 0;
            }

            counter++;
        }

        return total;
    }

    public int getChargeStartTime(int chargeTime) {
        int minimum = getChargingCost(0, chargeTime);
        int minHour = 0;

        for (int i = 0; i < 24; i++) {
            if (getChargingCost(i, chargeTime) < minimum) {
                minimum = getChargingCost(i, chargeTime);
                minHour = i;
            }
        }

        return minHour;

    }
}
