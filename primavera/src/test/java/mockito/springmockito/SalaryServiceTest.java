package mockito.springmockito;

import java.math.BigDecimal;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import jpa.springmockito.EmployeeDAO;

/**
 * Created by tk3sy on 28.09.2015 http://rdafbn.blogspot.ch/2014/01/testing-spring-components-with-mockito.html
 */
public class SalaryServiceTest {

  private static final long UserId = 123l;

  @InjectMocks
  private SalaryService salaryService;

  @Mock
  private EmployeeDAO employeeDAO;

  @Mock
  private TaxCalculator taxCalculator;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testMinimumSalary() {
    BigDecimal annualSalary = new BigDecimal(10000);
    Mockito.when(employeeDAO.getAnnualSalary(UserId)).thenReturn(annualSalary);
    Mockito.when(taxCalculator.calculateTaxes(annualSalary)).thenReturn(new BigDecimal(1000));
    BigDecimal actual = salaryService.getNetSalary(UserId);
    Assert.assertThat(actual.compareTo(new BigDecimal(10000)), Is.is(0));
  }

  @Test
  public void testMaximumSalary() {
    BigDecimal annualSalary = new BigDecimal(80000);
    Mockito.when(employeeDAO.getAnnualSalary(UserId)).thenReturn(annualSalary);
    Mockito.when(taxCalculator.calculateTaxes(annualSalary)).thenReturn(new BigDecimal(8000));
    BigDecimal actual = salaryService.getNetSalary(UserId);
    Assert.assertThat(actual.compareTo(new BigDecimal(72000)), Is.is(0));
  }
}