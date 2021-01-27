package com.messages.service;

import com.messages.entity.Messengers;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface MessengersService {
    List<Messengers> getAllMessByIdCvt(Integer id); // lấy nội dung tin nhắn từ kênh chat
    void saveMess(Integer cvt_id, Integer user_send, Date time_send, String content); // Lưu nội dung tin nhắn
}
