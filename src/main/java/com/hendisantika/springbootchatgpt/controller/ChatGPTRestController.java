package com.hendisantika.springbootchatgpt.controller;

import com.hendisantika.springbootchatgpt.service.ChatGPTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-chat-gpt
 * User: hendi
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Link : s.id/hendisantika
 * Date: 10/4/2023
 * Time: 7:38 AM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@Slf4j
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ChatGPTRestController {

    private final ChatGPTService chatGPTService;

}
