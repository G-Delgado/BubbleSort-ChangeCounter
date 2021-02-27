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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void executeProgram(BufferedReader br, BufferedWriter bw) {
		double avg = 0;
		String result = "";
		try {
			
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
				//bw.write(avg + "-" + Arrays.toString(cases.get(c)) + "\n");
				//avg = truncateDecimal(avg, 2);

				DecimalFormatSymbols symb = new DecimalFormatSymbols(Locale.ENGLISH);
				symb.setDecimalSeparator('.');
				DecimalFormat df = new DecimalFormat("#.##", symb);
				df.setRoundingMode(RoundingMode.DOWN);
				result += /*new DecimalFormat("#.##").format(avg)*/df.format(avg) + "-";
				for (int i = 0; i < cases.get(c).length; i++) {
					if (i == cases.get(c).length - 1) {
						result += cases.get(c)[i];
					} else {						
						result += cases.get(c)[i] + " ";
					}
				}
				result += "\n";
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
