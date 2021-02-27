import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
	
	private ArrayList<double[]> cases;

	public Main() {
		cases = new ArrayList<double[]>();
	}

	public static void main(String args[]) {
		Main ppal = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ppal.executeProgram(br, bw);
		try {
			bw.close();
		} catch (IOException e) {
			System.out.println("Couldn't close :c");
			e.printStackTrace();
		}
	}

	public void executeProgram(BufferedReader br, BufferedWriter bw) {
		String result = "";
		try {
			
			int n = Integer.parseInt(br.readLine());
			for (int c = 0; c < n; c++) {
				String[] first = br.readLine().split(" ");
				double[] numbers = new double[first.length];
				for (int i = 0; i < first.length; i++) {
					numbers[i] = Double.parseDouble(first[i]);
				}
				double avg = bubbleSort(numbers.length, numbers);
				cases.add(numbers);
				
				
				DecimalFormatSymbols symb = new DecimalFormatSymbols(Locale.ENGLISH);
				symb.setDecimalSeparator('.');
				DecimalFormat df = new DecimalFormat("#.##", symb);
				df.setMinimumFractionDigits(1);
				df.setRoundingMode(RoundingMode.DOWN);
				
				result += df.format(avg) + "-";
				
				for (int i = 0; i < cases.get(c).length; i++) {
					if (i == cases.get(c).length - 1) {
						result += cases.get(c)[i];
					} else {						
						result += cases.get(c)[i] + " ";
					}
				}
				result += "\n";
			} 
			br.close();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			writeFile(result);
			bw.write("------------------------------------------------------------------------------\n\n");
			bw.write(result);
			bw.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile(String data) {
		PrintWriter pw;
		try {
			pw = new PrintWriter("data/data.txt");
			pw.println(data);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

	public static double bubbleSort(int n, double[] arr) {
		int changes =  1;
		double times = 0;
		double avg = 0;
		for (int i = 0; i < n; i++) {
			changes = 0;
			for (int j = 1; j < (n-i); j++) {
				if (arr[j-1] > arr[j]) {
					double temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					changes++;
				}
			}
			times++;
			if (changes > 0) {
				avg += changes;
			}
			
		}
		times -= 1;
		return avg/times;
	}
}
