package ya.ws;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.stream.Stream;

@Path("numbers")
public class NumberResource {
    @GET
    public JsonArray numbers() {
        JsonArrayBuilder array = Json.createArrayBuilder();
        Stream<String> numberStream = Stream.generate(System::currentTimeMillis).map(String::valueOf).limit(10);
        numberStream.forEach(array::add);

        return array.build();
    }
}
