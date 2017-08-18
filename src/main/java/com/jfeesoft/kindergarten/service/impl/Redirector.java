package com.jfeesoft.kindergarten.service.impl;

import org.springframework.stereotype.Service;

import javax.faces.context.FacesContext;
import java.io.IOException;

@Service
public class Redirector {

    public void redirect(String uri) throws IOException {
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect(uri);
    }

}
