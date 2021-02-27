import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String testCases = br.readLine();
			bw.flush();
			int n = Integer.parseInt(testCases);
			String test = "";
			for (int i = 0; i < n; i++) {
				test = br.readLine();
				bw.flush();
				bw.write(test + " Actual one\n");
				bw.write("Times: " + i + "\n");
				String[] arr = test.split(" ");
				bw.write(n + " Cases\n");
				bw.write(Arrays.toString(arr));
				// En menor no me funciona, solo en menor o igual
			}
			/*bw.flush();

			bw.close();
			br.close();*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
