package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.request.UpdateBrandRequest;
import kodlama.io.rentACar.business.response.GetAllBrandsResponse;
import kodlama.io.rentACar.business.response.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAcces.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public List<GetAllBrandsResponse> getAll(){
        List<Brand> brands=brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponses=brands.stream().map(brand->this.modelMapperService.forResponse().
                map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand=brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response=
                this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest){
        this.brandBusinessRules.checkIfBrandNameExist(createBrandRequest.getName());
        Brand brand= this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand =this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);

        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {

        this.brandRepository.deleteById(id);

    }
}
