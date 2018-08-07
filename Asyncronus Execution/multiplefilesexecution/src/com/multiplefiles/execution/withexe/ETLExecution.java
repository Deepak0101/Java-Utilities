package com.multiplefiles.execution.withexe;



import java.io.File;

public class ETLExecution  {
	
	public void mulFilesExecution(String destDirectory) {
		
		String exePath = "C:\\Deepak\\ETL5\\trunk\\src\\logfilediagsw\\bin\\nu\\ETL\\ETL.exe";
		//String exePath = "C:\\Program Files\\Notepad++\\notepad++.exe";
		
		File Destfolder = new File(destDirectory);
		File[] listOfFiles = Destfolder.listFiles();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		    	
		    String inputPath = destDirectory+"\\"+file.getName();
		    System.out.println("inputPath "+ inputPath);
		    File destDataDir = new File(inputPath.substring(0,35));
			if (!destDataDir.exists()) {
				destDataDir.mkdir();
				
			}
		    String tempPath = exePath+" "+inputPath+" "+destDataDir.getAbsolutePath()+"\\data.xml";
		    System.out.println(tempPath);
			try {
		    	Process p = Runtime.getRuntime().exec(tempPath);
		    	p.waitFor();
		    	}catch(Exception e) {
		    		e.printStackTrace();
		    	}
		       
		    	
		    }
		    file.delete();
		}
		
		
		
		/*try {
	    	Process p = Runtime.getRuntime().exec(path);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	        System.out.println(path);*/
	}

}
