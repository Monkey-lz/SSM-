package com.lz.service.impl;

import com.lz.dao.IPaperDao;
import com.lz.pojo.Paper;
import com.lz.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PaperService
 * @Description: TODO
 * @Author MAlone
 * @Date 2019/11/18
 * @Version V1.0
 **/
@Service
public class PaperService implements IPaperService {

    @Autowired
    private IPaperDao paperDao;

    @Override
    public int addPaper(Paper paper) {
        return paperDao.addPaper(paper);
    }

    @Override
    public int deletePaperById(long id) {
        return paperDao.deletePaperById(id);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperDao.updatePaper(paper);
    }

    @Override
    public Paper queryById(long id) {
        return paperDao.queryById(id);
    }

    @Override
    public List<Paper> queryAllPaper() {
        return paperDao.queryAllPaper();
    }
}
