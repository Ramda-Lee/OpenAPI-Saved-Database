package com.fpr.persistence;

import com.fpr.domain.InstallmentSavingsProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstallmentSavingsRepository extends JpaRepository<InstallmentSavingsProduct, Long> {

    //Member recommend(Integer age, String job);

    List<InstallmentSavingsProduct> findBykorCoNm(String KorCoNm);
}
