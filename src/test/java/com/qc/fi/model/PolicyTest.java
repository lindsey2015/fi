package com.qc.fi.model;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PolicyTest extends TestCase {
    @Test
    public static void writeJsonObject() {
        ObjectMapper mapper = new ObjectMapper();
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
        policy.setStatus("01");
        policy.setCreatedDate(new Date());
        policy.setUpdatedDate(new Date());
        policy.setUpdatedBy("test");


        try {
            mapper.writeValue(new File("d:/source/bx/fi/person.json"), policy);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}