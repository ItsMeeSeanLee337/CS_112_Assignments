import util.ArrayUtil;

public class LinearCertificationSol {

    public static void main(String[] args) 
    {
        Comparable[] minOrientedHeap = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8};
        StdOut.println("Certification 1: " + certification(minOrientedHeap) + " Expected: true");

        Comparable[] notMinOrientedHeap = {0, 0, 1, 2, -1, -5, 99, 6, 7, 8};
        StdOut.println("Certification 2: " + certification(notMinOrientedHeap) + " Expected: false");
    }

    private static boolean certification(Comparable[] pq) 
    {
        boolean returnCert = true;
        for (int i = 1; i < pq.length; i++)  
        {
            if (i * 2 < pq.length && !ArrayUtil.less(pq[i], pq[i * 2]))
            {
                returnCert = false;
            }
            if (i * 2 + 1 < pq.length && !ArrayUtil.less(pq[i], pq[i * 2 +1 ]))
            {
                returnCert = false;
            }
        }
        return returnCert;
    }   
}