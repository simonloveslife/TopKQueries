package cse562.buffalo.edu;

import java.util.List;

public class Join {
	// private String condition;
	int tbindexleft, attindexleft, attindexright, tbindexright;

	public void Join_table(String string, List<Table> tableList) {
		// TODO Auto-generated method stub
		String sp[] = string.split("=");
		String[] tableName = new String[sp.length];
		String[] tableArr = new String[sp.length];
		for (int i = 0; i < sp.length; i++) {
			String sp1[] = sp[i].split("\\.");
			tableName[i] = sp1[0];
			tableArr[i] = sp1[1];
		}
		for (int i = 0; i < sp.length; i++) {
			if (i != sp.length - 1) {
				tbindexleft = getTableIndex(tableName[i], tableList);
//				System.out.println(tableName[i] + "  " + tbindexleft);
				attindexleft = tableList.get(tbindexleft).getAttNameIndex(tableArr[i]);
//				System.out.println(attindexleft);
//				System.out.println(attindexright);
				for(int j=i+1;j<sp.length;j++){
					tbindexright = getTableIndex(tableName[j], tableList);
//					System.out.println(tableName[i + 1] + "  " + tbindexright);
					attindexright = tableList.get(tbindexright).getAttNameIndex(tableArr[j]);
				delete(tbindexleft,tbindexright, attindexleft, attindexright, tableList);
				}
			}
		}

	}

	public int getTableIndex(String string, List<Table> tableList) {
		for (int i = 0; i < tableList.size(); i++) {
			if (tableList.get(i).getTableName().equals(string)) {
				return i;
			}
		}
		return -1;
	}

	public void delete(int a, int b, int c, int d, List<Table> tableList) {
		int leftsize = tableList.get(a).getValueList().size();
		int rightsize = tableList.get(b).getValueList().size();
		int flag = 0;
		System.out.println(leftsize);
		System.out.println(rightsize);
//		System.out.println(a+"+"+b+"+"+c+"+"+d);
		for (int j = 0; j < tableList.get(0).getValueList().size(); j++) {
		System.out.println(tableList.get(0).getValueList().get(j).get(0) + "*"
				+ tableList.get(0).getValueList().get(j).get(1));
	}
//	for (int j = 0; j < tableList.get(1).getValueList().size(); j++) {
//		System.out.println(tableList.get(1).getValueList().get(j).get(0) + "*"
//				+ tableList.get(1).getValueList().get(j).get(1));
//	}
		for (int i = 0; i < leftsize; i++) {
			for (int j = 0; j < rightsize; j++) {
//				System.out.println(tableList.get(a).getValueList().get(i).get(c));
//				System.out.println(tableList.get(b).getValueList().get(j).get(d));
				if (tableList.get(a).getValueList().get(i).get(c)
						.equals(tableList.get(b).getValueList().get(j).get(d))) {
					flag = 1;
				}
			}
			if (flag == 0) {
				System.out.println("REMOVED***"+tableList.get(a).getValueList().remove(i));
				leftsize--;
				i--;
			} else if (flag == 1) {
				flag = 0;
			}
		}
		leftsize = tableList.get(a).getValueList().size();
		rightsize = tableList.get(b).getValueList().size();

		for (int i = 0; i < rightsize; i++) {
			for (int j = 0; j < leftsize; j++) {
				if (tableList.get(b).getValueList().get(i).get(d)
						.equals(tableList.get(a).getValueList().get(j).get(c))) {
					flag = 1;
				}
			}
			if (flag == 0) {
				System.out.println("REMOVED***"+tableList.get(b).getValueList().remove(i));
				rightsize--;
				i--;
			} else if (flag == 1) {
				flag = 0;
			}
		}
	}
}
