import java.util.ArrayList;
import java.util.List;


public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List ls = new ArrayList();
	//	Fill(ls);
		ls.add(1);
		ls.add(2);
		ls.add(2);
		ls.add(2);
		ls.add(2);
		ls.add(33);
		for (int i = 0; i < ls.size(); i++) {
			
			if((Integer)(ls.get(i))>20){
				ls.remove(i);
			}
		}
		
		System.out.println(ls.toString());
	}

}
