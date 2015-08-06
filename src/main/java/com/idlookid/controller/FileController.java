/**
 * 
 */
package com.idlookid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.idlookid.service.FileService;

/**
 * @author quocanh
 *
 */
@RestController
public class FileController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
    private final FileService fileService;
    
    @Autowired
    public FileController(final FileService fileService) {
        this.fileService = fileService;
    }	
    
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
    	LOGGER.info("A new multimedia file was uploaded: " + file.getOriginalFilename());
        return fileService.saveFile(file);
    }
}
