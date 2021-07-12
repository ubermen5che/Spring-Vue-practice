package com.example.coinwiki.domain;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String board_code;
    private String subject;
    private String cont;
    private String type;
    private String filename;
    private String ori_filename;
    private int filesize;
    private Timestamp regDate;
    private Timestamp editDate;

    public Timestamp getEditDate() {
        return editDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", board_code='" + board_code + '\'' +
                ", subject='" + subject + '\'' +
                ", cont='" + cont + '\'' +
                ", type='" + type + '\'' +
                ", filename='" + filename + '\'' +
                ", ori_filename='" + ori_filename + '\'' +
                ", filesize=" + filesize +
                ", regDate=" + regDate +
                ", editDate=" + editDate +
                '}';
    }

    public void setEditDate(Timestamp editDate) {
        this.editDate = editDate;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getOri_filename() {
        return ori_filename;
    }

    public void setOri_filename(String ori_filename) {
        this.ori_filename = ori_filename;
    }

    public int getFilesize() {
        return filesize;
    }

    public void setFilesize(int filesize) {
        this.filesize = filesize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getBoard_code() {
        return board_code;
    }

    public void setBoard_code(String board_code) {
        this.board_code = board_code;
    }
}
