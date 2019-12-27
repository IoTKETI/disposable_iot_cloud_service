package kr.re.keti.disposable.cloudservice.cloudserver.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.re.keti.disposable.cloudservice.cloudserver.mqtt.MqttService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cloudServer")
@Slf4j
public class Controller {

    private MqttService mqttService;

    public Controller(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    @PostMapping("/deploy")
    public void deployTaskToMicroServices(@RequestBody Order order) {
        log.debug("'deployTaskToMicroServices' has been called");
        List<MicroService> microServices = order.getMicroServices();

        mqttService.sentToMicroService(microServices);

    }

}
