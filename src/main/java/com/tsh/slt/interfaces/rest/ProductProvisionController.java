package com.tsh.slt.interfaces.rest;


import com.tsh.slt.interfaces.util.ApMessageList;
import com.tsh.slt.spec.ProvInstallInfoRepIvo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
@RequestMapping("/provision")
@RequiredArgsConstructor
@Slf4j
public class ProductProvisionController {


    @GetMapping(ApMessageList.PROV_INSTALL_INFO_REQ)
    public ResponseEntity<ProvInstallInfoRepIvo> execute(){
        // TODO DB 조회하여 버전정보 리턴, 현재는 하드코딩

        ProvInstallInfoRepIvo rep = new ProvInstallInfoRepIvo();
        ProvInstallInfoRepIvo.Body body = new ProvInstallInfoRepIvo.Body();
        body.setVersion("1.0.0");
        body.setServicePort("15001");
        body.setSatellitePort("16001");
        rep.setBody(body);

        log.info("Response {}", rep.toString());

        return new ResponseEntity<>(rep, HttpStatus.OK);
    }

    @GetMapping(ApMessageList.PROV_INSTALL_FILE_REQ)
    public ResponseEntity<byte[]> execute(@RequestParam(value = "type") String type) throws Exception {

        try{
            // TODO 테스트 대응, 프로젝트 내부 경로 사용
            Path path = Paths.get(new ClassPathResource("static/stl.server-0.0.1-SNAPSHOT.jar").getURI());
            byte[] fileBytes = Files.readAllBytes(path);

            // 응답 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  // 바이너리 데이터
            headers.setContentDispositionFormData("attachment", "service.jar"); // 다운로드 되는 파일 이름 설정

            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);

        }catch (IOException ioErr){

            ioErr.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
