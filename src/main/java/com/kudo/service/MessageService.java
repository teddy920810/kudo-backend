package com.kudo.service;

import com.kudo.entity.Message;
import com.kudo.entity.Site;
import com.kudo.repository.MessageRepository;
import com.kudo.repository.SiteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private MessageRepository messageRepository;

    public Message addMessage(Message message){
        Message message1 = messageRepository.save(message);
        return message1;
    }

    public Message modifyMessage(String id, Message newMessage){
        Message messageDB = messageRepository.findById(id).get();
        messageDB.modify(newMessage);
        return messageRepository.save(messageDB);
    }

    public Message getMessageById(String id){
        return messageRepository.findById(id).get();
    }
}
