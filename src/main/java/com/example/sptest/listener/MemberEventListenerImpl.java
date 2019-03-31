package com.example.sptest.listener;

import com.example.sptest.listener.event.MemberCreateByPhoneNoEvent;
import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2019/3/30
 */
@Component
public class MemberEventListenerImpl implements MemberEventListener{
    @Override
    public void onMemberCreateByPhoneNoEvent(MemberCreateByPhoneNoEvent event) {
        System.out.println(event);
        System.out.println(Thread.currentThread().getName());
    }
}
