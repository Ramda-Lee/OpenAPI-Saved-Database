package com.fpr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpr.domain.InstallmentSavingsProduct;
import com.fpr.dto.InstallmentSavingsResponseDto;
import com.fpr.service.InstallmentSavingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstallmentSavingsApiController {

    private final InstallmentSavingsService installmentSavingsService;

    @GetMapping("/product/list")
    public InstallmentSavingsResponseDto findAll(Model model) {
        List<InstallmentSavingsProduct> installmentsavingsProducts = installmentSavingsService.list();
        model.addAttribute("installmentsavingsProducts", installmentsavingsProducts);
        return new InstallmentSavingsResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @GetMapping("/api")
    public InstallmentSavingsResponseDto callAPI(InstallmentSavingsProduct installmentsavingsProducts) throws JsonProcessingException {
        installmentSavingsService.apiSave(installmentsavingsProducts);
        return new InstallmentSavingsResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/product/detail")
    public InstallmentSavingsResponseDto productDetail(Long isproductId, Model model) {
        model.addAttribute("installmentsavingsProducts", installmentSavingsService.findOne(isproductId));
        return new InstallmentSavingsResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/product/{id}")
    public InstallmentSavingsResponseDto searchProduct(Model model, InstallmentSavingsProduct installmentsavingsProducts) {
        model.addAttribute("installmentsavingsProducts", installmentSavingsService.searchProduct(installmentsavingsProducts));
        return new InstallmentSavingsResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
