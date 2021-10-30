import util.ArrayUtil;

/**
* Created by Rene Argento on 26/03/17.
*/
public class DynamicMedianFinding {

    private class DynamicMedianFindingHeap<Key extends Comparable<Key>> {

        private MinPQ<Key> minPriorityQueue;
        private MaxPQ<Key> maxPriorityQueue;

        private int size;

        DynamicMedianFindingHeap() {
            minPriorityQueue = new MaxPQ<>();
            maxPriorityQueue = new MinPQ<>();
            size = 0;
        }

        //O(lg N)
        public void insert(Key key) 
        {
            //YOUR CODE HERE
        }

        //O(1)
        public Key findTheMedian() 
        {
            //YOUR CODE HERE
        }

        //O(lg N)
        public Key deleteMedian() 
        {
            //YOUR CODE HERE
        }
    }

    public static void main(String[] args) {
        DynamicMedianFinding.DynamicMedianFindingHeap<Integer> dynamicMedianFindingHeap = new DynamicMedianFinding().new DynamicMedianFindingHeap<>();

        dynamicMedianFindingHeap.insert(1);
        dynamicMedianFindingHeap.insert(2);
        dynamicMedianFindingHeap.insert(3);
        dynamicMedianFindingHeap.insert(4);
        dynamicMedianFindingHeap.insert(5);
        dynamicMedianFindingHeap.insert(6);
        dynamicMedianFindingHeap.insert(7);

        StdOut.println("Median: " + dynamicMedianFindingHeap.findTheMedian() + " Expected: 4");
        StdOut.println("Delete Median: " + dynamicMedianFindingHeap.deleteMedian() + " Expected: 4");

        //When we have an even number of values, pick the left one
        StdOut.println("Median: " + dynamicMedianFindingHeap.findTheMedian() + " Expected: 3");

        dynamicMedianFindingHeap.deleteMedian();
        dynamicMedianFindingHeap.insert(99);
        dynamicMedianFindingHeap.insert(100);

        StdOut.println("Median: " + dynamicMedianFindingHeap.findTheMedian() + " Expected: 6");
    }

}
 