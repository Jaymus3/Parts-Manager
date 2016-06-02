package org.zaleus3.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
	public static String[] parts = new String[100];
	static char[] chars;
	static int i = 0;
	static boolean foundexact;
	static boolean foundmoney;
	public static int smallest;
	static String[] money = new String[100];
	public static void AssembleIndex() throws IOException
	{
		String line;
		File invenindex = new File("/Users/sturtevantauto/Documents/workspace/InventoryIndex.txt");
			BufferedReader reader = new BufferedReader(new FileReader(invenindex));
			while ((line = reader.readLine()) != null)
			{
				parts[i] = line;
				i++;
		    }
			reader.close();
	}
	public static void RawTextParse(File file, int type, String splitparts) throws IOException  //Type 1 is local, type 2 is EDEN
	{
		int k = 0;
		int failstack = 0;
		String line;
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null)
			{
				if(type == 1)
				{
					chars = line.toCharArray();
					int j = 0;
					while(j < chars.length)
					{
						if(chars[j] == 'E'  && chars[(j-1)] != '-'  && chars[(j + 1)] == 'X' && chars[(j + 2)]  == 'A')
						{
							foundexact = true;
							money[k] = "$";
						}
						
						
						if(failstack == 2)
						{
							foundexact = false;
							failstack = 0;
							money[k] = null;
						}
						
						
						if(foundexact)
						{
							if(foundmoney  && chars[j] != '.')
							{
								money[k] = money[k] + chars[j];
							}
							else if (foundmoney && chars[j] == '.')
							{
								foundmoney = false;
								foundexact = false;
								failstack = 0;
								k++;
							}
							
							if(chars[j] == '$' && chars[(j + 1)] != '0')
								foundmoney = true;
							else if (chars[j] == '$' && chars[(j+1)] == '0')
							failstack++;
							
							
						}
						j++;
					}
				}
				i++;
		    }
			reader.close();
			int l = 0;
			smallest = Integer.valueOf(money[l].substring(1));
			while(money[l] != null)
			{
				int q = Integer.valueOf(money[l].substring(1));
				if(smallest > q)
				smallest = Integer.valueOf(money[l].substring(1));
				l++;
			}
			System.out.println("Priced " + splitparts + " at $" + smallest);
	}
	
}
