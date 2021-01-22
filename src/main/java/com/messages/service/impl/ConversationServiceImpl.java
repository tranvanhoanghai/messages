package com.messages.service.impl;

import com.messages.entity.Conversations;
import com.messages.repository.ConversationRepository;
import com.messages.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversationServiceImpl implements ConversationService
{
    @Autowired //inject bean
    private ConversationRepository conversationRepository;

    @Override
    public Conversations checkCvt(Integer user1, Integer user2) {
        return conversationRepository.checkConvt(user1, user2);
    }
}
