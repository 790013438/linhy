package com.xy.ssm.model;

public class CJobFile {
    private Long file_id;
    private String file_realname;
    private String file_name;
    private Long file_job_id;
    private String file_size;
    private String file_route;
    private String file_type;

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_id(Long file_id) {
        this.file_id = file_id;
    }

    public void setFile_realname(String file_realname) {
        this.file_realname = file_realname;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setFile_job_id(Long file_job_id) {
        this.file_job_id = file_job_id;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    public void setFile_route(String file_route) {
        this.file_route = file_route;
    }

    public Long getFile_id() {
        return file_id;
    }

    public String getFile_realname() {
        return file_realname;
    }

    public String getFile_name() {
        return file_name;
    }

    public Long getFile_job_id() {
        return file_job_id;
    }

    public String getFile_size() {
        return file_size;
    }

    public String getFile_route() {
        return file_route;
    }
}
