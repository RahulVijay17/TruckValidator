package com.ladera.utcl.mapper.impl;

import com.ladera.utcl.mapper.TruckMapper;
import com.ladera.utcl.model.TruckModel;
import com.ladera.utcl.vo.TruckVo;
import org.springframework.stereotype.Service;

@Service
public class TruckMapperImpl implements TruckMapper {
    @Override
    public TruckVo mapToTruckVo(TruckModel truckModel) {
        if (truckModel == null) {
            return null;
        } else {
            TruckVo truckVo = new TruckVo();
            truckVo.setTruckId(truckModel.getTruckId());
            truckVo.setTruckNumber(truckModel.getTruckNumber());
            return truckVo;
        }
    }

    @Override
    public TruckModel mapToTruck(TruckVo truckVo) {

        if (truckVo == null) {
            return null;
        } else {
            TruckModel truckModel = new TruckModel();
            truckModel.setTruckId(truckVo.getTruckId());
            truckModel.setTruckNumber(truckVo.getTruckNumber());
            return truckModel;
        }
    }
}
