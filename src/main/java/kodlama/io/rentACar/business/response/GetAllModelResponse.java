package kodlama.io.rentACar.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class GetAllModelResponse {
    private int id;
    private String name;
    private String brandName;
}
