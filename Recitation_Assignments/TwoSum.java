public class TwoSum{
    public static int[] twoSum(int[] numbers, int target) 
    {
        int[] a = new int[2];
        //write your code here 
        boolean found = false;
        for (int i = 0; i < numbers.length - 1; i++)
        {
            if ((numbers[i] + numbers[i + 1]) == target)
            {
                a[0] = i;
                a[1] = i+1;
                found = true;
            }
        }
        return a;
        //return an integer array of size 2 
    }
    public static void main (String[] args)
    {
        int [] a = {2,7,11,15};
        int [] b = twoSum(a,9);
        for (int i = 0; i < b.length; i++)
        {
            System.out.println(b[i]);
        }
        // should output 1,2
    }

}
