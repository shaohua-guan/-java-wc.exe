package wc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/*
 * �������࣬����ʵ�ֳ������蹦��
 */
public class Method {
	String str = null;
	String path = null;
	boolean temp = false;
	//����ֵ�Ķ���
	int textChar = 0;
	int textString = 0;
	int textLine = 0;
	int NullLine = 0;
	int CodeLine = 0;
	int CommentLine = 0;
	//���췽���������˳���Ĺ���ʵ��
	public Method(String name) throws Exception {
		path = name;
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
		BufferedReader br = new BufferedReader(inputStreamReader);
		
		while((str = br.readLine()) != null) {
			textChar += str.length();
			textString += str.split(" ").length;
			textLine++;
			//�жϿ���
			if(str.length() == 0) {
				NullLine++;
			}
			//�����ж�ע����
			str = str.trim();
			if(str.startsWith("/*") && !str.endsWith("*/")) {
				CommentLine++;
				temp = true;
			} else if(temp) {
				CommentLine++;
				if(str.endsWith("*/")) {
					temp = false;
				}
			} else if(str.startsWith("//")) {
				CommentLine++;
			} else if(str.startsWith("/*") && str.endsWith("*/")) {
				CommentLine++;
			}
		}
	
		CodeLine = textLine - NullLine - CommentLine;
		inputStreamReader.close();
	}
	//���ظ���ֵ
	public int getChar() {
		return this.textChar;
	}
	
	public int getString() {
		return this.textString;
	}
	
	public int getLine() {
		return this.textLine;
	}
	
	public int getNullLine() {
		return this.NullLine;
	}
	
	public int getCodeLine() {
		return this.CodeLine;
	}
	
	public int getCommentLine() {
		return this.CommentLine;
	}
}
