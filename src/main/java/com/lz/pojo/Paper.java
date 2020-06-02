package com.lz.pojo;

/**
 * @ClassName Paper
 * @Description: TODO
 * @Author MAlone
 * @Date 2019/11/18
 * @Version V1.0
 **/
public class Paper {
    private long paperId;
    private String paperName;
    private int paperNum;
    private String paperDetail;

    public long getPaperId() {
        return paperId;
    }

    public void setPaperId(long paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public int getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(int paperNum) {
        this.paperNum = paperNum;
    }

    public String getPaperDetail() {
        return paperDetail;
    }

    public void setPaperDetail(String paperDetail) {
        this.paperDetail = paperDetail;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperId=" + paperId +
                ", paperName='" + paperName + '\'' +
                ", paperNum=" + paperNum +
                ", paperDetail='" + paperDetail + '\'' +
                '}';
    }
}
