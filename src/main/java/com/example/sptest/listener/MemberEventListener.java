package com.example.sptest.listener;

import com.example.sptest.listener.event.MemberCreateByPhoneNoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

public interface MemberEventListener {

    @Async
    @EventListener(MemberCreateByPhoneNoEvent.class)
    void onMemberCreateByPhoneNoEvent(MemberCreateByPhoneNoEvent event);
}
