package uz.mybux.cash.connect;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import okhttp3.RequestBody;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@Tag(name="Запросы на внешний провайдера")
@RestController
@RequestMapping(value = "/api/v2/connect/")
@Validated
@Configuration
public class ConnectController {
    @Autowired
    public ConnectController(){

    }
    @Operation(security = @SecurityRequirement(name = "bearerAuth"),summary = "Поиск по инн")
    @GetMapping("search_bytin/{tin}")
    public ResponseEntity getSearchByTin(@PathVariable(name = "tin") Long tin){

        String json = "{\n" +
                "  \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"connect.check\",\n" +
                "    \"params\": {\n" +
                "        \"token\": \"93cfe20325841ace1f8fc5d5a7ff5076\",\n" +
                "        \"tin\": \""+tin+"\"\n" +
                "    }\n" +
                "}";

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()

                .build();
        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"), json);

        Request request = new Request.Builder().addHeader("Authorization","test")
                .url("https://desk.e-invoice.uz/app")
                .post(body)
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> map = mapper.readValue(response.body().string(), Map.class);
//            System.out.println(response.body().string());
            return new ResponseEntity(map,HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();

            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        // return new ResponseEntity(list, HttpStatus.OK);
    }
}
