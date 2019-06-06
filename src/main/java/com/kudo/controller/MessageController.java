package com.kudo.controller;

import com.google.common.base.Preconditions;
import com.kudo.dto.SiteDTO;
import com.kudo.entity.Site;
import com.kudo.service.SiteService;
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
    private SiteService siteService;

    @Autowired
    private SiteTransformer siteTransformer;

    @ApiOperation(value="根据ID查询网站配置信息")
    @GetMapping("/{site_id}")
    public ResponseEntity getSiteById(@ApiParam(value = "网站配置ID", required = true)@PathVariable String site_id){
        return ResponseEntity.ok(siteTransformer.toDto(siteService.getSiteById(site_id)));
    }

    @PostMapping
    @ApiOperation(value = "新增网站配置")
    public ResponseEntity addBook(@RequestBody SiteDTO siteDTO) {
        checkSiteDTO(siteDTO);
        Site site = siteService.addSite(siteTransformer.toEntity(siteDTO));
        return ResponseEntity.ok(siteTransformer.toDto(site));
    }

    @PutMapping("/{site_id}")
    @ApiOperation(value = "根据id修改网站配置")
    public ResponseEntity modifyBookInfo(@PathVariable String site_id, @RequestBody SiteDTO siteDTO) {
        Preconditions.checkNotNull(site_id);
        Site site = siteService.modifySite(site_id, siteTransformer.toEntity(siteDTO));
        return ResponseEntity.ok(siteTransformer.toDto(site));
    }


    private void checkSiteDTO(SiteDTO siteDTO) {
        Preconditions.checkNotNull(siteDTO);
        Preconditions.checkNotNull(siteDTO.getTel(), "tel can not be null.");
        Preconditions.checkNotNull(siteDTO.getEmail(), "email can not be null.");
        Preconditions.checkNotNull(siteDTO.getAddress(), "adress can not be null.");
        Preconditions.checkNotNull(siteDTO.getQrcode(), "qrcode can not be null.");
    }
}
