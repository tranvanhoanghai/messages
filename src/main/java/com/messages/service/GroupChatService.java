package com.messages.service;

import com.messages.entity.Group;

import java.util.List;

public interface GroupChatService {

    List<Group> getListGroupChat(Integer userID);
    List<Group> getMessGroupChat(Integer idGroup);
}
