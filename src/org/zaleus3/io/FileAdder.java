package org.zaleus3.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileAdder {
	
	public static void LogCar(String stock) throws IOException
	{
		File makemodelindex = new File("/Users/sturtevantauto/Documents/workspace/IndexedCars.txt");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(makemodelindex, true)));
		out.println(stock);
		out.close();
	}

}
