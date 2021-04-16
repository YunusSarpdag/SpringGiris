package com.componenet;

import org.springframework.stereotype.Component;

@Component("testComponentBean")
public class TestComponent {
    private String nm;
    private int id;

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }
}
