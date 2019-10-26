
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] tokens = "Han   Lei 	is".split("\\s+");
		String[] tokens = "Han   Lei 	is".split(" ");
		
		for(String token : tokens)
			System.out.println(token);
	}
}
