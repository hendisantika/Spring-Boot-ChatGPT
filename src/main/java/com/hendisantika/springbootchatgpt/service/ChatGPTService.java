package com.hendisantika.springbootchatgpt.service;

import com.google.gson.Gson;
import com.hendisantika.springbootchatgpt.model.ChatGPTRequest;
import com.hendisantika.springbootchatgpt.model.ChatGPTResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-chat-gpt
 * User: hendi
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Link : s.id/hendisantika
 * Date: 10/4/2023
 * Time: 7:36 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Slf4j
public class ChatGPTService {

    @Value("${OPEN_AI_URL}")
    private String OPEN_AI_URL;

    @Value("${OPEN_AI_KEY}")
    private String OPEN_AI_KEY;

    public String processSearch(String query) {

        ChatGPTRequest chatGPTRequest = new ChatGPTRequest();
        chatGPTRequest.setPrompt(query);


        String url = OPEN_AI_URL;

        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer " + OPEN_AI_KEY);

        Gson gson = new Gson();

        String body = gson.toJson(chatGPTRequest);

        log.info("body: " + body);

        try {
            final StringEntity entity = new StringEntity(body);
            post.setEntity(entity);

            try (CloseableHttpClient httpClient = HttpClients.custom().build();
                 CloseableHttpResponse response = httpClient.execute(post)) {

                String responseBody = EntityUtils.toString(response.getEntity());

                log.info("responseBody: " + responseBody);

                ChatGPTResponse chatGPTResponse = gson.fromJson(responseBody, ChatGPTResponse.class);

                return chatGPTResponse.getChoices().get(0).getText();
            } catch (Exception e) {
                log.info("Error : " + e.getMessage());
                return "failed";
            }
        } catch (Exception e) {
            return "failed";
        }
    }
}
