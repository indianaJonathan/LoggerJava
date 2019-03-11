package br.com.gvt.siebel.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyLogger {

	private static String file = new String();
	
	public void begin(String pedido) {
		String instancia = Thread.currentThread().getStackTrace()[2].getClassName().replaceAll("br.com.gvt.siebel.main.", "");
		
		Date currentTime = new Date();
		String time = new SimpleDateFormat("dd-MM-yyyy").format(currentTime);
		file = "";
		file = "C:\\Kenan\\" + pedido.replace("_OrderPublication.xml", "_" + instancia + "Log_" + time + ".log");
	}
	
	public void line() {		
		String instancia = Thread.currentThread().getStackTrace()[2].getClassName().replaceAll("br.com.gvt.siebel.main.", "");
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		
		Date currentTime = new Date();
		
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
		
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (instancia.length() <=7) {
				bw.write(time + "\t" + instancia + ": " + lineNumber + "\t\tLINE -\t" + "--------------------------------------------------------------------------");
				System.out.println(time + "\t" + instancia + ": " + lineNumber + "\t\tLINE -\t" + "--------------------------------------------------------------------------");
			} else {
				bw.write(time + "\t" + instancia + ": " + lineNumber + "\tLINE -\t" + "--------------------------------------------------------------------------");
				System.out.println(time + "\t" + instancia + ": " + lineNumber + "\tLINE -\t" + "--------------------------------------------------------------------------");
			}
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dLine() {		
		String instancia = Thread.currentThread().getStackTrace()[2].getClassName().replaceAll("br.com.gvt.siebel.main.", "");
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		
		Date currentTime = new Date();
		
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
		
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (instancia.length() <=7) {
				bw.write(time + "\t" + instancia + ": " + lineNumber + "\t\tLINE -\t" + "==========================================================================");
				System.out.println(time + "\t" + instancia + ": " + lineNumber + "\t\tLINE -\t" + "==========================================================================");
			} else {
				bw.write(time + "\t" + instancia + ": " + lineNumber + "\tLINE -\t" + "==========================================================================");
				System.out.println(time + "\t" + instancia + ": " + lineNumber + "\tLINE -\t" + "==========================================================================");
			}
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Object info(Object object) {
		String instancia = Thread.currentThread().getStackTrace()[2].getClassName().replaceAll("br.com.gvt.siebel.main.", "");
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		
		Date currentTime = new Date();
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
		
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (instancia.length() <=7) {
				bw.write(time + "\t" + instancia + ": " + lineNumber + "\t\tINFO -\t" + object);
				System.out.println(time + "\t" + instancia + ": " + lineNumber + "\t\tINFO -\t" + object);
			} else {
				bw.write(time + "\t" + instancia + ": " + lineNumber + "\tINFO -\t" + object);
				System.out.println(time + "\t" + instancia + ": " + lineNumber + "\tINFO -\t" + object);
			}
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return object;
	}
	
	public Object err(Object object) {
		String instancia = Thread.currentThread().getStackTrace()[2].getClassName().replaceAll("br.com.gvt.siebel.main.", "");
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		
		Date currentTime = new Date();
		
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(currentTime);
		
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (instancia.length() <=7) {
				bw.write(time + "\t" + instancia + ": " + lineNumber + "\t\tERRO -\t" + object);
				System.out.print(time + "\t" + instancia + ": " + lineNumber);
				System.err.println("\tERRO -\t" + object);
			} else {
				bw.write(time + "\t" + instancia + ": " + lineNumber + "\tERRO -\t" + object);
				System.out.print(time + "\t" + instancia + ": " + lineNumber);
				System.err.println("\tERRO -\t" + object);
			}
			bw.newLine();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
}