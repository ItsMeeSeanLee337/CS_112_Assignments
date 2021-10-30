public class convertBin
{
    public static void main(String[] args)
    {

    }

    public int getDecimalValue(ListNode head) 
    {
        int num = head.val;
        while (head.next != null) 
        {
            //operation to convert the binary number into the decimal number
            num = num * 2 + head.next.val;
            head = head.next;
            //go to the next node YOUR CODE HERE
        }
        return num;
    }
}