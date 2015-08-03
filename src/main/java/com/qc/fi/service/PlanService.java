package com.qc.fi.service;

import com.qc.fi.dao.PlanDao;
import com.qc.fi.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PlanService {
    @Autowired
    private PlanDao planDao;

    public Plan findOne(long id) {
        return planDao.findOne(id);
    }

    public List<Plan> findAll() {
        return planDao.findAll();
    }
    public void delete(long id) {
        planDao.delete(id);
    }

    public void save(Plan plan) {
        planDao.save(plan);
    }
    public void update(Plan plan) {
        planDao.update(plan);
    }


}
