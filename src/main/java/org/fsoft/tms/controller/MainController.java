package org.fsoft.tms.controller;
import org.fsoft.tms.entity.*;
import org.fsoft.tms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by thehaohcm on 5/18/17.
 */

@RestController
@RequestMapping(value="/tms")
public class MainController {

    @Autowired
    private TestTableRepository testTableRepository;

    @RequestMapping(value="/hello")
    public String getString(){
        return "HelloWorld";
    }

    @RequestMapping("/testtable")
    public List<TestTable> getListTestTable(){
        return testTableRepository.findAll();
    }

}
