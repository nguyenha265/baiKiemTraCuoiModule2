package com.codegym.controller;

import com.codegym.model.ThanhPho;
import com.codegym.model.QuocGia;
import com.codegym.service.ThanhPhoService;
import com.codegym.service.QuocGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThanhPhoController {

    @Autowired
    private ThanhPhoService thanhPhoService;

    @Autowired
    private QuocGiaService userService;

    @ModelAttribute("quocGia")
    public Iterable<QuocGia> user() {
        return userService.findAll();
    }


    @GetMapping("/home")
    public ModelAndView thanhPhoFindAll() {
        Iterable<ThanhPho> thanhPho = thanhPhoService.findAll();
        ModelAndView modelAndView = new ModelAndView("/thanhPho/list");
        modelAndView.addObject("nhieuThanhPho", thanhPho);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createThanhPhoForm() {
        ModelAndView modelAndView = new ModelAndView("/thanhPho/create");
        modelAndView.addObject("thanhPho", new ThanhPho());
        return modelAndView;
    }

    @PostMapping("/create-thanhPho")
    public ModelAndView createThanhPho( @ModelAttribute("thanhPho") ThanhPho thanhPho) {
            thanhPhoService.save(thanhPho);
            ModelAndView modelAndView = new ModelAndView("/thanhPho/create");
            modelAndView.addObject("thanhPho", new ThanhPho());
            modelAndView.addObject("message", "Tạo mới Thành Công");
            return modelAndView;
    }

    @GetMapping("/view-thanhPho/{id}")
    public ModelAndView viewThanhPho(@PathVariable("id") Long id) {
        ThanhPho thanhPho = thanhPhoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/thanhPho/view");
        modelAndView.addObject("thanhPho", thanhPho);
        return modelAndView;
    }

    @GetMapping("/edit-thanhPho/{id}")
    public ModelAndView editThanhPhoform(@PathVariable("id") Long id) {
        ThanhPho thanhPho = thanhPhoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/thanhPho/edit");
        modelAndView.addObject("thanhPho", thanhPho);
        return modelAndView;
    }

    @PostMapping("edit-thanhPho")
    public ModelAndView editThanhPho(@ModelAttribute("thanhPho") ThanhPho thanhPho) {
        thanhPhoService.save(thanhPho);
        ModelAndView modelAndView = new ModelAndView("/thanhPho/edit");
        modelAndView.addObject("thanhPho", new ThanhPho());
        modelAndView.addObject("message", "Cập Nhật thông Tin thành Công");
        return modelAndView;
    }

    @GetMapping("/delete-thanhPho/{id}")
    public ModelAndView deleteThanhPho(@PathVariable("id") Long id) {
        ThanhPho thanhPho = thanhPhoService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/thanhPho/delete");
        modelAndView.addObject("thanhPho", thanhPho);
        return modelAndView;
    }

    @PostMapping("/remove-thanhPho")
    public ModelAndView deleteThanhPho(@ModelAttribute("thanhPho") ThanhPho thanhPho) {
        thanhPhoService.delete(thanhPho.getId());
        Iterable<ThanhPho> thanhPhos = thanhPhoService.findAll();
        ModelAndView modelAndView = new ModelAndView("/thanhPho/list");
        modelAndView.addObject("nhieuThanhPho", thanhPhos);
        modelAndView.addObject("message", "Bạn Đã Xóa Một Thành Phố");
        return modelAndView;
    }
}
