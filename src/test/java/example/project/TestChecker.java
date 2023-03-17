package example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import example.project.domain.Scenario;
import example.project.domain.SimulationResult;
import org.junit.jupiter.api.Test;

public class TestChecker {

    @Test
    public void testCheckCollisionViolations()
    {
        // setup
        Simulator simulator = new Simulator("dummy");
        Scenario scenario = new Scenario();

        // testing target
        Checker checker = new Checker(simulator);
        boolean isCollision = checker.checkCollisionViolations(scenario); // this invokes a null pointer exception due to the dummy simulator
        assertEquals(false, isCollision);
    }

    @Test
    public void testCheckCollisionViolationsUsingMockSolution()
    {
        // setup
        Scenario scenario = mock();
        Simulator simulator = mock();
        when(simulator.run(scenario)).thenReturn(new SimulationResult());

        // testing target
        Checker checker = new Checker(simulator);
        checker.checkCollisionViolations(scenario);

        // assertion
        verify(simulator, times(1)).run(scenario);
    }

}