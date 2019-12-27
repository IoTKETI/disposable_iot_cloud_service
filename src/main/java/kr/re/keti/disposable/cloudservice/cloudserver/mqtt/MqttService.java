package kr.re.keti.disposable.cloudservice.cloudserver.mqtt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.re.keti.disposable.cloudservice.cloudserver.http.MicroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Transactional
@Slf4j
public class MqttService {

    private MqttConfig.MyGateway myGateway;
    private ObjectMapper objectMapper;

    public MqttService(MqttConfig.MyGateway myGateway) {
        this.myGateway = myGateway;
    }

    @PostConstruct
    public void init() {
        objectMapper = new ObjectMapper();
    }

    @Async
    public void sentToMicroService(List<MicroService> microServices) {
        String message = "";
        for(MicroService microService : microServices) {
            log.debug("microservice : {}",microService.getId());
            try {
                message =  objectMapper.writeValueAsString(microService);
                System.out.println(message);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            myGateway.sendToMqtt(message);
        }

    }
}
