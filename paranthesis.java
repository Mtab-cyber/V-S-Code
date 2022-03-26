
import java.util.Stack;

public class paranthesis {
	public static void main(String[] args) {
		String str = "[()]{}{[()()]()}";
		int n = str.length();
		
		Stack<Character> st = new Stack<Character>();
		
		int temp = 0;
		
		for(int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			
			if(ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			}
			
			else {
				if(st.peek() == '(' && ch == ')') {
					st.pop();
				}
				else if(st.peek() == '{' && ch == '}') {
					st.pop();
				}
				else if(st.peek() == '[' && ch == ']') {
					st.pop();
				}
				else {
					temp = 1;
					break;
				}
			}
		}
		
		if(temp == 0 && st.isEmpty()) {
			System.out.println("Balanced");
		}
		else {
			System.out.println("Not Balanced");
		}
	}
}
