package com.example.demo.web;

import com.example.demo.models.dto.CatalogShipDTO;
import com.example.demo.models.dto.ShipNameDTO;
import com.example.demo.services.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private ShipService shipService;

    public HomeController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<CatalogShipDTO> allShipsCatalog = this.shipService.getAllShipsCatalog();
        List<ShipNameDTO> userShips = this.shipService.getShipForCurrentUser();
        List<ShipNameDTO> enemyShips = this.shipService.getEnemyShips();

        model.addAttribute("allShips", allShipsCatalog);
        model.addAttribute("userShips", userShips);
        model.addAttribute("enemyShips", enemyShips);

        return "home";
    }
}
