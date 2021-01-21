package com.messages.service;

import com.messages.entity.Conversations;

public interface IConversationService {
    Conversations checkCvt(Integer user1, Integer user2);
}
