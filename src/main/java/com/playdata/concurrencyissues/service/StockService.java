package com.playdata.concurrencyissues.service;

import com.playdata.concurrencyissues.entity.Stock;
import com.playdata.concurrencyissues.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    // 주문이 들어오면 재고를 감소시키는 메서드
    // synchronized: 한 개의 스레드만 접근이 가능하도록 제어하는 자바의 키워드
    public synchronized void decrease(Long id, Long quantity) {
        // Stock 조회
        Stock stock = stockRepository.findById(id).orElseThrow();

        // 재고 감소
        stock.decrease(quantity);

        // 재고 수정된 값을 저장
        stockRepository.save(stock);

    }

}

















