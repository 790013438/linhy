package com.xy.ssm.model;

public class CHomFile {
    private Long file_id;
    private String file_realname;
    private String file_name;
    private Long file_hom_id;
    private Long file_user_id;
    private String file_size;
    private String file_route;
    private String file_type;

    public void setFile_id(Long file_id) {
        this.file_id = file_id;
    }

    public void setFile_realname(String file_realname) {
        this.file_realname = file_realname;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setFile_hom_id(Long file_hom_id) {
        this.file_hom_id = file_hom_id;
    }

    public void setFile_user_id(Long file_user_id) {
        this.file_user_id = file_user_id;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    public void setFile_route(String file_route) {
        this.file_route = file_route;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
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

    public Long getFile_hom_id() {
        return file_hom_id;
    }

    public Long getFile_user_id() {
        return file_user_id;
    }

    public String getFile_size() {
        return file_size;
    }

    public String getFile_route() {
        return file_route;
    }

    public String getFile_type() {
        return file_type;
    }
}
