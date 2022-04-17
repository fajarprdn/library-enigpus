package com.enigma.enigpusboot.service;

import java.sql.Date;

public interface ReturnService {
    void bookReturn(String borrowId, Date returnDate);
}
