package org.zaleus3.main;

import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import org.zaleus3.io.FileParser;
import org.zaleus3.robot.Keyboard;

public class Main {

    public static void main(String... args) throws Exception {
		File xps = new File("/Users/sturtevantauto/Pictures/Car_Pictures/XPS/mypartslist.xps");
		File txt = new File("/Users/sturtevantauto/Pictures/Car_Pictures/XPS/mypartslist.txt");
    	int i = 0;
        Keyboard keyboard = new Keyboard();
        Robot r = new Robot();
    	FileParser.AssembleIndex();
    	r.delay(3000);
    	System.out.println(MouseInfo.getPointerInfo().getLocation());
        r.mouseMove(48, 256);  //Clicks find parts
        r.mousePress(InputEvent.BUTTON1_MASK);
    	r.mouseRelease(InputEvent.BUTTON1_MASK);
    	String[] parts = FileParser.parts;
    	while(parts[i] != null)
    	{
    		if(parts[i].contains("G0") || parts[i].contains("F1"))
    		{
    			i++;
    			continue;
    		}
    		@SuppressWarnings("unused")
			String conditions = null;
    		String[] splitparts = parts[i].split(" ");
    		if(splitparts.length > 1)
    		{
    			if(splitparts[2].equals("SC"))
    			conditions = "SCRATCHES";
    			if(splitparts[2].equals("DE"))
    			conditions = "1 DENT";
    			if(splitparts.length > 3)
    			if(splitparts[2].equals("SC") && splitparts[3].equals("DE"))
    			{
    			conditions = "SCRATCHES + 1 DENT";
    			}
    			//System.out.println(conditions);
    		}
    		r.delay(400);
			keyboard.type(splitparts[0] + "\n");
			r.delay(3000);
			//System.out.println(MouseInfo.getPointerInfo().getLocation());
			r.mouseMove(842, 834); //Clicks print
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(900);
			r.mouseMove(987, 527);  //Double clicks XPS printer
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(700);
			r.mouseMove(292, 472);  //Double clicks file name field
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(700);
			keyboard.type("mypartslist\n");
			r.delay(900);
			if(!xps.exists())
			{
				//System.out.println("No XPS file was created for our parts.");
				i++;
				r.mouseMove(1395, 837);
				r.mousePress(InputEvent.BUTTON1_MASK);
				r.mouseRelease(InputEvent.BUTTON1_MASK);
				continue;
			}
			r.mouseMove(296, 1136);  //Clicks folder at bottom
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
			r.delay(50);
			r.keyPress(KeyEvent.VK_F5);
			r.keyRelease(KeyEvent.VK_F5);
			r.delay(500);
			keyboard.type("m\n");  //Selects mypartslist file and opens it
			r.delay(800);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_P);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_P);  //Print hotkey
			r.delay(1350);
			keyboard.type("\n");  //Selects the text printer
			r.delay(1100);
			keyboard.type("mypartslist.txt\n");
			r.delay(1800);
			if(!txt.exists())  //Security error trip if the file isn't created so I don't make a mess.
			{
				System.err.println("Something went wrong in the exporting process and we didn't get a text file.  Terminating.");
				System.exit(-1);
			}
			xps.delete();  //Deletes XPS for future
			r.keyPress(KeyEvent.VK_ALT);  //Removes XPS viewer window
			r.keyPress(KeyEvent.VK_F4);
			r.keyRelease(KeyEvent.VK_ALT);
			r.keyRelease(KeyEvent.VK_F4);
			FileParser.RawTextParse(txt, 1, splitparts[0]);
			txt.delete();
			r.mouseMove(1395, 837);  //Clicks search again button
			r.mousePress(InputEvent.BUTTON1_MASK);
			r.mouseRelease(InputEvent.BUTTON1_MASK);
    		i++;
    	}
    }

}
