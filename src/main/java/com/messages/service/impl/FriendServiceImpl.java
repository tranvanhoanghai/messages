package com.messages.service.impl;

import com.messages.entity.Friend;
import com.messages.repository.FriendRepository;
import com.messages.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired //inject bean
    private FriendRepository friendRepository;

    @Override
    public Friend checkFriends(Integer friend_send, Integer friend_reply) {
        return null;
    }

    @Override
    public Integer countFriend(Integer id) {
        return friendRepository.countFriend(id);
    }

//    @Override
//    public Friend checkFriends(Integer friend_send, Integer friend_reply) {
//        Friend friend = friendRepository.checkFriend(friend_send, friend_reply);
//        if(friend == null){
//            friendRepository.saveFriend(friend_send, friend_reply);
//        }
//        return friend;
//    }
}
