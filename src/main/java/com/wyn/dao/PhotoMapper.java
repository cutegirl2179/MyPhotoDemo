package com.wyn.dao;

import com.wyn.po.Photo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhotoMapper {
    public List<Photo> getphotos();
}
