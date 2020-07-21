package com.aladdin.shiro.web;

import com.aladdin.shiro.entity.ao.ArticleData;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lgc
 */
@Controller
@RequestMapping("edit")
@Slf4j
@CrossOrigin
public class EditController {

    @GetMapping("index")
    public String edit() {
        return "redirect:/html/edit.html";
    }

    @PostMapping("pa")
    public String publishArticle(@RequestBody String paData) {
        log.info(paData);
        Gson gson = new Gson();
        //wangEditor 传输的文本 标签都是 ''
        String s = paData.replaceAll("\''", "\'");
        ArticleData articleData = gson.fromJson(s, ArticleData.class);
        String body = articleData.getContent();
        log.info(articleData.toString());
        return "/jsp/login.jsp";
    }
}
