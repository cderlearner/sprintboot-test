package com.example.sptest.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloController {

    @Autowired(required = false)
    private TestBeanAt testBeanAt = new TestBeanAt(2);

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/json2")
    public String json2() throws MyException2 {
        throw new MyException2("发生错误2");
    }

    @RequestMapping("/json3")
    public void req(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("xxx", "xxx");
        response.setHeader("1", "2");
        System.out.println("eeeee");
    }

    @RequestMapping("/json4")
    public void json4() {
        if (testBeanAt == null) {
            System.out.println("11111111111111");
        } else {
            System.out.println("22222222222222");
            System.out.println(testBeanAt.id);
        }
    }

    @RequestMapping("/bool/test")
    public void test(Model model, @RequestParam(required = false, name = "flag", defaultValue = "0") Boolean flag) {
        System.out.println(flag);
        //return model.addAttribute("flag", "flag");
    }

    @Setter
    @Getter
    static class TestBeanAt {
        public int id = 1;

        public TestBeanAt(){}

        public TestBeanAt(int id) {
            this.id = id;
        }
    }
}