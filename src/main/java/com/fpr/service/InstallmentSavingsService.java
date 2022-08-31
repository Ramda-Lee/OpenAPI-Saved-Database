package com.fpr.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpr.domain.InstallmentSavingsProduct;
import com.fpr.dto.InstallmentSavingsResponseDto;
import com.fpr.persistence.InstallmentSavingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InstallmentSavingsService {

    private final InstallmentSavingsRepository installmentSavingsRepository;

    public List<InstallmentSavingsProduct> list(){
        return installmentSavingsRepository.findAll();
    }

    public void apiSave(InstallmentSavingsProduct installmentSavingsProduct) throws JsonProcessingException {

        HashMap<String, Object> result = new HashMap<>();

        try {
            RestTemplate rt = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);

            String url = "http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url + "?" + "auth=41a94be07dfa9f03716566379d2d2371" + "&" + "topFinGrpNo=020000&pageNo=1").build();

            ResponseEntity<InstallmentSavingsProduct> responseEntity = rt.exchange(uri.toString(), HttpMethod.GET, entity, InstallmentSavingsProduct.class);
            HttpStatus statusCode = HttpStatus.valueOf(responseEntity.getStatusCodeValue());
            HttpHeaders header = responseEntity.getHeaders();
            InstallmentSavingsProduct body = responseEntity.getBody();


        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "excpetion오류");
            System.out.println(e.toString());
        }

        installmentSavingsRepository.save(installmentSavingsProduct);

    }

    @Transactional(readOnly = true)
    public InstallmentSavingsProduct findOne(Long isproductId) {
        Optional<InstallmentSavingsProduct> product = installmentSavingsRepository.findById(isproductId);
        return product.orElseGet(() -> new InstallmentSavingsProduct());
    }

//    public void recommendProduct(Member member) {
//        productRepository.recommend(member.getAge(), member.getJob());
//    }

    public List<InstallmentSavingsProduct> searchProduct(InstallmentSavingsProduct installmentSavingsProduct) {
        return installmentSavingsRepository.findBykorCoNm(installmentSavingsProduct.getKorCoNm());
    }

}
