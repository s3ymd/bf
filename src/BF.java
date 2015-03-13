import java.io.IOException;
public class BF {
	// プログラム
	private int[] program = new int[1000];
	// データ
	private int[] data = new int[1000];
	// インストラクションポインタ
	private int instructionPointer = 0;
	// データポインタ
	private int dataPointer = 0;
	
	// helloworld
	public static final String HELLO = "+++++++++[>++++++++>+++++++++++>+++++<<<-]>.>++.+++++++..+++.>-.------------.<++++++++.--------.+++.------.--------.>+.";
	
	public static void main(String[] args) throws IOException {
		
		BF bf = new BF();
		bf.setProgram(HELLO);
		bf.run();
	}

	private void show() {
		for (int i = 0; i < program.length; i++) {
			if (program[i] == 0) {
				break;
			}
			System.out.printf("%c", program[i]);
		}
		System.out.println();
		for (int i = 0; i < program.length; i++) {
			if (instructionPointer == i) {
				System.out.print("^");
				break;
			} else {
				System.out.print(' ');
			}
		}
		System.out.println();

	}

	public void setProgram(String s) {
		int i = 0;
		for (char c : s.toCharArray()) {
			program[i++] = c;
		}
	}

	public void run() throws IOException {
		while (true) {
			show();
			switch (program[instructionPointer]) {
			case '>':
				dataPointer++;
				break;
			case '<':
				dataPointer--;
				break;
			case '+':
				data[dataPointer]++;
				break;
			case '-':
				data[dataPointer]--;
				break;
			case '.':
				System.out.print((char) data[dataPointer]);
				break;
			case ',':
				data[dataPointer] = System.in.read();
				break;
			case '[':
				if (data[dataPointer] == 0) {
					instructionPointer++;
					for (int level = 1;; instructionPointer++) {
						if (program[instructionPointer] == ']') {
							level--;
							if (level == 0) {
								break;
							}
						} else if (program[instructionPointer] == '[') {
							level++;
						}
					}
				}
				break;
			case ']':
				if (data[dataPointer] != 0) {
					instructionPointer--;
					for (int level = 1;; instructionPointer--) {
						if (program[instructionPointer] == '[') {
							level--;
							if (level == 0) {
								break;
							}
						} else if (program[instructionPointer] == ']') {
							level++;
						}
					}
				}
				break;

			default:
				return;
			}
			instructionPointer++;
		}
	}
}
