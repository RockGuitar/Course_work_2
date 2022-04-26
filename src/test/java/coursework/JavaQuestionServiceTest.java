package coursework;

import coursework.controllers.Question;
import coursework.services_realisation.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    public JavaQuestionService out = new JavaQuestionService();
    public Question defaultQuestion = new Question("defaultQuestion", "defaultAnswer");
    public Question someQuestion = new Question("someQuestion", "someAnswer");

    @Test
    public void shouldThrowExceptionWhenTryingToAddExistingQuestion () {
        out.add(defaultQuestion);
        Assertions.assertThrows(RuntimeException.class, () -> out.add("defaultQuestion", "defaultAnswer"));
        Assertions.assertThrows(RuntimeException.class, () -> out.add(defaultQuestion));
    }

    @Test
    public void shouldThrowExceptionWhenTryingToRemoveNonexistentQuestion () {
        Assertions.assertThrows(RuntimeException.class, () -> out.remove(someQuestion));
    }
}
