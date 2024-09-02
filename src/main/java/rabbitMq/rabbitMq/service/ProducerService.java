package rabbitMq.rabbitMq.service;

import rabbitMq.rabbitMq.dto.MessageDto;

/**
 * 메시지 생성자의 Exchange 별 서비스 처리
 */

public interface ProducerService {
    // 라우팅 키를 기반으로 메시지를 큐로 라우팅 / 바인딩 키가 메시지의 라우팅 키와 정확히 일치하는 큐로 메시지가 라우팅
    void directSendMessage(MessageDto messageDto);
    // 라우팅 키에 상관 없이 바인딩된 모든 큐로 메시지를 라우팅
    void fanoutSendMessage(MessageDto messageDto);
    // 라우팅 키 대신 헤더 속성 값에 따라 메시지를 큐로 라우팅 헤더 값은 소비자가 지정한 헤더와 일치해야 메시지가 라우팅됨
    void headerSendMessage(MessageDto messageDto);
    /*
     * 와일드 카드 => 한 단어와 비교 수행
     * ex) fruit.banana => fruit.banana.delicious와 일치 fruit.apple.delicious 불일치
     * 해시 => 기호 이후의 모든 라우팅 키와 매칭
     * ex) fruit.# => fruit.banana, fruit.banana.yellow, fruit로 시작하는 모든 라우팅 키와 일치
     *  */
    void topicSendMessage(MessageDto messageDto);
}
