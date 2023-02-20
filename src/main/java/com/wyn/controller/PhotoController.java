package com.wyn.controller;

import com.wyn.po.Photo;
import com.wyn.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;
    @RequestMapping("/getphoto")
    public String getphoto(HttpServletRequest request){
        List<Photo> list = photoService.getphotos();
        request.setAttribute("list", list);
        return "index";
    }
}
