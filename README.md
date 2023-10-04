# Spring-Boot-ChatGPT

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/Spring-Boot-ChatGPT.git`
2. Navigate to the folder: `cd Spring-Boot-ChatGPT`
3. Create Your ChatGPT API Key [here](https://platform.openai.com/account/api-keys)
4. Replace `application.properties` with yours.
5. Open your HTTP Client app like POSTMAN

```shell
POST http://localhost:8080/api/v1/searchChatGPT
Content-Type: application/json

{
  "query": "what is Spring Boot?"
}
```