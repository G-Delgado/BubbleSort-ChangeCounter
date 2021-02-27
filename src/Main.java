import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

	public Main() {

	}

	public static void main(String args[]) {
		Main ppal = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ppal.executeProgram(br, bw);
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void executeProgram(BufferedReader br, BufferedWriter bw) {
		double avg = 0;
		try {
			ArrayList<double[]> cases = new ArrayList<double[]>();
			int n = Integer.parseInt(br.readLine());
			for (int c = 0; c < n; c++) {
				String[] first = br.readLine().split(" ");
				double[] numbers = new double[first.length];
				for (int i = 0; i < first.length; i++) {
					numbers[i] = Double.parseDouble(first[i]);
				}
				avg = bubbleSort(numbers.length, numbers);
				//System.out.println(c + " Cambios: " + avg);
				cases.add(numbers);
				bw.write("---------------------------------------\n");
				//bw.write(avg + "-" + Arrays.toString(cases.get(c)) + "\n");
				//avg = truncateDecimal(avg, 2);
				String result = new DecimalFormat("#.##").format(avg) + "-";
				for (int i = 0; i < cases.get(c).length; i++) {
					result += cases.get(c)[i] + " ";
				}
				result += "\n";
				bw.write(result);
				bw.flush();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BigDecimal truncateDecimal(double x, int numberOfDecimals) {
		if (x > 0) {
			return new BigDecimal(String.valueOf(x)).setScale(numberOfDecimals, BigDecimal.ROUND_FLOOR);
		} else {
			return new BigDecimal(String.valueOf(x)).setScale(numberOfDecimals, BigDecimal.ROUND_CEILING);
		}
	}

	public static double bubbleSort(int n, double[] arr) {
		int changes =  1;
		double times = 0;
		double avg = 0;
		for (int i = 0; i < n /*&& /*changes > 0*/ ; i++) {
			changes = 0;
			for (int j = 1; j < (n-i); j++) {
				if (arr[j-1] > arr[j]) {
					double temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					changes++;
				}
			}
			/*System.out.println(Arrays.toString(arr));*/
			times++;
			//System.out.println("Changes: " + changes + " Pasada: " + i);
			if (changes > 0) {
				avg += changes;
			}
			
		}
		times -= 1;
		//System.out.println(" Times: " + times + " Changes: " + avg + "\n Result:" + (avg/times));
		return avg/times;
	}
}
