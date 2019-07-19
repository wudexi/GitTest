import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

public class RandomTest {
	private static int getRandomNumberInRange(int min, int max) {
		
		Random r = new Random();
		return r.ints(min, (max + 1)).findFirst().getAsInt();
 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < 50; i++) {
//			int r = (int)(Math.random()*10d);
//			System.out.print(r);
//			System.out.print("  ");
			
//			s.clear();
			
//			while (s.size()<7) {
//				int r = getRandomNumberInRange(1, 33);
//				s.add(r);
//			}
//			User user = new User();
//			s.stream().sorted(Comparator.naturalOrder());
//			List<Integer> sortedList = s.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			
		
			
//			for (Integer ii : s) {
//				System.out.print(ii);
//				System.out.print(",");
//			}
			
			
//			for (int j = 0; j < 7; j++) {
//				int r = getRandomNumberInRange(1, 33);
//				if()
//				System.out.print(r);
//				System.out.print(",");
//			}
			System.out.println("  ");
			
			//
			
		}

		
		
	}

	
}
