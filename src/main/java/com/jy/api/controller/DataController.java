package com.jy.api.controller;

import com.jy.api.entity.Data;
import com.jy.api.entity.request.AddDataRequest;
import com.jy.api.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController(value = "datas")
public class DataController {

    private DataRepository dataRepository;

    @Autowired
    public DataController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Data> findAllDatas() {
        return dataRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNewWebUser(@RequestBody AddDataRequest addDataRequest) {
        Data data = new Data();
        data.setTitle(addDataRequest.getTitle());
        data.setMessage(addDataRequest.getMessage());
        dataRepository.save(data);
    }

}
