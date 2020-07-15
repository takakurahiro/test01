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
		a.put("千葉", 0);
		a.put("西千葉", 1);
		a.put("稲毛", 2);
		a.put("新検見川", 3);
		a.put("幕張", 4);
		a.put("幕張本郷", 5);
		a.put("津田沼", 6);
		a.put("西船橋", 7);
		a.put("船橋", 8);
		a.put("東船橋", 9);
		int b[] = { 200, 200, 160, 160, 160, 160, 180, 180, 180 };
		int now = 2, suica = 0;

		while (s != 9999 && iki.equals("9999") != true) {
			out.println("行き先を入力してください");
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
					out.println("入力に誤りがあります");
				}
				out.println("料金は" + ryoukin + "円です");
				if (suica >= ryoukin) {
					suica = suica - ryoukin;
				} else {
					now=reset;
					out.println("料金が足りません、チャージ金額を入力してください");
					out.println("1,1000円 2,2000円 3,3000円 4,5000円 5,10000円");
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
						out.println("入力に誤りがあります");
					}
				}
				out.println("suicaの残高は"+suica+"円です");
			} catch (Exception e) {
				out.println("エラー発生");
			}
		}
	}

}
