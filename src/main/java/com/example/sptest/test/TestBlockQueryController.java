//package com.example.sptest.test;
//
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/internal/block")
//public class TestBlockQueryController {
//
//    @RequestMapping(name = "/query.json", method = RequestMethod.GET)
//    public Model query(Model model,
//                       @RequestParam(name = "uid") String uid,
//                       @RequestParam(name = "tid") String tid,
//                       @RequestParam(name = "typ", required = false) String typ) {
//        long userId = Long.parseLong(uid);
//        long tuserId = Long.parseLong(tid);
//
//        return model.addAttribute("result", "ok all.");
//    }
//
//}
