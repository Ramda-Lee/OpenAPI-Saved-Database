package com.fpr.service;

import com.fpr.domain.Product;
import com.fpr.dto.ProductRequestDto;
import com.fpr.dto.property.BaseList;
import com.fpr.dto.property.OptionList;
import com.fpr.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findProduct(){
        return productRepository.findAll();
    }

    public void apiSave( BaseList baseList, OptionList optionList) {

        Product product = new Product();

        product.setDcls_month(baseList.getDcls_month());
        product.setFin_co_no(baseList.getFin_co_no());
        product.setFin_prdt_cd(baseList.getFin_prdt_cd());
        product.setKor_co_nm(baseList.getKor_co_nm());
        product.setFin_prdt_nm(baseList.getFin_prdt_nm());
        product.setJoin_way(baseList.getJoin_way());
        product.setMtrt_int(baseList.getMtrt_int());
        product.setSpcl_cnd(baseList.getSpcl_cnd());
        product.setJoin_deny(baseList.getJoin_deny());
        product.setJoin_member(baseList.getJoin_member());
        product.setEtc_note(baseList.getEtc_note());
        product.setMax_limit(baseList.getMax_limit());
        product.setDcls_strt_day(baseList.getDcls_strt_day());
        product.setDcls_end_day(baseList.getDcls_end_day());
        product.setFin_co_subm_day(baseList.getFin_co_subm_day());

        product.setIntr_rate_type(optionList.getIntr_rate_type());
        product.setIntr_rate_type_nm(optionList.getIntr_rate_type_nm());
        product.setSave_trm(optionList.getSave_trm());
        product.setIntr_rate(optionList.getIntr_rate());
        product.setIntr_rate2(optionList.getIntr_rate2());

        productRepository.save(product);

    }

    public Optional findOne(Long productId) {
        return productRepository.findById(productId);
    }

    public void recommendProduct() {

    }

}
