package algodat.uebung.blatt07;

public class BackTracking {

	private int[] gewichte = { 1, 3, 8, 20 };
	private int gewicht = 0;

	public String Gewichtsverteilung(int ware, int i, String result) {


			int temp = gewicht;
			gewicht += gewichte[i];
			if (gewicht == ware) {
				System.out.println(result + "+" + gewichte[i]);
			} else  if (i < 3){
				Gewichtsverteilung(ware, i + 1, result + "+" + gewichte[i]);
			}
			gewicht = temp;
			if (gewicht == ware) {
				System.out.println(result);
			} else if (i < 3){
				Gewichtsverteilung(ware, i + 1, result);
			}
			gewicht = temp;
			gewicht -= gewichte[i];
			if (gewicht == ware) {
				System.out.println(result + "-" + gewichte[i]);
			} else if (i < 3) {
				Gewichtsverteilung(ware, i + 1, result + "-" + gewichte[i]);
			}


		return "";
	}

	public static void main(String[] args) {
		BackTracking back = new BackTracking();
		back.Gewichtsverteilung(16, 0, "");
	}
}