public class 860_Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count5++; 
            }else if (bills[i] == 10) {
                if (count5 > 0) {
                    count5--;
                    count10++;
                } else {
                    return false;
                }
            } else {
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                    count20++;
                } else if (count10 == 0 && count5 >= 3) {
                    count5 -= 3;
                    count20++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
