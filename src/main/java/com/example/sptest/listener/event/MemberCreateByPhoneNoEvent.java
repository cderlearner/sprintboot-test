package com.example.sptest.listener.event;

public class MemberCreateByPhoneNoEvent extends AbstractSimpleEvent<MemberCreateByPhoneNoMessage> {
    public MemberCreateByPhoneNoEvent(Object source, MemberCreateByPhoneNoMessage payload) {
        super(source, payload);
    }
}
