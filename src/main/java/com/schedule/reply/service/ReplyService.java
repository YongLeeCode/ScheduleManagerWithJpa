package com.schedule.reply.service;

import com.schedule.reply.dto.CreateReplyRequestDto;
import com.schedule.reply.dto.FindReplyResponseDto;
import com.schedule.reply.dto.ReplyResponseDto;
import com.schedule.reply.entity.Reply;
import com.schedule.reply.repository.ReplyRepository;
import com.schedule.schedule.entity.Schedule;
import com.schedule.schedule.repository.ScheduleRepository;
import com.schedule.user.entity.User;
import com.schedule.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : yong
 * @packageName : com.schedule.reply.service
 * @fileName : ReplyService
 * @date : 4/2/25
 * @description :
 */
@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public ReplyResponseDto addReply(CreateReplyRequestDto dto, long scheduleId, long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow();
        Reply reply = new Reply(dto.getContents(), user, schedule);
        Reply savedReply = replyRepository.save(reply);

        return new ReplyResponseDto(
                savedReply.getId(),
                savedReply.getContents(),
                savedReply.getCreatedAt(),
                savedReply.getUpdatedAt(),
                savedReply.getUser().getId(),
                savedReply.getSchedule().getId()
        );
    }

    public List<FindReplyResponseDto> findAllBySchedule(long scheduleId) {
        List<Reply> replies = scheduleRepository.findAllReplyWithSchedule(scheduleId);
        List<FindReplyResponseDto> responseDtos = new ArrayList<>();
        replies.forEach(reply -> responseDtos.add(
                new FindReplyResponseDto(
                    reply.getId(),
                    reply.getContents(),
                    reply.getCreatedAt(),
                    reply.getUpdatedAt(),
                    reply.getUser().getName()
                )
        ));
        return responseDtos;
    }
}
