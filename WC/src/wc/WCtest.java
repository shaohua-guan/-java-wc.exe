package wc;

import java.util.Scanner;
/*
 * ���࣬���ڵ��÷����࣬ʵ�ֳ�����
 */
public class WCtest {

	public static void main(String[] args) throws Exception {
		String temp1 = null;
		boolean temp2 = true;
		String name = null;
		//�������б�
		System.out.println("*******-c:���ı��ַ���");
		System.out.println("*******-w:���ı��ʵĸ���");
		System.out.println("*******-l:���ı�������");
		System.out.println("*******-a:���ı�ע���У������У�����");
		
		while(temp2) {
			System.out.println("�������ı�����");
			Scanner input1 = new Scanner(System.in);
			System.out.println("��ѡ����Ĳ�����");
			Scanner input2 = new Scanner(System.in);
			
			name = input1.next();
			temp1 = input2.next();
			
			if(temp1.equals("-c") || temp1.equals("-w") || temp1.equals("-l") || temp1.equals("-a")) {
				temp2 = false;
			} else {
				System.out.println("�����������������룺");
				temp2 = true;
			}	
		}
		Method method = new Method(name);
		//���Ƴ�������
		switch(temp1) {
		case "-c" : 
			System.out.println("�ַ���Ϊ" + method.getChar());
			break;
		case "-w" :
			System.out.println("�ʸ���Ϊ" + method.getString());
			break;
		case "-l" :
			System.out.println("�и���Ϊ" + method.getLine());
			break;
		case "-a" :
			System.out.println("������Ϊ" + method.NullLine + "��������Ϊ" + method.getCodeLine() + "ע������Ϊ" + method.getCommentLine()
			);
			break;
		default :
			break;
			}
		} 
}