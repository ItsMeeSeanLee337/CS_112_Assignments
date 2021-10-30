public class test 
{
    public static void main(String[] args) 
    {
        String s = "Wor!!!ld";
        System.out.println(getKeyword(s));
    }
	public static String getKeyword(String word) {
		word = word.toLowerCase();
		word = word.replaceAll("[.,?:;!]*$", "");
		if (word.matches("^[a-zA-Z0-9]*$"))
		{
			return word;
		}
		else
		{
			return null;
		}
	}
}
