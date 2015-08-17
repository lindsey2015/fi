package com.qc.fi.service;

import com.qc.fi.dao.PolicyDao;
import com.qc.fi.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class PolicyService {
    @Autowired
    PolicyDao policyDao;

    public long add(Policy policy) {
        policy.setCreatedDate(new Date());
        policy.setUpdatedBy("test");
        policy.setUpdatedDate(new Date());
        return policyDao.save(policy);
    }

    public void delete(long id) {
        policyDao.delete(id);
    }

    public Policy findOne(long id) {
        return policyDao.findOne(id);
    }
}
