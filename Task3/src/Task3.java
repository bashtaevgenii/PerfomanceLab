import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Task3 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Values values_tests = mapper.readValue(reader, Values.class);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[1]));
        Tests tests = mapper.readValue(bufferedReader, Tests.class);
        for (int i = 0; i < tests.getTests().size(); i++) {
            tests.tests.set(i, writeValue(tests.getTests().get(i), values_tests));
        }

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File("report.json"), tests);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static Test writeValue(Test test, Values values) {
        int id, indx = -1;
        for (int i = 0; i < values.values.size(); i++) {
            id = values.values.get(i).id;
            if (id == test.id) {
                indx = i;
                break;
            }
        }
        if (indx != -1) {
            test.setValue(values.values.get(indx).getValue());
        }
        if (test.values != null)
            for (int i = 0; i < test.values.size(); i++) {
                test.values.set(i, writeValue(test.values.get(i), values));
            }

        return test;
    }

}

@JsonAutoDetect
class Tests {
    List<Test> tests;

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_EMPTY)
class Test {
    public int id;
    public String title;
    public String value;

    public List<Test> values;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Test> getValues() {
        return values;
    }

    public void setValues(List<Test> values) {
        this.values = values;
    }
}

@JsonAutoDetect
class Value {
    public int id;
    public String value;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

@JsonAutoDetect
class Values {
    List<Value> values;

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

}