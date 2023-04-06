import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class ListNode {
	Object data;
	ListNode link;
	int type;

	ListNode() {
		data = null;
		link = null;
	}

	ListNode(Object data) {
		this.data = data;
		link = null;
	}
}

class ListQueue {
	public ListNode front;
	public ListNode rear;
	public int count;

	public boolean isEmpty() {
		return (count == 0);
	}

	public void enqueue(Object x, int type) {
		ListNode newNode = new ListNode(x);
		newNode.type = type;
		newNode.link = null;
		if (count == 0)
			front = rear = newNode;
		else {
			rear.link = newNode;
			rear = newNode;
		}
		count++;
	}

	public Object dequeue() {
		if (count == 0)
			return null;
		else {
			Object temp = front.data;
			front = front.link;
			if (front == null)
				rear = null;
			count--;
			return temp;
		}
	}
}

class ListStack implements Stack {
	public ListNode top;

	public boolean isEmpty() {
		return (top == null);
	}

	public void push(Object x, int type) {
		ListNode newNode = new ListNode(x);
		newNode.link = top;
		newNode.type = type;
		top = newNode;
	}

	public Object pop() {
		if (isEmpty())
			return null;
		else {
			Object temp = top.data;
			delete();
			return temp;
		}
	}

	public void delete() {
		if (isEmpty())
			return;
		else
			top = top.link;
	}

	public Object peek() {
		if (isEmpty())
			return null;
		else
			return top.data;
	}

	public int whatType() {
		return top.type;
	}

}

interface Stack {
	boolean isEmpty();
	void push(Object x, int type);
	Object pop();
	void delete();
	Object peek();
}

public class Main {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println(new Main().solution(br.readLine()));
		} catch (Exception e) {
			System.out.println("ROCK");
		}
	}

	public String solution(String str) {
		if (str.contains("()"))
			throw new RuntimeException();

		ListStack st = new ListStack();
		ListNode pointer = postfix(str).front; 

		while (pointer != null) {
			if (pointer.type == 5) {
				st.push(pointer.data, pointer.type);
				pointer = pointer.link;
			} else {
				BigInteger result = BigInteger.ZERO;
				BigInteger operand2 = new BigInteger(String.valueOf(st.pop()));
				BigInteger operand1 = new BigInteger(String.valueOf(st.pop()));

				if (pointer.data.toString().equals("+"))
					result = operand1.add(operand2);
				else if (pointer.data.toString().equals("-"))
					result = operand1.subtract(operand2);
				else if (pointer.data.toString().equals("/"))
					result = operand1.divide(operand2);
				else if (pointer.data.toString().equals("*"))
					result = operand1.multiply(operand2);
				st.push(result.toString(), 5);
				pointer = pointer.link;
			}
		}
		String result = String.valueOf(st.pop());
		if (!st.isEmpty()) {
			throw new NullPointerException();
		}
		return result;
	}

	public ListQueue infix(String str) {
		if (checkType(str.charAt(0)) == 1 || checkType(str.charAt(0)) == 4) {
			return null;
		}
		ListQueue infixQue = new ListQueue();
		for (int i = 0; i < str.length();) {
			if (checkType(str.charAt(i)) == 5) {
				int cnt = 0;
				int k = i;
				while (checkType(str.charAt(i)) == 5) {
					i++;
					cnt++;
					if (i == str.length())
						break;
				}
				String temp = str.substring(k, k + cnt);
				infixQue.enqueue(temp, 5);
			} else if (checkType(str.charAt(i)) != 2) { 
				infixQue.enqueue(str.charAt(i), checkType(str.charAt(i)));
				i++;
			} else 
				i++;
		}
		if (bracketTest(infixQue))
			return infixQue;
		else {
			return null;
		}
	}

	public boolean bracketTest(ListQueue infix) { 
		ListStack bracketStack = new ListStack();
		ListNode pointer = infix.front; 
		while (pointer != null) { 
			if (pointer.type == 3) {
				bracketStack.push(pointer.data, pointer.type);
				pointer = pointer.link;
			} else if (pointer.type == 4) {
				int typeTemp = bracketStack.top.type;
				if (bracketStack.isEmpty())
					return false;
				else if (typeTemp == 3)
					bracketStack.delete();
				else
					return false;
				pointer = pointer.link;
			} else
				pointer = pointer.link;
		}
		if (bracketStack.isEmpty())
			return true;
		else
			return false;
	}

	public int checkType(char ch) {
		if (ch == '+' || ch == '-')
			return 1;
		else if (ch == '/' || ch == '*')
			return 6;
		else if (ch == ' ') 
			return 2;
		else if (ch == '(')
			return 3;
		else if (ch == ')')
			return 4;
		else // 숫자
			return 5;
	}

	public int pis(ListNode token) {
		if (token == null)
			return -1;
		if (token.type == 6) 
			return 9;
		else if (token.type == 1)
			return 8;
		else if (token.type == 3)
			return 3;
		else
			return 0;
	}
	
	public int pie(ListNode token) {
		if (token == null)
			return -1;
		if (token.type == 6)
			return 9;
		else if (token.type == 1)
			return 8;
		else if (token.type == 3) 
			return 12;
		else
			return 0;
	}
	
	public ListQueue postfix(String str) {
		ListQueue infixQue = infix(str);
		ListQueue postfixQue = new ListQueue();
		ListStack st = new ListStack();

		if (infixQue == null)
			return null;

		ListNode pointer = infixQue.front;
		while (pointer != null) {
			if (pointer.type == 5) {
				postfixQue.enqueue(pointer.data, 5);
				pointer = pointer.link;
			} else if (pointer.type == 4) { 
				while (st.whatType() != 3) { 
					postfixQue.enqueue(st.peek(), st.whatType());
					st.delete();
				}
				st.delete();
				pointer = pointer.link;
			} else {
				if (!st.isEmpty()) {
					while (pis(st.top) >= pie(pointer)) {
						postfixQue.enqueue(st.peek(), st.whatType());
						st.delete();
					}
				}
				st.push(pointer.data, pointer.type);
				pointer = pointer.link;
			}
		}
		while (!st.isEmpty()) {
			postfixQue.enqueue(st.peek(), st.whatType());
			st.delete();
		}
		return postfixQue;
	}
}