package com.kudo.controller.api;

import com.kudo.controller.MessageController;
import com.kudo.dto.MessageDTO;
import com.kudo.dto.SiteDTO;
import com.kudo.entity.Message;
import com.kudo.entity.Site;
import com.kudo.service.MessageService;
import com.kudo.transformer.MessageTransformer;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message")
public class MessageApi {

    private static final Logger log = LoggerFactory.getLogger(MessageApi.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageTransformer messageTransformer;

    @PostMapping
    @ApiOperation(value = "新增留言")
    public ResponseEntity addMessage(@RequestBody MessageDTO messageDTO) {
        MessageDTO.checkMessageDTO(messageDTO);
        Message message = messageService.addMessage(messageTransformer.toEntity(messageDTO));
        return ResponseEntity.ok(messageTransformer.toDto(message));
    }
}
