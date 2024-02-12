//package com.example.bilota.model;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class ABS {
//
//    if(products == null || products){
//        return null;
//    }
//    List<SimpleSoldProduct> simpleProductList = products.map(p-> new SimpleSoldProduct(p.getName(),p.getPrice())).collect(Collectors.toList());
//    BigDecimal totalPrice = products.map(e->{
//        Optional<BigDecimal> exchangeRate = exchangeService.rate(e.getCurrency());
//        BigDecimal rate = BigDecimal.valueOf(1);
//        if(exchangeRate.isPresent())
//            rate = exchangeRate.get();
//        return e.getPrice().multiply(rate);
//            })
//            .reduce(BigDecimal.ZERO,BigDecimal::add);
//    return new SoldProductAggregate(simpleProductList,totalPrice);
//}
