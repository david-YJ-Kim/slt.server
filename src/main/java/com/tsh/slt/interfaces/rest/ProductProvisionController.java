package com.tsh.slt.interfaces.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/util")
@RequiredArgsConstructor
@Slf4j
public class ProductProvisionController {

//    @Autowired
//    WfsAlarmReportImpl wfsAlarmReport;
//
//    @PostMapping(WorkManMessageList.WFS_ALARM_REPORT)
//    public ApFlowProcessVo executeWfsAlarmReport(@RequestBody WfsAlarmReportIvo wfsAlarmReportIvo,
//                                                 @RequestParam(value = "key") String trackingKey,
//                                                 @RequestParam(value = "scenario") String scenarioType) throws Exception {
//
//
//        String cid = WorkManMessageList.WFS_ALARM_REPORT;
//        ApFlowProcessVo apFlowProcessVo = this.wfsAlarmReport.initialize(cid, trackingKey, scenarioType);
//
//        return this.wfsAlarmReport.execute(apFlowProcessVo, wfsAlarmReportIvo);
//
//    }
}
