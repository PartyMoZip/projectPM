package com.pm.myapp.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;


@Component
@PropertySource("classpath:AwsCredentials.properties")
@Log4j2
public class AwsUpload {

    @Setter(onMethod_ = {@Autowired})
    private AmazonS3 createConn;

    @Value("${bucket}")
    private String bucket;


    public String fileUpload(MultipartFile multipartFile, String dirName, UUID uuid) throws IOException {

        log.debug("fileUpload({}, {}, {}) invoked.", multipartFile, dirName, uuid);

        ObjectMetadata metadata = new ObjectMetadata();

        metadata.setContentType(MediaType.IMAGE_PNG_VALUE);
        metadata.setContentLength(multipartFile.getSize());

        //폴더명/uuid_원래파일명
        String fileName = dirName + "/" + uuid + "_" + multipartFile.getOriginalFilename();
        log.info("\t+ fileName : {}", fileName);

        createConn.putObject(new PutObjectRequest(bucket, fileName, multipartFile.getInputStream(), metadata));

        return createConn.getUrl(bucket, fileName).toString();

    } // fileUpload


    public void deleteFiles(String[] files) {
        log.debug("deleteFiles({}) invoked.", Arrays.toString(files));

        DeleteObjectsRequest deleteFiles = new DeleteObjectsRequest(bucket).withKeys(files);
        createConn.deleteObjects(deleteFiles);

    } // deleteFiles


} // end class
