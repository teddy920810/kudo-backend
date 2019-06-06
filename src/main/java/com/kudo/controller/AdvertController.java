package com.kudo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advert")
public class AdvertController {

    private static final Logger log = LoggerFactory.getLogger(AdvertController.class);
}
