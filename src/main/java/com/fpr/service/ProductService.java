package com.fpr.service;

import com.fpr.domain.Member;
import com.fpr.domain.SavingsProduct;
import com.fpr.dto.property.SavingsBaseList;
import com.fpr.dto.property.SavingsOptionList;
import com.fpr.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<SavingsProduct> list(){
        return productRepository.findAll();
    }

    public void apiSave(SavingsBaseList savingsBaseList, SavingsOptionList savingsOptionList) {

        SavingsProduct savingsProduct = new SavingsProduct();

        savingsProduct.setDcls_month(savingsBaseList.getDcls_month());
        savingsProduct.setFin_co_no(savingsBaseList.getFin_co_no());
        savingsProduct.setFin_prdt_cd(savingsBaseList.getFin_prdt_cd());
        savingsProduct.setKor_co_nm(savingsBaseList.getKor_co_nm());
        savingsProduct.setFin_prdt_nm(savingsBaseList.getFin_prdt_nm());
        savingsProduct.setJoin_way(savingsBaseList.getJoin_way());
        savingsProduct.setMtrt_int(savingsBaseList.getMtrt_int());
        savingsProduct.setSpcl_cnd(savingsBaseList.getSpcl_cnd());
        savingsProduct.setJoin_deny(savingsBaseList.getJoin_deny());
        savingsProduct.setJoin_member(savingsBaseList.getJoin_member());
        savingsProduct.setEtc_note(savingsBaseList.getEtc_note());
        savingsProduct.setMax_limit(savingsBaseList.getMax_limit());
        savingsProduct.setDcls_strt_day(savingsBaseList.getDcls_strt_day());
        savingsProduct.setDcls_end_day(savingsBaseList.getDcls_end_day());
        savingsProduct.setFin_co_subm_day(savingsBaseList.getFin_co_subm_day());

        savingsProduct.setIntr_rate_type(savingsOptionList.getIntr_rate_type());
        savingsProduct.setIntr_rate_type_nm(savingsOptionList.getIntr_rate_type_nm());
        savingsProduct.setSave_trm(savingsOptionList.getSave_trm());
        savingsProduct.setIntr_rate(savingsOptionList.getIntr_rate());
        savingsProduct.setIntr_rate2(savingsOptionList.getIntr_rate2());

        productRepository.save(savingsProduct);

    }

    @Transactional(readOnly = true)
    public SavingsProduct findOne(Long sproductId) {
        SavingsProduct savingsProduct = productRepository.findById(sproductId).orElseThrow(() -> {
            return new IllegalArgumentException("상세조회 실패 : 상품 정보를 찾을 수 없습니다");
        });
        return savingsProduct;
    }

    public void recommendProduct(Member member) {
        productRepository.recommend(member.getAge(), member.getJob());
    }

    public SavingsProduct searchProduct(SavingsProduct savingsProduct) {
        SavingsProduct search = productRepository.search(savingsProduct.getKor_co_nm());
        return search;
    }

}
