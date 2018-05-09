package com.jsoft.reststore.controller;

import com.jsoft.reststore.model.Client;
import com.jsoft.reststore.model.common.ApiResponseCode;
import com.jsoft.reststore.model.common.StoreApiException;
import com.jsoft.reststore.model.converter.ClientConverter;
import com.jsoft.reststore.model.web.LoginResponse;
import com.jsoft.reststore.model.web.LoginView;
import com.jsoft.reststore.service.ILoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/login")
public class LoginController extends AbstractController {

    /**
     * The {@link LoginController} logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginView login) {
        LoginResponse apiResponse = new LoginResponse();
        ResponseEntity<LoginResponse> httpResponse = new ResponseEntity<>(apiResponse,
                HttpStatus.OK);

        try {
            Client client = loginService.login(login.getUser(), login.getPassword());
            apiResponse.setClient(ClientConverter.domainToWeb(client));
            apiResponse.setApiResponseCode(ApiResponseCode.LOGIN_SUCCESS);

        } catch (StoreApiException e) {

            logger.error("Login fail by user:{} and password: {}", login.getUser(), login.getPassword());
            handleException(e, apiResponse);
        }

        return httpResponse;
    }

    @Override
    Logger getLogger() {
        return logger;
    }
}
