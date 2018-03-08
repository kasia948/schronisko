package com.schronisko.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DogsController {
    List<Dog> pieski ;

    public DogsController(){
        pieski = new ArrayList<>();
        pieski.add(new Dog(555L, "Sonia", "Pogodna sunia","http://polki.pl/foto/4_3_SMALL/dogoterapia-gdy-pies-jest-terapeuta-1559030.jpg" ));
        pieski.add(new Dog(444L,"Azor", "Żywiołowy dwulatek", "http://www.newsweek.pl/g/i.aspx/910/-512/newsweek/635697254369194089.jpg"));
        pieski.add(new Dog(333L, "Oskar", "Kochający dzieci weteran", "https://cowsierscipiszczy.pl/wp-content/uploads/2017/12/ile-zyje-pies.jpg"));
        pieski.add(new Dog(222L, "Czaruś", "Radosny szczeniak", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGv9P12KLCuFQO0-xZFaX9eQAm-jrHhdwk2DeXze5hwVZ96z0FWg"));
    }

    @RequestMapping("/dogs")
    public String dogs(Model model) {
        model.addAttribute("dogs", pieski);
        return "index"; //dokleja .html i połączy z templates/index.html
    }

    @GetMapping("/dog")
    public String pies(@RequestParam String id, Model model){
        for (Dog dog : pieski) {
            if(id.equals(dog.getName())){
                model.addAttribute(dog);
                break;
            }
        }
        return "dogDetails";
    }

    @GetMapping("/dodaj")
    private String addDogForm(Model model){
        model.addAttribute(new Dog());
        return "addDogForm"; //templates/addDogForm.html
    }

    @PostMapping("/addDog")
    public String addDog(@RequestBody Dog dog){
        pieski.add(dog);
        return "redirect:/dogs";
    }


//    @RequestMapping("/")
//    String main (){
//        return "/index.html";
//    }

    @RequestMapping("/azor")
    @ResponseBody
    public String printInfoAzor(){
        return "Opis Azora- Azorek to dwuletni piesek";
    }

    @RequestMapping("/bella")
    @ResponseBody
    public String printInfoBella(){
        return "Opis Belli";
    }

    @RequestMapping("/oskar")
    @ResponseBody
    public String printInfoOskar(){
        return "Opis Oskara- Oskarek to dwuletni piesek";
    }

}
