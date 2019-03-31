package com.example.sptest.listener;

import com.example.sptest.listener.event.MemberCreateByPhoneNoEvent;
import org.springframework.stereotype.Component;

/**
 * Author: linjx
 * Date: 2019/3/31
 */
@Component
public class MemberEventListenerImpl2 implements MemberEventListener{
    @Override
    public void onMemberCreateByPhoneNoEvent(MemberCreateByPhoneNoEvent event) {
        System.out.println("2:"+ event);
        System.out.println(Thread.currentThread().getName());
    }
}
