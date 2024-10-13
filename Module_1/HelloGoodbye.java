public class HelloGoodbye{
	public static void main(String[] args){
		if (args.length == 2){
			System.out.println("Hello " + args[0] + " and " + args[1] + ".");
			System.out.println("Goodbye " + args[1] + " and " + args[0] + ".");
			//System.out.println("The command line arguments are: ");
			//for (String val : args){
			//	System.out.println(val);
			}
		else {
			System.out.println("No command line arguments given");
		}
	}
}
