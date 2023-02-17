import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main3 {
	
	static int front = 0;
	static int back = 0;
	static int size = 0;
	static int[] deque = new int[10000];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
 
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			
			switch(s[0]) {
			
				case "push_front" : {
					push_front(Integer.parseInt(s[1]));
					break;
				}
				
				case "push_back" : {
					push_back(Integer.parseInt(s[1]));
					break;
				}
				
				case "pop_front" : {
					sb.append(pop_front()).append('\n');
					break;
				}
				
				case "pop_back" : {
					sb.append(pop_back()).append('\n');
					break;
				}
				
				case "size" : {
					sb.append(size()).append('\n');
					break;
				}
				
				case "empty" : {
					sb.append(empty()).append('\n');
					break;
				}
				
				case "front" : {
					sb.append(front()).append('\n');
					break;
				}
				
				case "back" : {
					sb.append(back()).append('\n');
					break;
				}
			}
			
		}
		System.out.println(sb);
	}
		
	
	static void push_front(int val) {
		deque[front] = val;
		front = (front - 1 + 10000) % 10000;
		size++;
	}
	
	static void push_back(int val) {
		back = (back + 1) % 10000;
		size++;
		deque[back] = val;
	}
	
	static int pop_front() {
		if (size == 0) {
			return -1;
		}
		int ret = deque[(front + 1) % 10000];
		front = (front + 1) % 10000;
		size--;	
		return ret;
	}
	
	static int pop_back() {
		if (size == 0) {
			return -1;
		} 
		int ret = deque[back];
		back = (back - 1 + 10000) % 10000;
		size--;
		return ret;
	}
	
	static int size() {
		return size;
	}
	
	static int empty() {
		if(size == 0) {
			return 1;
		}
		return 0;
	}
	
	static int front() {
		if(size == 0) {
			return -1;
		}
		return deque[(front + 1) % 10000];
	}
	
	static int back() {
		if(size == 0) {
			return -1;
		}
		return deque[back];
	}
}