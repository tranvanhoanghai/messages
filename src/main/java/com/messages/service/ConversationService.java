package com.messages.service;

import com.messages.entity.Conversations;

public interface ConversationService {
    Conversations checkCvt(Integer user1, Integer user2);
}
