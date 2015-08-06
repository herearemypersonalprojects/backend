/**
 * 
 */
package com.idlookid.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author quocanh
 *
 */
@Service
@Validated
public class FileService {
	/**
	 * Save the file on the disk at the default folder
	 * @param file
	 * @return
	 */
	public String saveFile(MultipartFile file) {
		if (file != null && !file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String name = "/home/quocanh/files/" + file.getOriginalFilename();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
        }		
	}

	/**
	 * Save the file on the disk at the place's folder
	 * @param file
	 * @param id
	 * @return
	 */
	public String saveFile(MultipartFile file, Long id, String prefix) {
		if (file != null && !file.isEmpty()) {			
            try {
            	String path = "/home/quocanh/apps/frontend/images/" + prefix + String.valueOf(id.longValue()) + "/";
            	prepareFolder(path);
                byte[] bytes = file.getBytes();
                String name = path + getFileName(id, file.getOriginalFilename());
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return name;
            } catch (Exception e) {
                return "";
            }
        } else {
            return "";
        }		
	}
	
	/**
	 * Create the place's folder if it does not exist
	 * @param folder
	 */
	public void prepareFolder(String folder) {
		
		File f = new File(folder);
		if (f.exists() && f.isDirectory()) {
		   ;
		} else {
			f.mkdir();
		}
	}
	
	/**
	 * Naming the saved file which is the place's ID + the file's extension
	 * @param id
	 * @param originalFile
	 * @return
	 */
	public String getFileName(Long id, String originalFile) {
		return String.valueOf(id.longValue()) + "." + FilenameUtils.getExtension(originalFile);		
	}
}
