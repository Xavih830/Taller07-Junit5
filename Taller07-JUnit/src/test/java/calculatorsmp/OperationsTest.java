/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculatorsmp;

import static calculatorsmp.Operations.MakeFormula;
import static calculatorsmp.Operations.Solve;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author andre
 */
public class OperationsTest {
    
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
  @DisplayName(" 01 Prueba del método MakeFormula")
  public void testMakeFormula() {
    System.out.println("MakeFormula");
    String expResult = "";
    String result = Operations.MakeFormula();
    assertEquals(expResult, result);    
    fail("The test case is a prototype.");
  }
  
   @DisplayName(" 02 Prueba del método Solve")
  public void testSolve() {
    System.out.println("Solve");
    String formula = "";
    String expResult = "";
    String result = Operations.Solve(formula);
    assertEquals(expResult, result);
    fail("The test case is a prototype.");
  }

  

  @Test
  @DisplayName(" 03 Prueba de que formula cumpla con su manera de verse")
  public void testFormulaFormat(){
    String formula = MakeFormula();
    assertTrue(formula.matches("\\d+[\\+\\-\\*/]\\d+([\\+\\-\\*/]\\d+)?"));
  }

@Test
@DisplayName("04 Prueba de que formula cumpla con un resultado en el rango esperado")
public void testFormulaNumberRange() {
    String formula = Operations.MakeFormula();
    String[] numbers = formula.split("[\\s+\\-\\*/]+");
    for (String number : numbers) {
        int num = Integer.parseInt(number.trim());
        assertTrue(num >= 1 && num <= 99);
    }
}


  @Test
  @DisplayName(" 05 Prueba de que formula cumpla con un número de operadores esperado")
  public void testFormulaOperatorCount(){
    String formula = MakeFormula();
    int operatorCount = formula.replaceAll("[^\\+\\-\\*/]", "").length();
    assertTrue(operatorCount == 1 || operatorCount == 2);
  }

  @Test
  @DisplayName(" 06 Prueba de que Solve cumpla con los estandares de suma")
  public void testSolveSum(){
    String result = Solve("10+10");
    assertEquals("10+10=20", result);
  }

  @Test
  @DisplayName(" 07 Prueba de que Solve cumpla con los estandares de resta")
  public void testSolveRes(){
    String result = Solve("10-10");
    assertEquals("10-10=0", result);
  }

  @Test
  @DisplayName(" 08 Prueba de que Solve cumpla con los estandares de multiplicación")
  public void testSolveMul(){
    String result = Solve("10*10");
    assertEquals("10*10=100", result);
  }

  @Test
  @DisplayName(" 09 Prueba de que Solve cumpla con los estandares de división")
  public void testSolveDiv(){
    String result = Solve("10/10");
    assertEquals("10/10=1", result);
  }

@Test
@DisplayName("10 Prueba de que Solve cumpla con la división para cero")
public void testSolveDivZero() {
    Exception exception = assertThrows(ArithmeticException.class, () -> {
        Operations.Solve("10/0");
    });
    assertEquals("Division by zero is not allowed.", exception.getMessage());
}

  @Test
  @DisplayName(" 11 Prueba de que Solve pueda ejecutar una operación con varios operadores")
  public void testSolveMulOperators(){
    String result = Solve("10*10/2");
    assertEquals("10*10/2=50", result);
  }
    
}
