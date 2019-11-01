package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        int[] bucketNum = new int[oomages.size()];
        int[] bucketCount = new int[M];
        for (int i = 0; i < oomages.size(); i++) {
            bucketNum[i] = (oomages.get(i).hashCode() & 0x7FFFFFFF) % M;
        }
        for (int i = 0; i < M; i++) {
            bucketCount[i] = 0;
            for (int j = 0; j < bucketNum.length; j++)
                if (bucketNum[j] == i)
                    bucketCount[i] = bucketCount[i] + 1;
            if (bucketCount[i] < bucketNum.length / 50 || bucketCount[i] > bucketNum.length / 2.5)
                return false;
        }
        return true;
    }
}
