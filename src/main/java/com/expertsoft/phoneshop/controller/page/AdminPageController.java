package com.expertsoft.phoneshop.controller.page;

import com.expertsoft.phoneshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.expertsoft.phoneshop.PhoneShopConstants.ADMIN_PATH;

@Controller
@RequestMapping(ADMIN_PATH)
public class AdminPageController {

    private static final String ADMIN_PAGE = "admin/adminPanelPage";

    private static final String USER_ATTRIBUTE = "users";

    private final UserService userService;

    public AdminPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAdminPage(Model model) {

        model.addAttribute(USER_ATTRIBUTE, userService.findAll());

        return ADMIN_PAGE;

    }

}
