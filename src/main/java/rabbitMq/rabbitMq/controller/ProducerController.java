package rabbitMq.rabbitMq.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbitMq.rabbitMq.common.response.SingleResponse;
import rabbitMq.rabbitMq.common.service.ResponseService;
import rabbitMq.rabbitMq.dto.MessageDto;
import rabbitMq.rabbitMq.service.ProducerService;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final ResponseService responseService;
    private final ProducerService producerService;


    @PostMapping("/direct")
    public SingleResponse<?> directSendMessage(@RequestBody MessageDto messageDto){
        producerService.directSendMessage(messageDto);
        return responseService.getSingleResponse(200);
    }
    @PostMapping("/fanout")
    public SingleResponse<?> fanoutSendMessage(@RequestBody MessageDto messageDto){
        producerService.fanoutSendMessage(messageDto);
        return responseService.getSingleResponse(200);
    }
    @PostMapping("/headers")
    public SingleResponse<?> headersSendMessage(@RequestBody MessageDto messageDto){
        producerService.headerSendMessage(messageDto);
        return responseService.getSingleResponse(200);
    }
    @PostMapping("/topic")
    public SingleResponse<?> topicSendMessage(@RequestBody MessageDto messageDto){
        producerService.topicSendMessage(messageDto);
        return responseService.getSingleResponse(200);
    }

}
