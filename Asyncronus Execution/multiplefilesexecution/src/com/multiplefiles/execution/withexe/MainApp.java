package com.multiplefiles.execution.withexe;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class MainApp {

	public static void main(String[] args) throws IOException, NullPointerException, ParseException {

		String parent = "C:\\Logs\\unzip\\";
		Unziputility unzipper = new Unziputility();
		String parentPath = "C:\\Logs\\zipped";
		File parentFolder = new File(parentPath);
		File[] folders = parentFolder.listFiles();
	//	ETLExecution etlExec = new ETLExecution();

		System.out.println("in main");

		for (File currentFolder : folders) {
			File[] filesList = currentFolder.listFiles();
			for (File thisFile : filesList) {
				String zipFilePath = thisFile.getAbsolutePath();
				// System.out.println(zipFilePath);
				String destDirectory = parent + currentFolder.getName();
				// System.out.println("destDirectory "+destDirectory);
				try {
					unzipper.unzip(zipFilePath, destDirectory);
					/*
					 * //to avoid processing of dummy file if(thisFile.length()==0){ continue; }
					 */
					// etlExec.mulFilesExecution(destDirectory);
					// thisFile.delete();
					/*
					 * File newFile = new File(zipFilePath); newFile.createNewFile();
					 */
				} catch (IOException e) {
					e.printStackTrace();
				}

				catch (NullPointerException e) {
					e.printStackTrace();
				}

			}
		}

	}
}
