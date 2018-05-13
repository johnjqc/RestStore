package com.jsoft.reststore.test.services;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.IClientService;
import com.jsoft.reststore.service.impl.LoginService;
import com.jsoft.reststore.test.AbstractMockitoTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.jsoft.reststore.test.ConverterHelperTest.buildClient;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LoginServiceTest extends AbstractMockitoTest {

    @Mock
    private IClientService clientService;

    @InjectMocks
    private LoginService loginService;

    @Test
    public void loginTestOk() throws StoreApiException {

        when(clientService.findByUserAndPassword("user", "password")).thenReturn(buildClient());

        Client client = loginService.login("user", "password");

        assertEquals(client, buildClient());
    }

    @Test(expected = StoreApiException.class)
    public void loginTestFail() throws StoreApiException {

        when(clientService.findByUserAndPassword("user", "password")).thenReturn(null);
        loginService.login("user", "password");
    }

}

