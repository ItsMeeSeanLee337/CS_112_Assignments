public class removeAfter
{
	public static void main(String[] args)
	{
        
    }

	private class Node 
	{
		Item item;
		Node next;
	}
	
	private int size;
	private Node first;

	public void removeAfter(Node node) 
	{
		if (first ==  null || node == null) 
		{ 
			//check your conditions YOUR CODE HERE
			return;
		}
		
		Node current;
		
		for(current = first; current != null; current = current.next) 
		{
			if (current.item.equals(node.item)) { //check your condition YOUR CODE HERE
				if (current.next != null) 
				{
					current.next = current.next.next;
					size--;
				}
				break;
			}
		}
	}
}