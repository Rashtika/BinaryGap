import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int solution(int N) {
        ArrayList<Integer> allRemainders = new ArrayList<>();

        int number = N;
        int remainder = 0;
        while (number > 0) {
            remainder = number%2;
            number /= 2;
            allRemainders.add(remainder);
        }

        if (Collections.frequency(allRemainders, allRemainders.get(0)) == allRemainders.size()) {
            return 0;
        }

        Integer[] BinaryRep = new Integer[allRemainders.size()];
        BinaryRep = allRemainders.toArray(BinaryRep);

        ArrayList<Integer> counting = new ArrayList<>();

        int count;
        for (int i=0; i<BinaryRep.length-1; i+=count+1) {
            count = 0;
            if (BinaryRep[i] == 1) {
                if (BinaryRep[i+1] != 1) {
                    for (int j=i+1; j<BinaryRep.length; j++) {
                        if (BinaryRep[j] == 0) {
                            count++;
                        } else if ((BinaryRep[j] == 1) && (count>0)) {
                            counting.add(count);
                            break;
                        }

                    }
                }
            }
            counting.add(count);

        }


//        int binaryRep = 0;
//        StringBuilder sb = new StringBuilder();
//        for (int i=allRemainders.size()-1; i>=0;i--) {
//            sb.append(allRemainders.get(i));
//        }
//       for (int i=0; i<allRemainders.size(); i++) {
//           binaryRep += allRemainders.get(i)*((int)Math.pow(10, i));
//        }

        return Collections.max(counting);
    }
}
