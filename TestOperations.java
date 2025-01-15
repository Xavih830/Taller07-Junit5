import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas de la clase Operaciones")
public class TestOperations {
  
  public OperationsTest() {
  }
    
  @BeforeAll
  public static void setUpClass() {
  }
    
  @AfterAll
  public static void tearDownClass() {
  }
    
  @BeforeEach
  public void setUp() {
  }
    
  @AfterEach
  public void tearDown() {
  }

  @Test
  @DisplayName("Prueba del método MakeFormula")
  public void testMakeFormula() {
    System.out.println("MakeFormula");
    String expResult = "";
    String result = Operations.MakeFormula();
    assertEquals(expResult, result);    
    fail("The test case is a prototype.");
  } 

  @Test
  @DisplayName("Prueba del método Solve")
  public void testSolve() {
    System.out.println("Solve");
    String formula = "";
    String expResult = "";
    String result = Operations.Solve(formula);
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  @Test
  @DisplayName("Prueba de que formula cumpla con su manera de verse")
  public void testFormulaFormat(){
    String formula = MakeFormula();
    assertTrue(formula.matches("\\d+[\\+\\-\\*/]\\d+([\\+\\-\\*/]\\d+)?"));
  }

  @Test
  @DisplayName("Prueba de que formula cumpla con un resultado en el rango esperado")
  public void testFormulaNumberRange(){
    String formula = MakeFormula();
    String[] numbers = formula.split("[\\\\+\\\\-\\\\*/]");
    for(String number : numbers){
      int num = Integer.parseInt(number);
      assertTrue(num >= 1 && num <=99);
    }
  }

  @Test
  @DisplayName("Prueba de que formula cumpla con un número de operadores esperado")
  public void testFormulaOperatorCount(){
    String formula = MakeFormula();
    int operatorCount = formula.replaceAll("[^\\+\\-\\*/]", "").length();
    assertTrue(operatorCount == 1 || operatorCount == 2);
  }

  @Test
  @DisplayName("Prueba de que Solve cumpla con los estandares de suma")
  public void testSolveSum(){
    String result = Solve("10+10");
    assertEquals("10+10=20", result);
  }

  @Test
  @DisplayName("Prueba de que Solve cumpla con los estandares de resta")
  public void testSolveRes(){
    String result = Solve("10-10");
    assertEquals("10-10=0", result);
  }

  @Test
  @DisplayName("Prueba de que Solve cumpla con los estandares de multiplicación")
  public void testSolveMul(){
    String result = Solve("10*10");
    assertEquals("10*10=100", result);
  }

  @Test
  @DisplayName("Prueba de que Solve cumpla con los estandares de división")
  public void testSolveDiv(){
    String result = Solve("10/10");
    assertEquals("10/10=1", result);
  }

  @Test
  @DisplayName("Prueba de que Solve cumpla con los estandares de ")
}
