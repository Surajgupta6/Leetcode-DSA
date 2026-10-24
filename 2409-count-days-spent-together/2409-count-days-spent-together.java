class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDay = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int result = 0;
        int arriveMonth = -1;
        int arriveDay = -1;
        int leaveMonth = -1;
        int leaveDay = -1;
        if (Integer.parseInt(arriveAlice.substring(0, 2)) > Integer.parseInt(arriveBob.substring(0, 2))) {
            arriveMonth = Integer.parseInt(arriveAlice.substring(0, 2));
            arriveDay = Integer.parseInt(arriveAlice.substring(3, 5));
        } else if (Integer.parseInt(arriveAlice.substring(0, 2)) < Integer.parseInt(arriveBob.substring(0, 2))) {
            arriveMonth = Integer.parseInt(arriveBob.substring(0, 2));
            arriveDay = Integer.parseInt(arriveBob.substring(3, 5));
        } else if (Integer.parseInt(arriveAlice.substring(0, 2)) == Integer.parseInt(arriveBob.substring(0, 2))) {
            arriveMonth = Integer.parseInt(arriveAlice.substring(0, 2));
            arriveDay = Math.max(Integer.parseInt(arriveAlice.substring(3, 5)),
                    Integer.parseInt(arriveBob.substring(3, 5)));
        }

        if (Integer.parseInt(leaveAlice.substring(0, 2)) < Integer.parseInt(leaveBob.substring(0, 2))) {
            leaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
            leaveDay = Integer.parseInt(leaveAlice.substring(3, 5));
        } else if (Integer.parseInt(leaveAlice.substring(0, 2)) > Integer.parseInt(leaveBob.substring(0, 2))) {
            leaveMonth = Integer.parseInt(leaveBob.substring(0, 2));
            leaveDay = Integer.parseInt(leaveBob.substring(3, 5));
        } else if (Integer.parseInt(leaveAlice.substring(0, 2)) == Integer.parseInt(leaveBob.substring(0, 2))) {
            leaveMonth = Integer.parseInt(leaveBob.substring(0, 2));
            leaveDay = Math.min(Integer.parseInt(leaveBob.substring(3, 5)),
                    Integer.parseInt(leaveAlice.substring(3, 5)));
        }

        if (arriveMonth > leaveMonth || (arriveMonth == leaveMonth && arriveDay > leaveDay)) {
            return 0;
        }
        if (arriveMonth == leaveMonth) {
            return leaveDay - arriveDay + 1;
        }
        result += monthDay[arriveMonth - 1] - arriveDay + 1;
        for (int i = arriveMonth + 1; i < leaveMonth; i++) {
            result += monthDay[i - 1];
        }
        result += leaveDay;
        return result;
    }
}