// Last updated: 10/22/2025, 12:39:24 AM
class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int literUsed = 0;
        while (mainTank >= 5) {
            int transferNeeded = mainTank / 5;
            int remainingLiter = mainTank % 5 + Math.min(transferNeeded, additionalTank);
            additionalTank -= Math.min(transferNeeded, additionalTank);
            literUsed += (mainTank - mainTank % 5);
            mainTank = remainingLiter;
        }
        return 10 * (mainTank + literUsed);
    }
}