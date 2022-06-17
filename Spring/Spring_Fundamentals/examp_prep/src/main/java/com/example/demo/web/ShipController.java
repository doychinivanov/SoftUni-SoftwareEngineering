package com.example.demo.web;

import com.example.demo.models.dto.CreateShipDTO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {

    @ModelAttribute("createShipDTO")
    public CreateShipDTO initRegistrationDto() {
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String getShips() {
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String createShip(@Valid CreateShipDTO createShipDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("createShipDTO", createShipDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.createShipDTO", bindingResult);

            return "redirect:/ships/add";
        }

        return "redirect:/home";
    }
}
