package com.example.springboot_study.service;


import com.example.springboot_study.dto.WritingSuggestionRequest;
import com.example.springboot_study.dto.WritingSuggestionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class WritingAssistantService {

    private final ChatClient chatClient;
    private final PromptTemplate template;

    private final BeanOutputConverter<WritingSuggestionResponse> outputConverter = new BeanOutputConverter<>(WritingSuggestionResponse.class);

    public WritingAssistantService (
            ChatClient.Builder chatClientBuilder,
            @Value("classpath:prompts/writing-assistant.st") Resource promptResource) {
        this.chatClient = chatClientBuilder.build();
        this.template = new PromptTemplate(promptResource);
    }

    public WritingSuggestionResponse getWritingAssist(WritingSuggestionRequest request) {
        String prompt = template.create(request.toMap(outputConverter.getFormat())).getContents();

        String response = chatClient.prompt().user(prompt).call().content();

        return outputConverter.convert(response);
    }
}