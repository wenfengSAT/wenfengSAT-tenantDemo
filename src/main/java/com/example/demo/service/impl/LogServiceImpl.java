package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Log;
import com.example.demo.mapper.LogMapper;
import com.example.demo.service.LogService;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
