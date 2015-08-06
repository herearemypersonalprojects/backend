/**
 * 
 */
package com.idlookid.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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
	public String saveFile(MultipartFile file, Long id) {
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
}
