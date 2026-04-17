package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("ds")
@Data
public class DiagnosticServices {
    @Value("${ds1.xrayRate}")
	private Float xrayPrice;
    @Value("${ds.bpRate}")
	private Float bpPrice;
    @Value("${ds.twoDRate}")
	private Float twoDechoPrice;
    @Value("${ds.diabeticTestRate}")
	private Float diabeticTestPrice;
    @Value("${ds.mriRate}")
	private Float mriPrice;
    @Value("${ds.ctscanRate}")
	private Float ctscanPrice;
}
