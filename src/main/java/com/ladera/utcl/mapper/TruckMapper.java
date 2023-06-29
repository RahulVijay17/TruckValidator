package com.ladera.utcl.mapper;

import com.ladera.utcl.model.TruckModel;
import com.ladera.utcl.vo.TruckVo;

public interface TruckMapper {

    TruckVo mapToTruckVo(TruckModel truckModel);
    TruckModel mapToTruck(TruckVo truckVo);
}
