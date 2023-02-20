package com.wyn.test;

import com.wyn.po.Photo;
import com.wyn.service.PhotoService;
import org.junit.Test;

import java.util.List;

public class test {
    PhotoService photoService;
    @Test
    public void run1(){
        List<Photo> list=photoService.getphotos();
        for (Photo photo : list) {
            System.out.println(photo);
        }
    }
}
