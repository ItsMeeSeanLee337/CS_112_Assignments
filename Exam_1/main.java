import java.util.Queue;
import java.util.Stack;
import java.util.ArrayDeque;

public class main
{
    public static void main(String[] args)
    {
        Stack<String> myStack = new Stack<String>();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (s.equals(("-")))
            {
                StdOut.print(myStack.pop());
            }
            else
            {
                myStack.push(s);
            }
        }
    }

    public static String foo2(int n)
    {
        Queue<Integer> q = new Queue<Integer>();
        String result = "";
        for (int i = n; i > 0; i = i/2)
        {
            q.enqueue(i % 2);
        }
        while (!q.isEmpty())
        {
            result += q.dequeue();
        }
        return result;
    }

    n = 50
    1: i = 50, [0]
    2: i = 25, [1, 0]
    3: i = 12, [0, 1, 0]
    4: i = 6, {0, 0, 1, 0}
    5: i = 3, [1, 0, 0, 1, 0]
    6: i = 1, [1, 1, 0, 0, 1, 0]

    public string max()
    {
        String max = null;
        for (int i = n; i > 1; i++)
        {
            if (a[n].compareTo(n -1) > 0)
            {
                max = a[n];
            }
        }
    }

    public static int findMin(Node front)
    {
        int minimum = Integer.MAX_VALUE;
        if (front = null)
        {
            return -1;
        }
        else
        {
            while (front != null)
            {
                if (minimum > front.data)
                {
                    minimum = front.data;
                }
                front = front.next;
            }
            return minimum;
        }
    }
    Queue (front) 12   35   30   67   89   11 (back)
    Stack 12 35 30 67 89 11
    Queue (front) 11 89 67 30 35 21 (back)
}