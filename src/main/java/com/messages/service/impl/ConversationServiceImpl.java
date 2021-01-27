package com.messages.service.impl;

import com.messages.entity.Conversation;
import com.messages.repository.ConversationRepository;
import com.messages.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {

    @Autowired //inject bean
    private ConversationRepository conversationRepository;

    @Override // check cuộc hội thoại có 2 id user chưa, nếu chưa thì lưu và hiển thị
    public Conversation checkCvt(Integer user1, Integer user2) {
        Conversation conversations = conversationRepository.checkConversation(user1, user2);
//        String friend = friendRepository.checkFriend(user1, user2);
        if(conversations == null){
            conversationRepository.saveConversation(user1, user2);
//            friendRepository.saveFriend(user1, user2);
        }
        return  conversations;
    }
}
