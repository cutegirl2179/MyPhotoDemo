package com.wyn.service.Impl;

import com.wyn.dao.PhotoMapper;
import com.wyn.po.Photo;
import com.wyn.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoMapper photoMapper;
    public List<Photo> getphotos() {
        return photoMapper.getphotos();
    }
}
