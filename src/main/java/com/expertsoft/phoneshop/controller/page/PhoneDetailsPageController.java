package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.service.PhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.expertsoft.phoneshop.PhoneShopConstants.PHONES_PATH;

@Controller
@RequestMapping(PHONES_PATH)
public class PhoneDetailsPageController {

    private static final String PHONE_DETAILS_PAGE = "phoneDetailsPage";

    private static final String PHONE_ATTRIBUTE = "phone";

    private static final String PHONE_ID = "phoneId";

    private final PhoneService phoneService;

    public PhoneDetailsPageController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping( "/{phoneId}")
    public String getPhoneDetails(
            @PathVariable(PHONE_ID) Long phoneId,
            Model model
    ) {
        model.addAttribute(PHONE_ATTRIBUTE, phoneService.getPhone(phoneId));

        return PHONE_DETAILS_PAGE;
    }
}
