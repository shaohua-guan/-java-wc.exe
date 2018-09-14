package wc;

import java.util.Scanner;
/*
 * 主类，用于调用方法类，实现程序功能
 */
public class WCtest {

	public static void main(String[] args) throws Exception {
		String temp1 = null;
		boolean temp2 = true;
		String name = null;
		//程序功能列表
		System.out.println("*******-c:求文本字符数");
		System.out.println("*******-w:求文本词的个数");
		System.out.println("*******-l:求文本的行数");
		System.out.println("*******-a:求文本注释行，代码行，空行");
		
		while(temp2) {
			System.out.println("请输入文本名：");
			Scanner input1 = new Scanner(System.in);
			System.out.println("请选择你的操作：");
			Scanner input2 = new Scanner(System.in);
			
			name = input1.next();
			temp1 = input2.next();
			
			if(temp1.equals("-c") || temp1.equals("-w") || temp1.equals("-l") || temp1.equals("-a")) {
				temp2 = false;
			} else {
				System.out.println("输入有误，请重新输入：");
				temp2 = true;
			}	
		}
		Method method = new Method(name);
		//控制程序的输出
		switch(temp1) {
		case "-c" : 
			System.out.println("字符数为" + method.getChar());
			break;
		case "-w" :
			System.out.println("词个数为" + method.getString());
			break;
		case "-l" :
			System.out.println("行个数为" + method.getLine());
			break;
		case "-a" :
			System.out.println("空行数为" + method.NullLine + "代码行数为" + method.getCodeLine() + "注释行数为" + method.getCommentLine()
			);
			break;
		default :
			break;
			}
		} 
}