package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.CreateModelRequest;
import kodlama.io.rentACar.business.response.GetAllModelResponse;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ModelService {

    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest createmodelRequest);

}
