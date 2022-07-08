package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {

    @Test
    public void testEqaults(){
        EqualsVerifier.simple().forClass(Order.class).verify();
    }
    
}
