package com.jsoft.reststore.test.services;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.repositories.jpa.ClientRepository;
import com.jsoft.reststore.service.ISecurityService;
import com.jsoft.reststore.service.impl.ClientService;
import com.jsoft.reststore.test.AbstractMockitoTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;

import static com.jsoft.reststore.test.ConverterHelperTest.buildClient;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

/**
 * Suite test class for ClientService
 *
 * @since 0.0.1
 * @author <a href="johnquirogac@gmail.com">John Quiroga</a>
 */
public class ClientServiceTest extends AbstractMockitoTest {

    private static final String ENCRYPTED_PASSWORD = "password";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ISecurityService securityService;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void testFindByUserAndPasswordOK() throws StoreApiException {
        when(securityService.encryptData(PASSWORD)).thenReturn(ENCRYPTED_PASSWORD);
        when(clientRepository.findByClientUserAndPassword(USER, ENCRYPTED_PASSWORD)).thenReturn(buildClient());

        Client client = clientService.findByUserAndPassword(USER, PASSWORD);

        assertEquals(client, buildClient());
    }

    @Test(expected = StoreApiException.class)
    public void testFindByUserAndPasswordFailOnEncrypt() throws StoreApiException {
        when(securityService.encryptData(PASSWORD)).thenThrow(new StoreApiException());
        clientService.findByUserAndPassword(USER, PASSWORD);
    }

    @Test
    public void testFindByUserAndPasswordNotFound() throws StoreApiException {
        when(securityService.encryptData(PASSWORD)).thenReturn(ENCRYPTED_PASSWORD);
        when(clientRepository.findByClientUserAndPassword(USER, ENCRYPTED_PASSWORD)).thenReturn(null);

        Client client =clientService.findByUserAndPassword(USER, PASSWORD);

        assertNull(client);
    }

    @Test
    public void testFindByEmailOk() throws StoreApiException {
        when(clientRepository.findByEmail(EMAIL)).thenReturn(buildClient());
        Client client =clientService.findByEmail(EMAIL);
        assertEquals(client, buildClient());
    }

    @Test
    public void testFindByEmailFail() throws StoreApiException {
        when(clientRepository.findByEmail(EMAIL)).thenReturn(null);
        Client client =clientService.findByEmail(EMAIL);
        assertNull(client);
    }

    @Test
    public void testFindByDocumentOk() throws StoreApiException {
        when(clientRepository.findByDocument(BigDecimal.TEN)).thenReturn(buildClient());
        Client client =clientService.findByDocument(BigDecimal.TEN);
        assertEquals(client, buildClient());
    }

    @Test
    public void testFindByDocumentFail() throws StoreApiException {
        when(clientRepository.findByDocument(BigDecimal.TEN)).thenReturn(null);
        Client client =clientService.findByDocument(BigDecimal.TEN);
        assertNull(client);
    }
}
