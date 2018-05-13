package com.jsoft.reststore.test.services;

import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.service.impl.SecurityService;
import com.jsoft.reststore.test.AbstractMockitoTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;

public class SecurityServiceTest extends AbstractMockitoTest {

    private static final String DATA_TO_ENCRYPT = "data";
    private static final String ENCRYPTED_DATA = "20f8a4edf70be9d4b00afbf34ab3460e";

    @InjectMocks
    private SecurityService securityService;

    @Before
    public void initTest() {
        ReflectionTestUtils.setField(securityService, "salt", "saltValue");
    }

    @Test
    public void testEncryptData() throws StoreApiException {

        String encrypted = securityService.encryptData(DATA_TO_ENCRYPT);
        assertEquals(ENCRYPTED_DATA, encrypted);
    }
}
