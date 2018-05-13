package com.jsoft.reststore.service.impl;

import com.jsoft.reststore.model.Invoice;
import com.jsoft.reststore.repositories.jpa.InvoiceRepository;
import com.jsoft.reststore.service.IInvoiceService;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService extends AbstractService<InvoiceRepository, Invoice> implements IInvoiceService {
}
