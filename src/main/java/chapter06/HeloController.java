package chapter06;

import chapter06.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class HeloController {

    @PostConstruct
    public void init() {
        MyData d1 = new MyData();
        d1.setName("kim");
        d1.setAge(123);
        d1.setMail("kim@gilbut.co.kr");
        d1.setMemo("090-999-999");
        repository.saveAndFlush(d1);

        MyData d2 = new MyData();
        d2.setName("lee");
        d2.setAge(15);
        d2.setMail("lee@flower");
        d2.setMemo("080-888-888");
        repository.saveAndFlush(d2);

        MyData d3 = new MyData();
        d3.setName("choi");
        d3.setAge(37);
        d3.setMail("choi@happy");
        d3.setMemo("070-777-777");
        repository.saveAndFlush(d3);
    }

    @Autowired
    MyDataRepository repository;

    @RequestMapping(value = "/index09", method = RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("formModel") MyData mydata,
                              ModelAndView mav) {
        mav.setViewName("index09");
        mav.addObject("title", "this is sample content.");
        mav.addObject("formModel", mydata);
        Iterable<MyData> list = repository.findAll();
        mav.addObject("datalist", list);
        return mav;
    }

    @RequestMapping(value = "/index09", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView form(
            @ModelAttribute("formModel") @Validated MyData mydata,
            BindingResult result,
            ModelAndView mav) {
        ModelAndView res = null;

        if(!result.hasErrors()) {
            repository.saveAndFlush(mydata);
            res = new ModelAndView("redirect:/index09");
        } else {
            mav.setViewName("index09");
            mav.addObject("msg", "sorry, error is occured ...");
            Iterable<MyData> list = repository.findAll();
            mav.addObject("datalist", list);
            res = mav;
        }

        return res;
    }
}
