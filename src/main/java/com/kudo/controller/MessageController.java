package com.kudo.controller;

import com.google.common.base.Preconditions;
import com.kudo.dto.SiteDTO;
import com.kudo.entity.Site;
import com.kudo.service.MessageService;
import com.kudo.service.SiteService;
import com.kudo.transformer.MessageTransformer;
import com.kudo.transformer.SiteTransformer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageTransformer messageTransformer;

    @ApiOperation(value="根据ID查询留言信息")
    @GetMapping("/{message_id}")
    public ResponseEntity getMessageById(@ApiParam(value = "留言ID", required = true)@PathVariable String message_id){
        return ResponseEntity.ok(messageTransformer.toDto(messageService.getMessageById(message_id)));
    }

}
