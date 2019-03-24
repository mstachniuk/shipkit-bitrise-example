package com.github.mstachniuk.shipkitbitriseexample;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeApiTest {

    @Test
    public void shouldReturnTrue() {
        SomeApi someApi = new SomeApi();
        assertEquals(true, someApi.isTrue());
    }
}
