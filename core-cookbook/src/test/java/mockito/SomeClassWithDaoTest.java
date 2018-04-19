package mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * 
 */
public class SomeClassWithDaoTest {

  // creating mocks
  // 1. annotation default return value
  @Mock
  MyDBDAO databaseMock;

  // 2. static default return value
  private MyDBDAO defaultDBMock = Mockito.mock(MyDBDAO.class);

  // 3. static smart return value
  private MyDBDAO smartDBMock = mock(MyDBDAO.class, Mockito.RETURNS_SMART_NULLS);

  private SomeClassWithDao testee;

  /**
   * @throws Exception exception
   */
  @Before
  public void setUp() throws Exception {

    MockitoAnnotations.initMocks(this);
    testee = new SomeClassWithDao(databaseMock);

    // when(smartDBMock.getMetaInfo().getConnectionStatus()).thenReturn("HELLOOOOOO");

  }

  /**
   * tests smart return values<br />
   * a null exception is thrown when mock methods are not stubbed correctly. specifying smart nulls helps to identify which mocks have not been stubbed
   */
  @Test(expected = Exception.class)
  public void testUpdate() {

    // when(smartDBMock.getMetaInfo()).thenReturn(new MetaInfo());
    // this mock method call returns a smart null, in other words gives a stack trace showing where the null was thrown
    smartDBMock.getMetaInfo().getConnectionStatus();

    // when(defaultDBMock.getMetaInfo()).thenReturn(new MetaInfo());
    // this mock returns default null for the method called since it was not stubbed
    defaultDBMock.getMetaInfo().getConnectionStatus();

  }

  /**
   * test verify - verifies that desired methods have been executed
   *
   */
  @Test
  public void testUpdateVerify() {

    // call a method
    Boolean check = testee.renewItem("* from testee");

    // test the return type
    assertFalse(check.booleanValue());

    // test that a sequence of methods/logic were called as intended
    Mockito.verify(databaseMock).update("* from testee");
    Mockito.verify(databaseMock).doSomeCheck();
    Mockito.verify(databaseMock).doSomeOtherCheck();

    // fails using the following verify because it was never called
    // Mockito.verify(databaseMock).query("* from u");
  }

  /**
   * // test with POJO - pass an object to mock without it being modified
   *
   */
  @Test
  public void testPersistPerson() {

    // arrange
    when(databaseMock.insert(any(Person.class))).thenReturn("7");
    Person p = new Person(); // do not mock POJOs
    p.setName("Max");

    // act
    testee.addItem(p);

    // assert
    assertEquals("7", p.getId());
    verify(databaseMock).insert(p); // check arguments on mocked service
  }

  /**
   * // test stub-mock
   *
   */
  @Test
  public void testQueryStubbing() {

    when(databaseMock.query("* from t")).thenReturn("Miguel");

    String check = testee.findItem("* from t");

    assertEquals("comparing returned result: ", "Miguel", check);

  }

  /**
   * // test spy
   *
   */
  @Test
  public void testGetItemFromListSpying() {

    // mock/spy class
    SomeClassWithDao c = spy(testee);

    Integer i = Integer.valueOf(5);
    doReturn("four").when(c).getItemFromList(i);

    // five doesn't exist in REAL accessed list
    String rslt = c.getItemFromList(i);

    assertEquals("checking spy result: ", "four", rslt);

  }

}
