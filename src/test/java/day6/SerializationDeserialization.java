package day6;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class SerializationDeserialization {

   @Test
    void PojoToJson() throws JsonProcessingException {

        Student stupojo=new Student();
        stupojo.setName("Suresh");
        stupojo.setPhone("1234567890");
        stupojo.setLocation("Bangalore");
        String coursearr[]={"java","selenium"};
        stupojo.setCoursesArr(coursearr);

        ObjectMapper objmapper=new ObjectMapper();

        String jsondata=objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
        System.out.println(jsondata);
    }

    @Test
    void JsonToPojo() throws JsonProcessingException {
        String jsondata="{\n" +
                "    \n" +
                "    \"name\": \"john\",\n" +
                "    \"location\": \"canada\",\n" +
                "    \"phone\": \"112346789\",\n" +
                "    \"coursesArr\": [\n" +
                "      \"restapi\",\n" +
                "      \"c++\"\n" +
                "    ]\n" +
                "  }";

        ObjectMapper objmap=new ObjectMapper();
        Student stupojo=objmap.readValue(jsondata,Student.class);
        System.out.println(stupojo.getName());
        System.out.println(stupojo.getLocation());
        System.out.println(stupojo.getPhone());
        System.out.println(stupojo.getCoursesArr()[0]);
        System.out.println(stupojo.getCoursesArr()[1]);
    }

}
