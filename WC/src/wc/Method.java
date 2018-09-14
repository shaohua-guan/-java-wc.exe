package wc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/*
 * 程序功能类，用于实现程序所需功能
 */
public class Method {
	String str = null;
	String path = null;
	boolean temp = false;
	//返回值的定义
	int textChar = 0;
	int textString = 0;
	int textLine = 0;
	int NullLine = 0;
	int CodeLine = 0;
	int CommentLine = 0;
	//构造方法，包含了程序的功能实现
	public Method(String name) throws Exception {
		path = name;
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
		BufferedReader br = new BufferedReader(inputStreamReader);
		
		while((str = br.readLine()) != null) {
			textChar += str.length();
			textString += str.split(" ").length;
			textLine++;
			//判断空行
			if(str.length() == 0) {
				NullLine++;
			}
			//用于判断注释行
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
	//返回各种值
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
