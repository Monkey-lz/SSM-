package com.lz.dao;

import com.lz.pojo.Paper;

import java.util.List;

public interface IPaperDao {
    int addPaper(Paper paper);

    int deletePaperById(long id);

    int updatePaper(Paper paper);

    Paper queryById(long paperId);

    List<Paper> queryAllPaper();
}
