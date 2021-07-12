package com.example.coinwiki.domain;

import java.util.List;

public class PagingInfo {
    private int totalCount;
    private int totalPage;
    private int page;
    private int startPage;
    private int endPage;
    private int ipp;
    private List<Post> pl;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getIpp() {
        return ipp;
    }

    public void setIpp(int ipp) {
        this.ipp = ipp;
    }

    public List<Post> getPl() {
        return pl;
    }

    public void setPl(List<Post> pl) {
        this.pl = pl;
    }

    @Override
    public String toString() {
        return "PagingInfo{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", ipp=" + ipp +
                ", pl=" + pl +
                '}';
    }
}

