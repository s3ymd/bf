import java.io.IOException;


public class MyLang {
	public static void main(String[] args) throws IOException {
		Instructions c = new Instructions();
//		c.define('>', "ptr++;");
//		c.define('<', "ptr--;");
//		c.define('+', "(*ptr)++;");
//		c.define('-', "(*ptr)--;");
//		c.define('.', "putchar(*ptr);");
//		c.define(',', "*ptr=getchar();");
//		c.define('[', "while(*ptr){");
//		c.define(']', "}");
		
//		c.define('>', "next");
//		c.define('<', "back");
//		c.define('+', "plus");
//		c.define('-', "minus");
//		c.define('.', "output");
//		c.define(',', "input");
//		c.define('[', "while");
//		c.define(']', "endwhile");
		
		c.define('>', "前");
		c.define('<', "後");
		c.define('+', "加");
		c.define('-', "減");
		c.define('.', "出");
		c.define(',', "入");
		c.define('[', "繰");
		c.define(']', "戻");
		
		// BF(で書かれたHelloWorld)→俺言語の変換例
		String[] code = c.encode(BF.HELLO);
		for (String s: code) {
			System.out.print(s);
		}
		System.out.println();
		
		// 俺言語→BFの変換例
		String bf = c.decode(code);
		System.out.println(bf);
		
		// HelloWorldを実行
		BF b = new BF();
		b.setProgram(bf);
		b.run();
		
	}
}
