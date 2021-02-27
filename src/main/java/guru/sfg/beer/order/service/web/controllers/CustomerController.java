package guru.sfg.beer.order.service.web.controllers;

import guru.sfg.beer.order.service.services.CustomerService;
import guru.sfg.beer.order.service.web.model.CustomerPagedList;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_SIZE_NUMBER = 20;

    private CustomerService customerService;

    @GetMapping
    public CustomerPagedList listCustomers(@RequestParam(value = "pageNumber", required=false) Integer pageNumber,
                                           @RequestParam(value = "sizeNumber", required = false) Integer sizeNumber) {
        if (pageNumber == null ||  pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        if( sizeNumber == null || sizeNumber < 1) {
            sizeNumber = DEFAULT_SIZE_NUMBER;
        }

        return customerService.listCustomers(PageRequest.of(pageNumber, sizeNumber));

    }

}
