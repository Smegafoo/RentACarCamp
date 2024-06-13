package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.request.CreateModelRequest;
import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetAllModelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAcces.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelResponse> getAll() {

        List<Model> models=modelRepository.findAll();

        List<GetAllModelResponse> modelResponses=models.stream().map(model -> this.modelMapperService.forResponse()
                .map(model,GetAllModelResponse.class)).collect(Collectors.toList());


        return modelResponses;
    }

    @Override
    public void add(CreateModelRequest createmodelRequest) {

        Model model = this.modelMapperService.forRequest().map(createmodelRequest,Model.class);

        this.modelRepository.save(model);

    }
}
