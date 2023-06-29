package com.ladera.utcl.service.impl;

import com.ladera.utcl.mapper.TruckMapper;
import com.ladera.utcl.model.TruckModel;
import com.ladera.utcl.repository.TruckRepository;
import com.ladera.utcl.service.TruckService;
import com.ladera.utcl.vo.TruckVo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TruckServiceImpl implements TruckService {

    private TruckRepository truckRepository;
    private TruckMapper truckMapper;

    @Override
    public TruckVo addTruck( TruckVo truckVo) {
        TruckModel truckModel = truckMapper.mapToTruck(truckVo);
        TruckModel savedTruck = truckRepository.save(truckModel);
        TruckVo savedTruckVo = truckMapper.mapToTruckVo(savedTruck);
        return savedTruckVo;
    }
}
