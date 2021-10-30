public class MergeHeaps 
{
    public static int[] mergeHeaps(int[] maxHeap1, int[] maxHeap2) 
    {
        int returnArrayLength = maxHeap1.length + maxHeap2.length - 1;
        int[] returnArray = new int[returnArrayLength];
        for (int i = 1; i < maxHeap1.length; i++)
        {
            returnArray[i] = maxHeap1[i];
        }
        for (int i = 1; i < maxHeap2.length; i++)
        {
            returnArray[i + returnArrayLength] = maxHeap2[i];
        }
        for (int i = returnArrayLength; i > 2; i++)
        {
            if (returnArray[i] < returnArray[i - 1])
            {
                sink(returnArray, returnArrayLength, i)
            }
            if (returnArray[i] > returnArray[i - 1])
            {
                swim(returnArray, returnArrayLength, i)
            }
        }
        return returnArray;
    }    
}
