package com.fpr.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpr.domain.InstallmentSavingsProduct;
import com.fpr.dto.installment.InstallmentSavingsRequestDto;
import com.fpr.dto.installment.InstallmentSavingsResponseDto;
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
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InstallmentSavingsService {

    private final InstallmentSavingsRepository installmentSavingsRepository;

    public List<InstallmentSavingsProduct> list(){
        return installmentSavingsRepository.findAll();
    }

    public void apiSave() throws JsonProcessingException {


        HashMap<String, Object> result = new HashMap<>();

        try {
            RestTemplate rt = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);

            String url = "http://finlife.fss.or.kr/finlifeapi/savingProductsSearch.json";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url + "?" + "auth=41a94be07dfa9f03716566379d2d2371" + "&" + "topFinGrpNo=020000&pageNo=1").build();

            ResponseEntity<InstallmentSavingsResponseDto> responseEntity = rt.exchange(uri.toString(), HttpMethod.GET, entity, InstallmentSavingsResponseDto.class);
            HttpStatus statusCode = HttpStatus.valueOf(responseEntity.getStatusCodeValue());
            HttpHeaders header = responseEntity.getHeaders();
            InstallmentSavingsResponseDto body = responseEntity.getBody();

            InstallmentSavingsProduct installmentSavingsProduct = new InstallmentSavingsProduct();

            List<InstallmentSavingsRequestDto.OptionList> optionLists =  body.getResult().getOptionList();
            List<InstallmentSavingsRequestDto.BaseList> baseLists =  body.getResult().getBaseList();


            List<InstallmentSavingsProduct> products = (List<InstallmentSavingsProduct>) body.getResult().getBaseList()
                    .stream()
                    .map(InstallmentSavingsRequestDto.BaseList::toEntity)
                    .collect(Collectors.toList());

//            baseLists.forEach((bList -> {
//                installmentSavingsProduct.setDclsMonth(bList.getDclsMonth());
//                installmentSavingsProduct.setFinCoNo(bList.getFinCoNo());
//                installmentSavingsProduct.setFinPrdtCd(bList.getFinPrdtCd());
//                installmentSavingsProduct.setKorCoNm(bList.getKorCoNm());
//                installmentSavingsProduct.setFinPrdtNm(bList.getFinPrdtNm());
//                installmentSavingsProduct.setJoinWay(bList.getJoinWay());
//                installmentSavingsProduct.setMtrtInt(bList.getMtrtInt());
//                installmentSavingsProduct.setSpclCnd(bList.getSpclCnd());
//                installmentSavingsProduct.setJoinDeny(bList.getJoinDeny());
//                installmentSavingsProduct.setJoinMember(bList.getJoinMember());
//                installmentSavingsProduct.setEtcNote(bList.getEtcNote());
//                installmentSavingsProduct.setMaxLimit(bList.getMaxLimit());
//                installmentSavingsProduct.setDclsStrtDay(bList.getDclsStrtDay());
//                installmentSavingsProduct.setDclsEndDay(bList.getDclsEndDay());
//                installmentSavingsProduct.setFinCoSubmDay(bList.getFinCoSubmDay());
//            }));

            optionLists.forEach(oList -> {
                installmentSavingsProduct.setIntrRateType(oList.getIntrRateType());
                installmentSavingsProduct.setIntrRateTypeNm(oList.getIntrRateTypeNm());
                installmentSavingsProduct.setRsrvType(oList.getRsrvType());
                installmentSavingsProduct.setRsrvTypeNm(oList.getRsrvTypeNm());
                installmentSavingsProduct.setSaveTrm(oList.getSaveTrm());
                installmentSavingsProduct.setIntrRate(oList.getIntrRate());
                installmentSavingsProduct.setIntrRate2(oList.getIntrRate2());

            });



           // installmentSavingsRepository.saveAll(products);

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "excpetion오류");
            System.out.println(e.toString());
        }


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
