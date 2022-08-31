package com.fpr.persistence;

import com.fpr.domain.SavingsProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingsRepository extends JpaRepository<SavingsProduct, Long> {

    //Member recommend(Integer age, String job);

    List<SavingsProduct> findBykorCoNm(String korCoNm);
}
