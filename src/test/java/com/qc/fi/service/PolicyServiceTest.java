package com.qc.fi.service;

import com.qc.fi.model.*;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring-mvc.xml",
        "file:src/main/resources/spring.xml" })
@ActiveProfiles("test")
@Transactional
public class PolicyServiceTest extends TestCase {
    @Autowired
    PolicyService policyService;

    @Test
    public void testSave() {
        Policy policy = new Policy();
        User user = new User();
        user.setId(2);
        policy.setUser(user);

        Plan plan = new Plan();
        plan.setId(1);
        policy.setPlan(plan);

        policy.setApplicantName("某物流公司");
        policy.setInsuredName("某公司");
        policy.setFreightName("test freight");
        policy.setFreightType(FreightType.NORMAL.getCode());
        policy.setPackageAndQuantity("1*3");
        policy.setPackageType(PackageType.BULK_OR_NUDE.getName());
        policy.setBillNo("12345678");
        policy.setInvoiceNo("2345678");
        policy.setContractNo("123");
        policy.setContainerNo("345");

        policy.setInvoiceAmt(12345.67);
        policy.setAddRate(0.1);
        policy.setAmount(12345.67 * 1.1);
        policy.setAmtCurrency(Currency.CNY.getCode());
        policy.setAmtExchangeRate(6.5);
        policy.setChargeRate(0.1);
        policy.setPremium(1358.0);

        policy.setTransportType(TransportType.WATER.getCode());
        policy.setTrafficNo("");
        policy.setShipName("");
        policy.setExpressNo("");
        policy.setContainer(true);
        policy.setDepartureCountry(Country.CHINA.getCode());
        policy.setDepartureCity("Shanghai");
        policy.setDestinationCountry(Country.CHINA.getCode());
        policy.setDestinationCity("Xiamen");
        policy.setDepartureDate(new Date());

        policy.setSurveyAddrCode("01");
        policy.setNote("test");
        policy.setInternational(true);
        policy.setStatus("1");
        policy.setCreatedDate(new Date());
        policy.setUpdatedDate(new Date());
        policy.setUpdatedBy("test");

        long id = policyService.add(policy);
        assertTrue(id > 0);
    }
}