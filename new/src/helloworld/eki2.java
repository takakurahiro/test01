package helloworld;

import java.util.Scanner;
import java.util.HashMap;
import static java.lang.System.*;

public class eki2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(in);
		int s = 0;
		String iki = "";
		HashMap<String, Integer> a = new HashMap<>();
		a.put("��t", 0);
		a.put("����t", 1);
		a.put("���", 2);
		a.put("�V������", 3);
		a.put("����", 4);
		a.put("�����{��", 5);
		a.put("�Óc��", 6);
		a.put("���D��", 7);
		a.put("�D��", 8);
		a.put("���D��", 9);
		int b[] = { 200, 200, 160, 160, 160, 160, 180, 180, 180 };
		int now = 2, suica = 0;

		while (s != 9999 && iki.equals("9999") != true) {
			out.println("�s�������͂��Ă�������");
			try {
				iki = sc.next();
				int ryoukin = 0;
				int reset=now;
				if (a.get(iki) > now) {
					for (; a.get(iki) > now; now++) {
						ryoukin = ryoukin + b[now];
					}
				} else if (a.get(iki) < now) {
					for (; now > a.get(iki); now--) {
						ryoukin = ryoukin + b[now-1];
					}
				} else {
					out.println("���͂Ɍ�肪����܂�");
				}
				out.println("������" + ryoukin + "�~�ł�");
				if (suica >= ryoukin) {
					suica = suica - ryoukin;
				} else {
					now=reset;
					out.println("����������܂���A�`���[�W���z����͂��Ă�������");
					out.println("1,1000�~ 2,2000�~ 3,3000�~ 4,5000�~ 5,10000�~");
					s = sc.nextInt();
					switch (s) {
					case 1:
						suica = suica + 1000;
						break;
					case 2:
						suica = suica + 2000;
						break;
					case 3:
						suica = suica + 3000;
						break;
					case 4:
						suica = suica + 5000;
						break;
					case 5:
						suica = suica + 10000;
						break;
					default:
						out.println("���͂Ɍ�肪����܂�");
					}
				}
				out.println("suica�̎c����"+suica+"�~�ł�");
			} catch (Exception e) {
				out.println("�G���[����");
			}
		}
	}

}
