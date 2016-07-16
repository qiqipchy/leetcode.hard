import java.util.Stack;

public class Solution {
	// 弹栈是因为计算的时机到了，不能再等了；

	public int calculate(String s) {
		Stack<Integer> sum = new Stack<Integer>();
		Stack<Character> op = new Stack<Character>();
		int i = 0, num = 0, sumPre = 0;
		char ch;
		int length = s.length();
		i = 0;
		while (i < length) {
			num = 0;
			// 如果是空格，则一直走；
			while (i < length && s.charAt(i) == ' ')
				i++;
			if (i == length)
				break;
			ch = s.charAt(i);
			// 如果是数字，处理完就返回；
			if (ch >= '0' && ch <= '9') {

				while (i < length && (ch >= '0' && ch <= '9')) {
					num = num * 10 + ch - '0';
					i++;
					if (i < length)
						ch = s.charAt(i);
				}
				sum.push(num);
				continue;
			}
			handleOp(ch, sum, op);
			// 如果是左括号，弹栈
			i++;

		}
		//System.out.println(sum.toString());
		//System.out.println(op.toString());
		while (op.size() > 0)
			calSingleOP(op.pop(), sum);
		return sum.peek();
	}

	private void handleOp(char ch, Stack<Integer> sum, Stack<Character> op) {
		// TODO Auto-generated method stub
		// 不能先放，最后才能放 的；
		if (op.size() == 0) {
			op.push(ch);
			return;
		}
		switch (ch) {
		case '+':
		case '-':
			while (op.size() > 0 && op.peek() != '(')
				calSingleOP(op.pop(), sum);
			op.push(ch);
			break;
		case '*':
		case '/':
			while (op.size() > 0 && (op.peek() == '*' || op.peek() == '/'))
				calSingleOP(op.pop(), sum);
			op.push(ch);
			break;
		case '(':
			op.push(ch);
			break;
		case ')':
			// 因为加进来了，所以先要弄出去；
			while (op.size() > 0 && op.peek() != '(')
				calSingleOP(op.pop(), sum);
			if (op.size() > 0)
				op.pop();
		}

	}

	public void calSingleOP(char chPeek, Stack<Integer> sum) {
		if (chPeek == '+')
			sum.push(sum.pop() + sum.pop());
		else if (chPeek == '-')
			sum.push(-sum.pop() + sum.pop());
		else if (chPeek == '*')
			sum.push(sum.pop() * sum.pop());
		else if (chPeek == '/') {
			int temp = sum.pop();
			sum.push(sum.pop() / temp);
		}
	}

	public static void main(String[] args) {
		String s = "(1+(4+5/2)-3)+( 6+8 ) ";
		System.out.println(new Solution().calculate(s));
	}
}
