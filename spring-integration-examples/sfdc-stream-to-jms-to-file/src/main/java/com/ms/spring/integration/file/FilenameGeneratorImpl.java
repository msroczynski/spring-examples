package com.ms.spring.integration.file;

import org.springframework.integration.Message;
import org.springframework.integration.file.FileNameGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FilenameGeneratorImpl implements FileNameGenerator
{
    @Override
    public String generateFileName(Message<?> message) {
        return "sfdc_exp_" + new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss'.msg'").format(new Date());
    }
}
