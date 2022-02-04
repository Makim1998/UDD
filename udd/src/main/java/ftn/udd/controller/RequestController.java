package ftn.udd.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

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

@RestController
@RequestMapping(value = "/request", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("permitAll()")
public class RequestController {
	
	@PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HttpStatus> createUser(@RequestParam(name = "file1") @Size(min = 1) MultipartFile file1,
            @RequestParam(name = "file2") @Size(min = 1) MultipartFile file2, @RequestPart(name = "user") String user) throws JsonProcessingException, IOException {

        

        RequestDTO r = new ObjectMapper().readValue(user, RequestDTO.class);
       

        List<MultipartFile> multipartFileList = new ArrayList<>();
        multipartFileList.add(file1);
        multipartFileList.add(file2);

        List<File> fileList = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFileList) {
            //fileList.add(new FileUploader(cvService).uploadCvFile(user, multipartFile));
        }

        //cvService.saveUser(user, fileList);

        return ResponseEntity.ok(HttpStatus.OK);

    }

}
