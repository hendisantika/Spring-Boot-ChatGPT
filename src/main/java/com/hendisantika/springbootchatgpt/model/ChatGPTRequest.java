package com.hendisantika.springbootchatgpt.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-chat-gpt
 * User: hendi
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Link : s.id/hendisantika
 * Date: 10/4/2023
 * Time: 7:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
public class ChatGPTRequest {

    private String model = "text-davinci-003";
    private String prompt;
    private int temperature = 1;

    @SerializedName(value = "max_tokens")
    private int maxTokens = 100;
}
