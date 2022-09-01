package com.fpr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpr.domain.SavingsProduct;
import com.fpr.dto.savings.SavingsResponseDto;
import com.fpr.service.SavingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SavingsApiController {

    private final SavingsService savingsService;

    @GetMapping("/savingsproduct/list")
    public SavingsResponseDto findAll(Model model) {
        List<SavingsProduct> savingsProducts = savingsService.list();
        model.addAttribute("savingsProducts", savingsProducts);
        return new SavingsResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @GetMapping("/savingsapi")
    public SavingsResponseDto callAPI() throws JsonProcessingException {
        savingsService.savingsApiSave();
        return new SavingsResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/savingsproduct/detail")
    public SavingsResponseDto productDetail(Long sProductId, Model model) {
        model.addAttribute("savingsProducts", savingsService.findOne(sProductId));
        return new SavingsResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/savingsproduct/{id}")
    public SavingsResponseDto searchProduct(Model model, SavingsProduct savingsProduct) {
        model.addAttribute("searchProduct", savingsService.searchProduct(savingsProduct));
        return new SavingsResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
