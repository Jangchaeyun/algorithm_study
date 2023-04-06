import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static String[] friend_list = new String[51];
	public static int friend_num;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		friend_num = scan.nextInt();

		for (int x = 0; x < friend_num; x++) {
			friend_list[x] = scan.next();
		}

		System.out.println(find_friend_num());

		scan.close();
	}

	public static int find_friend_num() {

		int max = 0;

		for (int x = 0; x < friend_num; x++) {

			int sum = 0;

			for (int y = 0; y < friend_num; y++) {

				if (x == y)
					continue;

				char temp = friend_list[x].charAt(y);

				if (temp == 'Y')
					sum++;
				else if (find_two_friend(x, y))
					sum++;
			}

			if (max < sum)
				max = sum;
		}

		return max;
	}

	public static boolean find_two_friend(int base_index,int find_index){
        for(int x=0;x<friend_num;x++){
            char temp_find=friend_list[x].charAt(find_index);

            if(temp_find=='Y'){
                char temp_base=friend_list[base_index].charAt(x);

                if(temp_base=='Y')
                    return true;
            }
        }

        return false;
    }
}