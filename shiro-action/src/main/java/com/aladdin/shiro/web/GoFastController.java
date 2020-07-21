package com.aladdin.shiro.web;

import com.aladdin.shiro.entity.dto.GoFastDsDto;
import com.google.gson.Gson;
import com.zkr.bxkj.cloud.common.util.GoFastUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author lgc
 */
@Controller
@Slf4j
@RequestMapping("go")
@CrossOrigin
public class GoFastController {
    @Value("${photo.upload.path}")
    private String uploadPath;
    @Value("${photo.delete.path}")
    private String deletePath;

    @GetMapping(value = "index")
    public String upload() {
        return "redirect:/jsp/upload.jsp";
    }


    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam(value = "myFile") MultipartFile file) throws IOException {
        String uploadResp = GoFastUtil.upload(file, uploadPath, "product");
        Gson gson = new Gson();
        GoFastDsDto goFastDsDto = gson.fromJson(uploadResp, GoFastDsDto.class);
        String url = goFastDsDto.getUrl();
        HashMap<String, Object> stringStringHashMap = new HashMap<>(16);
        stringStringHashMap.put("data", new String[]{url});
        stringStringHashMap.put("errno",0);
        return  gson.toJson(stringStringHashMap);
    }

    @GetMapping("delete")
    @ResponseBody
    public String delete(@RequestParam(value = "md5") String md5, String path) {
        return GoFastUtil.deleteImage(md5, deletePath, path);
    }

}
