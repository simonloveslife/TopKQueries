package cse562.buffalo.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVReader;

class Table {
	private String tableName;
	private List<String> attName = new ArrayList<String>();
	private List<String> attValue = new ArrayList<String>();
	private LinkedList<List<String>> valueList = new LinkedList<List<String>>();

	public void setName(String string) {
		tableName = string;
	}

	public void addName(String[] sp) {
		// String sp[]=string.split(",");
		for (int i = 0; i < sp.length; i++) {
			attName.add(sp[i]);
		}
	}

	public void addValue(String[] sp) {
		// String sp[]=string.split(",");
		List<String> attValue1 = new ArrayList<String>();
		for (int i = 0; i < sp.length; i++) {
			attValue1.add(sp[i]);
		}
		valueList.addLast(attValue1);
	}

	public String getTableName() {
		return tableName;
	}

	public int getAttNameIndex(String string) {
		for (int i = 0; i < attName.size(); i++) {
			if (attName.get(i).equals(string))
				return i;
		}
		return -1;
	}

	public LinkedList<List<String>> getValueList() {
		return valueList;
	}

}

public class Main {
	public static void main(String[] args) throws IOException {
		int K, N = 0;
		List<Table> tableList = new ArrayList<Table>();
		// List<Table> table=new ArrayList<Table>();
		if (args.length == 2) {
			System.out.println("Right Input!");
			K = Integer.parseInt(args[0]);
			N = Integer.parseInt(args[1]);
		} else {
			System.out.println("Wrong Input!");
			return;
		}
		int[] vector = new int[N];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		String sp[] = line.split(" ");

		sp[2] = sp[2].substring(1, sp[2].length() - 1);
		String[] condition = sp[2].split(",");

		if (sp[0].equals("init")) {
			String tables[] = sp[1].split(",");
			for (int i = 0; i < tables.length; i++)// every table
			{
				Table myTable = new Table();
				String[] tableName = tables[i].split(".csv");
				// System.out.println(tables[i]);
				// System.out.println(tableName[0]);
				myTable.setName(tableName[0]);
				CSVReader reader = new CSVReader(new FileReader(tables[i]), ',');
				String[] nextLine;
				nextLine = reader.readNext();// import first row to Name
				myTable.addName(nextLine);
				while ((nextLine = reader.readNext()) != null) {
					myTable.addValue(nextLine);
				}
				tableList.add(myTable);
			}
//			for (int j = 0; j < tableList.get(0).getValueList().size(); j++) {
//				System.out.println(tableList.get(0).getValueList().get(j).get(0) + "*"
//						+ tableList.get(0).getValueList().get(j).get(1));
//			}
//			for (int j = 0; j < tableList.get(1).getValueList().size(); j++) {
//				System.out.println(tableList.get(1).getValueList().get(j).get(0) + "*"
//						+ tableList.get(1).getValueList().get(j).get(1));
//			}

			if (sp.length == 3) {
				for (int i = 0; i < condition.length; i++) {
//					System.out.println(condition[i]);
					Join newjoin = new Join();
					newjoin.Join_table(condition[i], tableList);
				}
			}
			System.out.println("READ SUCCESS");
			// for (int i = 0; i < tableList.get(0).getValueList().size(); i++)
			// {
			for (int j = 0; j < tableList.get(0).getValueList().size(); j++) {
				System.out.println(tableList.get(0).getValueList().get(j).get(0) + "*"
						+ tableList.get(0).getValueList().get(j).get(1));
			}
			for (int j = 0; j < tableList.get(1).getValueList().size(); j++) {
				System.out.println(tableList.get(1).getValueList().get(j).get(0) + "*"
						+ tableList.get(1).getValueList().get(j).get(1));
			}
			for (int j = 0; j < tableList.get(2).getValueList().size(); j++) {
				System.out.println(tableList.get(2).getValueList().get(j).get(0) + "*"
						+ tableList.get(2).getValueList().get(j).get(1));
			}
			
			// System.out.print("\n");
			// }
		} else {
			System.out.println("Command ERROR.");
			return;
		}
		BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
		String line_vector = in1.readLine();
		String sp_vector[] = line_vector.split(" ");
		if (sp_vector.length == N + 1 && (sp_vector[0].equals("run1") || sp_vector[0].equals("run2"))) {
			for (int i = 1; i < sp_vector.length; i++) {
				vector[i - 1] = Integer.parseInt(sp_vector[i]);
				// System.out.println(vector[i-1]);
			}
		} else {
			System.out.println("Vector do NOT match!");
			return;
		}
	}
}
