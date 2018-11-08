package sia.knights;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import sia.knights.Knight;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=KnightConfig.class,loader=AnnotationConfigContextLoader.class)
/*
You can optionally use @ContextConfiguration to declare the ContextLoader strategy as well.
 Note, however, that you typically do not need to explicitly configure the loader,
  since the default loader supports initializers and either resource locations or
  annotated classes.
 */
/*
If you omit the classes attribute from the @ContextConfiguration annotation,
the TestContext framework tries to detect the presence of default configuration classes.
Specifically, AnnotationConfigContextLoader and AnnotationConfigWebContextLoader detect
all static nested classes of the test class that meet the requirements for configuration class
implementations, as specified in the @Configuration javadoc.
Note that the name of the configuration class is arbitrary. In addition,
a test class can contain more than one static nested configuration class if desired.
In the following example, the OrderServiceTest class declares a static nested configuration class
named Config that is automatically used to load the ApplicationContext for the test class
 */
public class KnightJavaConfigInjectionTest {

  @Autowired
  Knight knight;
  
  @Autowired
  FakePrintStream printStream;

  @After
  public void clearPrintStream() {
    printStream.clear();
  }

  @Test
  public void shouldInjectKnightWithSlayDragonQuest() {
    knight.embarkOnQuest();
    assertEquals(
        "Embarking on quest to slay the dragon!\n", 
        printStream.getPrintedString());
  }

}
