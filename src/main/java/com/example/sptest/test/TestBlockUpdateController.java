package com.example.sptest.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/g")
public class TestBlockUpdateController {

    @RequestMapping(value = "query.json")
    public void query(@RequestParam(name = "uid") String uid, @RequestParam(name = "tid") String tid, @RequestParam(name = "typ", required = false) String typ) {
        long userId = Long.parseLong(uid);
        long tuserId = Long.parseLong(tid);

        //return model.addAttribute("result", "ok all.");
    }

    @GetMapping(value = "update.json")
    public String update(@RequestParam(name = "access_token") String accessToken, @RequestParam(name = "tid") String targetUserId) {
        long targetUserIdLong = Long.parseLong(targetUserId);
        return "ok1";
    }
}
