package com.tsh.slt.spec;

import com.tsh.slt.spec.common.ApMsgBody;
import com.tsh.slt.spec.common.ApMsgCommonVo;
import lombok.Data;

@Data
public class ProvInstallInfoRepIvo extends ApMsgCommonVo {

    Body body;

    @Data
    public static class Body extends ApMsgBody{

        String version;             // 설치할 버전 정보
        String servicePort;         // 추천 서비스 포트
        String satellitePort;       // 추천 주변 서비스 포트
        String javaOptions;         // JVM 옵션

    }

}
