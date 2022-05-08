import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Romanos {

	public static void main(String[] args) throws InterruptedException {

		Scanner teclado = new Scanner(System.in);
		String palavra, maiorNumRom = "";
		int maiorValRom = 0;
		ArrayList<String> nRom = new ArrayList<>();

		Map<Character, Integer> valores = new LinkedHashMap<>();
		valores.put('I', 1);
		valores.put('V', 5);
		valores.put('X', 10);
		valores.put('L', 50);
		valores.put('C', 100);
		valores.put('D', 500);
		valores.put('M', 1000);

		palavra = teclado.next().toUpperCase();
		teclado.close();

		// analisar caracteres
		int n = 0;
		for (int i = 0; i < palavra.length(); i++) {

			if (valores.get(palavra.charAt(i)) != null) {

				if (i > 0 && valores.get(palavra.charAt(i - 1)) != null) {

					char c = palavra.charAt(i);

					switch (c) {

					case 'I':

						if (nRom.get(n - 1).length() >= 3 && palavra.charAt(i - 1) == 'I'
								&& palavra.charAt(i - 2) == 'I' && palavra.charAt(i - 3) == 'I') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo I");
							n++;
						} else if (palavra.charAt(i - 1) != 'I' && nRom.get(n - 1).contains(String.valueOf('I'))) {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo I");
							n++;
						} else {
							nRom.set(n - 1, nRom.get(n - 1) + String.valueOf(c));
							System.out.println(nRom.get(n - 1) + " <--- juntou I");
						}

						break;

					case 'V':

						if (nRom.get(n - 1).contains(String.valueOf(c))) {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo V");
							n++;
						} else if (nRom.get(n - 1).length() >= 2
								&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'I') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo V");
							n++;
						} else {
							nRom.set(n - 1, nRom.get(n - 1) + String.valueOf(c));
							System.out.println(nRom.get(n - 1) + " <--- juntou V");
						}

						break;

					case 'X':

						if (nRom.get(n - 1).length() >= 3 && palavra.charAt(i - 1) == 'X'
								&& palavra.charAt(i - 2) == 'X' && palavra.charAt(i - 3) == 'X') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo X");
							n++;
						} else if (nRom.get(n - 1).length() >= 2
								&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'I'
								|| nRom.get(n - 1).contains(String.valueOf('V'))) {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo X");
							n++;
						} else {
							nRom.set(n - 1, nRom.get(n - 1) + String.valueOf(c));
							System.out.println(nRom.get(n - 1) + " <--- juntou X");
						}

						break;

					case 'L':
						if (nRom.get(n - 1).contains(String.valueOf(c)) || palavra.charAt(i - 1) == 'I'
								|| palavra.charAt(i - 1) == 'V') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo L if");
							n++;
						} else if (nRom.get(n - 1).length() >= 2
								&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'I'
								|| nRom.get(n - 1).length() >= 2
										&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'X') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo L ei");
							n++;
						} else {
							nRom.set(n - 1, nRom.get(n - 1) + String.valueOf(c));
							System.out.println(nRom.get(n - 1) + " <--- juntou L");
						}

						break;

					case 'C':

						if (nRom.get(n - 1).length() >= 3 && palavra.charAt(i - 1) == 'C'
								&& palavra.charAt(i - 2) == 'C' && palavra.charAt(i - 3) == 'C'
								|| palavra.charAt(i - 1) == 'I' || palavra.charAt(i - 1) == 'V'
								|| palavra.charAt(i - 1) == 'L') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo C");
							n++;
						} else if (nRom.get(n - 1).length() >= 2
								&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'I'
								|| nRom.get(n - 1).length() >= 2
										&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'X') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo C ei");
							n++;
						} else {
							nRom.set(n - 1, nRom.get(n - 1) + String.valueOf(c));
							System.out.println(nRom.get(n - 1) + " <--- juntou C");
						}

						break;

					case 'D':

						if (nRom.get(n - 1).contains(String.valueOf(c)) || palavra.charAt(i - 1) == 'I'
								|| palavra.charAt(i - 1) == 'V' || palavra.charAt(i - 1) == 'X'
								|| palavra.charAt(i - 1) == 'L') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo D if");
							n++;
						} else if (nRom.get(n - 1).length() >= 2
								&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'X'
								|| nRom.get(n - 1).length() >= 2
										&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'C') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo D ei");
							n++;
						} else {
							nRom.set(n - 1, nRom.get(n - 1) + String.valueOf(c));
							System.out.println(nRom.get(n - 1) + " <--- juntou D");
						}

						break;

					case 'M':

						if (nRom.get(n - 1).length() >= 3 && palavra.charAt(i - 1) == 'M'
								&& palavra.charAt(i - 2) == 'M' && palavra.charAt(i - 3) == 'M' || palavra.charAt(i - 1) == 'I'
								|| palavra.charAt(i - 1) == 'V' || palavra.charAt(i - 1) == 'X'
								|| palavra.charAt(i - 1) == 'L' || palavra.charAt(i - 1) == 'D') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo M if");
							n++;
						} else if (nRom.get(n - 1).length() >= 2
								&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'X'
								|| nRom.get(n - 1).length() >= 2
										&& nRom.get(n - 1).charAt(nRom.get(n - 1).length() - 2) == 'C') {
							nRom.add(new String());
							nRom.set(n, String.valueOf(palavra.charAt(i)));
							System.out.println(nRom.get(n) + " <--- novo M ei");
							n++;
						} else {
							nRom.set(n - 1, nRom.get(n - 1) + String.valueOf(c));
							System.out.println(nRom.get(n - 1) + " <--- juntou M");
						}

					}

				}

				else {

					nRom.add(new String());
					nRom.set(n, String.valueOf(palavra.charAt(i)));
					System.out.println(nRom.get(n) + " <--- novo");
					n++;
				}

				System.out.println(nRom.get(n - 1).length());

			}

		}

		for (int i = 0; i < nRom.size(); i++) {
			System.out.print(" | " + nRom.get(i));
		}

		System.out.println();

		// converter em número

		int[] val = new int[nRom.size()];

		for (int cont = 0; cont < nRom.size(); cont++) {
			for (int i = 0; i < nRom.get(cont).length(); i++) {

				if (i + 1 < nRom.get(cont).length()) {
					if (valores.get(nRom.get(cont).charAt(i)) >= valores.get(nRom.get(cont).charAt(i + 1))) {
						val[cont] += valores.get(nRom.get(cont).charAt(i));
					} else {
						val[cont] -= valores.get(nRom.get(cont).charAt(i));
					}
				} else {
					val[cont] += valores.get(nRom.get(cont).charAt(i));

				}

			}

			// comparar tamanho
			if (val[cont] >= maiorValRom) {
				maiorNumRom = nRom.get(cont);
				maiorValRom = val[cont];
			}

		}

		// selecionar maior valor

		for (int i = 0; i < nRom.size(); i++) {
			System.out.print(" | " + val[i]);
		}

		System.out.println();

		System.out.println("number: " + maiorNumRom + "\nvalue: " + maiorValRom);

	}

}
