package com.hzh.doc.common.filter;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageFilter implements Serializable {

    private Integer offset;

    private Integer limit;

    public void setPage(int page, int pageSize) {
        if (page > 0 && pageSize > 0) {
            this.offset = (page - 1) * limit;
            this.limit = pageSize;
        }
    }
}
