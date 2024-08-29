package rabbitMq.rabbitMq.service;

import rabbitMq.rabbitMq.dto.MessageDto;

public interface ProducerService {
    void sendMessage(MessageDto messageDto);
}
