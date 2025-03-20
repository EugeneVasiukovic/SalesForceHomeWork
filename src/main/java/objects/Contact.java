package objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contact {
    private String salutationType;
    private String contactFirstName;
    private String contactLastName;
    private String accountNameType;
    private String phone;

}