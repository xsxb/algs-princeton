import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord{
	public static void main(String[] args){
	String champion = "";
	String input = "";
	double p = 1.0;
	double q = 1.0;
	
	while (!StdIn.isEmpty()){
		input = StdIn.readString();
		if(StdRandom.bernoulli(p)){
			champion = input;
		}
		q++;
		p = 1/q;
	}
	StdOut.println(champion);
	}
}
