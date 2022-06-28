package ftn.udd.controller;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ftn.udd.DTO.RequestDTO;
import ftn.udd.lucene.indexing.Indexer;
import ftn.udd.lucene.model.IndexUnit;
import ftn.udd.repository.CVRepository;

@RestController
@RequestMapping(value = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("permitAll()")
public class RequestController {
	
	private static String DATA_DIR_PATH;
	
	@Autowired
	private CVRepository cvRepository;
	
	
	@Autowired
	private Indexer indexer;
	
	static {
		ResourceBundle rb=ResourceBundle.getBundle("application");
		DATA_DIR_PATH=rb.getString("dataDir");
	}
	 
	private File getResourceFilePath(String path) {
	    URL url = this.getClass().getClassLoader().getResource(path);
	    System.out.println(url);
	    File file = null;
	    try {
	        file = new File(url.toURI());
	    } catch (URISyntaxException e) {
	        file = new File(url.getPath());
	    }   
	    return file;
	}
	@PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HttpStatus> createUser(@RequestParam(name = "file1") @Size(min = 1) MultipartFile file1,
            @RequestParam(name = "file2") @Size(min = 1) MultipartFile file2, @RequestPart(name = "user") String user) throws JsonProcessingException, IOException {

     
        RequestDTO r = new ObjectMapper().readValue(user, RequestDTO.class);

    

        List<MultipartFile> multipartFileList = new ArrayList<>();
        multipartFileList.add(file1);
        multipartFileList.add(file2);
        
        System.out.println(DATA_DIR_PATH);
        
		Path path = Paths.get(getResourceFilePath(DATA_DIR_PATH).getAbsolutePath());
		System.out.println(path.toString());
        System.out.println("nensi fata");
        
        for (MultipartFile multipartFile : multipartFileList) {
            //fileList.add(new FileUploader(cvService).uploadCvFile(user, multipartFile));
        	String orgName = multipartFile.getOriginalFilename();
            String filePath = path.toString() + '\\' + orgName;
            File dest = new File(filePath);
            multipartFile.transferTo(dest);
        }
        		
                
	    IndexUnit i = new IndexUnit();
	    i.setIme(r.getIme());
	    i.setPrezime(r.getPrezime());
	    i.setStepen(r.getStepen());
	    i.setFilename(file1.getOriginalFilename());
        cvRepository.save(i);
        return ResponseEntity.ok(HttpStatus.OK);

    }

}
