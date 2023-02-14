import java.util.Arrays;
import java.util.Scanner;

public class B2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//키 입력받을 배열 생성
		int[] he = new int[9];
		int[] result = new int[7];
		//키 입력
		for(int i = 0; i < he.length; i++) {
			he[i] = sc.nextInt();
		}
		
		int sumhe = 0;
		for(int i = 0; i < he.length; i++) {
			sumhe += he[i];
		}
		
		for(int i = 0; i < he.length; i++) {
			for(int j = i; j < he.length; j++) {
				if(sumhe - he[i] - he[j] == 100) {
					he[i] = 0;
					he[j] = 0;
				}
				for(int z = 0; z < result.length; z++) {
					if(he[i] != 0 && he[j] != 0) {
						result[z] = he[j];
					}
				}
			}
		}
		
		Arrays.sort(result);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		sc.close();
	}
}
