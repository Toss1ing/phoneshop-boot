package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.config.properties.PaginationProperties;
import com.expertsoft.phoneshop.dto.SearchDto;
import com.expertsoft.phoneshop.service.PhoneService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import java.util.stream.Collectors;

import static com.expertsoft.phoneshop.PhoneShopConstants.PHONES_PATH;

@Controller
@RequestMapping(PHONES_PATH)
public class PhoneListPageController {

    private static final String PHONE_LIST_PAGE = "phoneListPage";

    private static final String PHONES_ATTRIBUTE = "phones";
    private static final String PLP_MAX_PAGES = "plpMaxPages";
    private static final String SEARCH_ATTRIBUTE = "searchDto";
    private static final String ERROR_MESSAGE_ATTRIBUTE = "errorMessage";

    private static final String ID_ATTRIBUTE = "id";

    private final PhoneService phoneService;
    private final PaginationProperties paginationProperties;

    public PhoneListPageController(
            PhoneService phoneService,
            PaginationProperties paginationProperties
    ) {
        this.phoneService = phoneService;
        this.paginationProperties = paginationProperties;
    }

    @GetMapping
    public String getPhoneList(
            Model model,
            @PageableDefault(
                    size=5,
                    sort=ID_ATTRIBUTE,
                    direction=Sort.Direction.ASC
            ) Pageable page,
            @Valid SearchDto searchDto,
            BindingResult bindingResult
    ) {

        model.addAttribute(SEARCH_ATTRIBUTE, searchDto);
        model.addAttribute(PLP_MAX_PAGES, paginationProperties.getPlpMaxPage());

        if(bindingResult.hasErrors()) {
            model.addAttribute(
                    ERROR_MESSAGE_ATTRIBUTE,
                    bindingResult.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining(", "))
            );
            return PHONE_LIST_PAGE;
        }

        model.addAttribute(
                PHONES_ATTRIBUTE,
                phoneService.getPhonesPage(page, searchDto)
        );

        return PHONE_LIST_PAGE;
    }
}
