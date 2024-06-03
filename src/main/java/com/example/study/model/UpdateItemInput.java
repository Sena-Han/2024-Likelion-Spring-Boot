package com.example.study.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateItemInput {
    @NotBlank(message = "상품 설명은 비워둘 수 없습니다.")
    private String itemDescription;

    @NotNull(message = "가격을 입력해야 합니다.")
    @Range(min = 100, max = 10000000, message = "가격은 100원에서 10,000,000원 사이여야 합니다.")
    private long itemPrice;
}
