package com.highway.iso.batch.file;


import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.File;
import java.util.Date;

@Getter
@EqualsAndHashCode
public class ISOFileName {

    private static final String FILE_DATE_FORMAT ="yyyyMMdd";
    private static  final  String FILE_NAME_SEPARATOR ="_";
    private static  final String FILE_SEQUENCE_FORMAT="%05d";
    private File directory;
    private String jobName;
    private  String stepName;
    private Date jobDate;

    private long jobId;
    private int sequenceNo;
    private String version;

    private String fileFormat;
    private String dateFormat;
    private  String delimiter;

    public ISOFileName(String jobName, String stepName, Date jobDate) {
        this.jobName = jobName;
        this.stepName = stepName;
        this.jobDate = jobDate;
    }

    @NotNull
    private  static  String formatName(String value){
        return  value.trim().replaceAll("\\s+","").toLowerCase();
    }
    private static  boolean isNullOrBlank(String value){
        return value==null || value.trim().length()==0;
    }

    public ISOFileName directory(File directory) {
        if(directory==null || !directory.exists()){
            throw  new IllegalArgumentException("Directory is nul or exists");
        }
        this.directory = directory;
        return this;
    }

    public ISOFileName jobId(long jobId){
        this.jobId =jobId;
        return  this;
    }
    public ISOFileName fileFormat(String fileFormat){
        if(isNullOrBlank(fileFormat)){
            throw new IllegalArgumentException("File Format is empty or blank");
        }
        this.fileFormat = fileFormat;
        return  this;
    }
    public ISOFileName delimiter(String delimiter){
        if(isNullOrBlank(delimiter)){
            throw  new IllegalArgumentException("Delimiter is empty or blank");
        }
        this.delimiter  = delimiter;
        return  this;
    }
    public ISOFileName sequence(int sequenceNo){
        this.sequenceNo =  sequenceNo;
        return  this;
    }
    public ISOFileName version(String version){
        this.version = version;
        return  this;
    }



}
