
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class ExerciseManagementTest {

    private ExerciseManagement management;

    @Before
    public void initialize() {
        management = new ExerciseManagement();
    }

    @Test
    public void exerciseListEmptyAtBeginnig() {
        assertEquals(0, management.exerciseList().size());
    }

    @Test
    public void addingExercisesGrowsListByOne() {
        management.add("escribir un nuevo test");
        assertEquals(1, management.exerciseList().size());
    }

    @Test
    public void addedExerciseIsInList() {
        String exercise = "nuevo test";
        management.add(exercise);
        assertTrue(management.exerciseList().contains(exercise));
    }

    @Test
    public void exerciseCanBeMarkedAsCompleted() {
        String exercise = "nuevo test";
        management.add(exercise);
        management.markAsCompleted(exercise);
        assertTrue(management.isCompleted(exercise));
    }

    @Test
    public void ifIsNotMarkedCompleteIsNotCompleted() {
        String exercise = "nuevo test";
        management.add(exercise);
        assertFalse(management.isCompleted(exercise));
    }
}
