package com.sistemi.informativi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public interface ErrorService {
    @Value("$(add.success.message)")
    String addSuccessMessage = "";
    @Value("$(add.error.message)")
    String addErrorMessage = "";
    @Value("$(delete.error.message)")
    String deleteErrorMessage = "";
    @Value("$(delete.success.message)")
    String deleteSuccessMessage = "";
    @Value("$(get.error.message")
    String getErrorMessage = "";
}
