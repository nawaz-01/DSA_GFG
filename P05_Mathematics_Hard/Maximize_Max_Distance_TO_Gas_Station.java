// We have a horizontal number line. On that number line, we have gas stations
// at positions stations[0], stations[1], ..., stations[n-1], where n is the
// size of the stations array. Now, we add k more gas stations so that d, the
// maximum distance between adjacent gas stations, is minimized. We have to find
// the smallest possible value of d. Find the answer exactly to 2 decimal
// places.
// Note: stations is in a strictly increasing order.

package P05_Mathematics_Hard;

class Solution {
    static double findSmallestMaxDistance(int[] stations, int k) {
        // code here
        int n = stations.length;
        double left = 0.0, right = stations[n - 1] - stations[0];

        while (right - left > 1e-6) {
            double mid = (left + right) / 2.0;
            if (canPlaceStations(stations, n, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return Math.round(right * 100.0) / 100.0;
    }

    private static boolean canPlaceStations(int[] stations, int n, int k, double distance) {
        int count = 0;
        double lastPosition = stations[0];

        for (int i = 1; i < n; i++) {
            while (stations[i] - lastPosition > distance) {
                count++;
                lastPosition += distance;
            }
            lastPosition = stations[i];
        }

        return count <= k;
    }
}