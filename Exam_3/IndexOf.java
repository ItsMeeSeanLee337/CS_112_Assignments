public class IndexOf 
{
    public static int indexOf (int key, int[] a) 
    {
        //firstIndex
        int firstIndex = -1;
        int lastIndex = -1;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) 
            {
                if (mid - 1 >= 0 && a[mid - 1] == key) 
                {
                   hi = mid - 1;
                   continue;
                }
                firstIndex = mid;
            }
            else if (a[mid] < key)
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }
        //lastIndex
        lo = 0;
        hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) 
            {
                if (mid + 1 < a.length && a[mid + 1] == key) 
                {
                   lo = mid - 1;
                   continue;
                }
                lastIndex = mid;
            }
            else if (a[mid] < key)
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }
        if (hi != -1 && lo != -1)
        {
            return (lastIndex - firstIndex + 1);
        }
        else
        {
            return -1;
        }
    }
}
