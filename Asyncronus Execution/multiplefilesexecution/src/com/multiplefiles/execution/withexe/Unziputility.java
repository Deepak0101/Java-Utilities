package com.multiplefiles.execution.withexe;



import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * This utility extracts files and directories of a standard zip file to
 * a destination directory.
 * @author 310204822
 *
 */
public class Unziputility {
	/**
	 * Size of the buffer to read/write data
	 */
	ETLExecution etlExec = new  ETLExecution();
	MainApp uzt = new MainApp();
	private static final int BUFFER_SIZE = 10000;
	/**
	 * Extracts a zip file specified by the zipFilePath to a directory specified by
	 * destDirectory (will be created if does not exists)
	 * @param zipFilePath
	 * @param destDirectory
	 * @throws IOException
	 */
	public void unzip(String zipFilePath, String destDirectory) throws IOException {
	//	System.out.println(" inside zip method");
		File destDir = new File(destDirectory);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath,destDirectory);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
                zipIn.close();
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath,String destDirectory) throws IOException{
    	try{
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        
        while ((read = zipIn.read(bytesIn)) != -1) {
        	
        		 bos.write(bytesIn, 0, read);
        		
        	  
        	}
      //  System.out.println(" inside extarct file");	
        bos.flush();
	     bos.close();
	     etlExec.mulFilesExecution(destDirectory);
    }catch(Exception e){
    	
    	System.out.println("Problem with file  "+ filePath);
    		
    }
    }
    	}
