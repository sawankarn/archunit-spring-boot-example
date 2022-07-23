package youtube.java.puzzle;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static youtube.java.puzzle.utils.ArchitectureConstants.*;

@AnalyzeClasses(packages = DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
public class ControllerRulesTest {
    @ArchTest
    static final ArchRule classes_should_be_annotated = classes()
            .that().resideInAPackage(CONTROLLER_PACKAGE).should()
            .beAnnotatedWith( RestController.class)
            .andShould().notBeAnnotatedWith( Controller.class)
            .because(String.format(ANNOTATED_EXPLANATION, CONTROLLER_SUFFIX, "@RestController")  + ", and not with @Controller");

    @ArchTest
    static final ArchRule methods_should_return_response_entity = methods()
            .that().arePublic().and()
            .areDeclaredInClassesThat().resideInAPackage(CONTROLLER_PACKAGE).should()
            .haveRawReturnType( ResponseEntity.class)
            .because("Controller endpoints should return a ResponseEntity object");

    @ArchTest
    static final ArchRule methods_should_be_annotated_with_valid_annotations = methods()
            .that().arePublic().and()
            .areDeclaredInClassesThat().resideInAPackage(CONTROLLER_PACKAGE)
            .should().beAnnotatedWith( PostMapping.class)
            .orShould().beAnnotatedWith( GetMapping.class)
            .orShould().beAnnotatedWith( DeleteMapping.class)
            .orShould().beAnnotatedWith( PatchMapping.class)
            .orShould().beAnnotatedWith(PutMapping.class)
            .because("Controller methods should be annotated only with valid options of REST (POST, PUT, PATCH, GET, and DELETE)");
}
