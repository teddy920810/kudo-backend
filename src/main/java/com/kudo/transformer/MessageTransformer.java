package com.kudo.transformer;

import com.kudo.dto.MessageDTO;
import com.kudo.dto.SiteDTO;
import com.kudo.entity.Message;
import com.kudo.entity.Site;
import org.springframework.stereotype.Component;


@Component
public class MessageTransformer implements BaseTransformer<MessageDTO, Message> {

    @Override
    public MessageDTO toDto(Message message) {
        MessageDTO messageDTO = new MessageDTO(message.getId(), message.getName(), message.getPhone(), message.getContent());
        return messageDTO;
    }

    @Override
    public Message toEntity(MessageDTO messageDTO) {
        Message message = new Message(messageDTO.getName(), messageDTO.getPhone(), messageDTO.getContent());
        return message;
    }
}

