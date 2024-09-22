package com.tsh.slt.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Property 파일을 객체화
 */
@Getter
@Component
public class ApPropertyObject {

    Environment env;
    @Value("${ap.info.group}")
    private String groupName;

//    private InterfaceSolaceSub interfaceSolaceSub;
//
//    private InterfaceSolacePub interfaceSolacePub;




    private static ApPropertyObject instance;

    // Public method to get the Singleton instance
    public static ApPropertyObject createInstance(Environment env) {
        if (instance == null) {
            synchronized (ApPropertyObject.class) {
                // Double-check to ensure only one instance is created
                if (instance == null) {
                    instance = new ApPropertyObject(env);
                }
            }
        }

//        if(instance.clientName == null){
//            instance.clientName = FisCommonUtil.generateClientName(instance.groupName, instance.siteName, instance.envType, instance.processSeq);
//        }
//
//        if(instance.sequenceManager == null){
//            try {
//                instance.sequenceManager = new SequenceManager(instance.groupName, instance.siteName, instance.envType,
//                        instance.seqRulePath, instance.seqRuleName);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }

        return instance;
    }

    public static ApPropertyObject getInstance(){
        return instance;
    }
    public ApPropertyObject(Environment env) {
        this.env = env;
        instance = this;
    }

//    public void setInterfaceSolaceSub(InterfaceSolaceSub interfaceSolaceSub) {
//        this.interfaceSolaceSub = interfaceSolaceSub;
//    }
//
//    public void setInterfaceSolacePub(InterfaceSolacePub interfaceSolacePub) {
//        this.interfaceSolacePub = interfaceSolacePub;
//    }
}
