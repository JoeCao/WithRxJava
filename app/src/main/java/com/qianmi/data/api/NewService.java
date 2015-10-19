package com.qianmi.data.api;

import javax.inject.Inject;

/**
 * Created by caozupeng on 15/10/19.
 */
public class NewService {
    @Inject
    PriceChangeService priceChangeService;

    public void listPriceChanges() {
        priceChangeService.listPriceChanges().subscribe(ret -> System.out.println(ret));
    }
}
