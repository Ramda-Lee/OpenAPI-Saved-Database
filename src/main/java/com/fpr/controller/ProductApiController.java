package com.fpr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpr.domain.SavingsProduct;
import com.fpr.dto.property.SavingsBaseList;
import com.fpr.dto.property.SavingsOptionList;
import com.fpr.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @PostMapping("/product/list")
    public String findAll(Model model) {
        List<SavingsProduct> savingsProducts = productService.list();
        model.addAttribute("savingsProducts", savingsProducts);
        return "product/productList";
    }

    @GetMapping("/api")
    public String callAPI(SavingsProduct savingsProduct, SavingsBaseList savingsBaseList, SavingsOptionList savingsOptionList) throws JsonProcessingException {

        HashMap<String, Object> result = new HashMap<>();

        String jsonInString = "";

        try {
            RestTemplate rt = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);

            String url = "http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json";

            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url + "?" + "auth=41a94be07dfa9f03716566379d2d2371" + "&" + "topFinGrpNo=020000&pageNo=1").build();

            ResponseEntity<Map> resultMap = rt.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result.put("statusCode", resultMap.getStatusCodeValue());
            result.put("header", resultMap.getHeaders());
            result.put("body", resultMap.getBody());


            LinkedHashMap bankResult = (LinkedHashMap) resultMap.getBody().get("result");
//            ArrayList<Map> baseList = (ArrayList<Map>)bankResult.get("baseList");
//            ArrayList<Map> optionList = (ArrayList<Map>)bankResult.get("optionList");
//            LinkedHashMap bnList = new LinkedHashMap<>();
//            for (Map obj : baseList) {
//                bnList.put(obj.get("baseList"),obj.get("optionList"));
//            }
//
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(bankResult);

            productService.apiSave(savingsBaseList, savingsOptionList);

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body", e.getStatusText());
            System.out.println(e.toString());

        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body", "excpetion오류");
            System.out.println(e.toString());
        }

        return jsonInString;

    }

    @PostMapping("/product/detail")
    public String productDetail(Long savingsProductsId, Model model) {
        model.addAttribute("savingsProducts", productService.findOne(savingsProductsId));
        return "product/detail";
    }

    @PostMapping("/product/{id}")
    public String searchProduct(Model model, SavingsProduct savingsProduct) {
        model.addAttribute("searchProduct", productService.searchProduct(savingsProduct));
        return "product/searchproduct";
    }
}
