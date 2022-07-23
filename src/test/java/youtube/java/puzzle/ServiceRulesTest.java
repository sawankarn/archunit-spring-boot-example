package youtube.java.puzzle;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static youtube.java.puzzle.utils.ArchitectureConstants.*;

@AnalyzeClasses(packages = DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)

public class ServiceRulesTest {
    @ArchTest
    static final ArchRule component_annotation_is_not_allowed = classes()
            .that()
            .resideInAPackage(SERVICE_PACKAGE)
            .should().notBeAnnotatedWith( Component.class)
            .because(String.format("Component annotation is not allowed in %s", SERVICE_PACKAGE));

    @ArchTest
    static final ArchRule classes_should_be_annotated = classes()
            .that().resideInAPackage(SERVICE_PACKAGE).should()
            .beAnnotatedWith( Service.class)
            .because(String.format(ANNOTATED_EXPLANATION, SERVICE_SUFFIX, "@Service"));

    @ArchTest
    static final ArchRule fields_should_not_be_public = fields().that()
            .areDeclaredInClassesThat().resideInAPackage(SERVICE_PACKAGE)
            .should().notBePublic()
            .because(String.format("Public fields are not allowed in %s", SERVICE_PACKAGE));

    @ArchTest
    static final ArchRule class_name_should_postfix_repository = classes()
            .that().resideInAPackage(SERVICE_PACKAGE)
            .should().haveSimpleNameEndingWith( SERVICE_SUFFIX )
            .because( String.format("Service should be end with %s", SERVICE_SUFFIX) );

    @ArchTest
    static final ArchRule bean_methods_are_not_allowed = methods().that()
            .areDeclaredInClassesThat().resideInAPackage(SERVICE_PACKAGE)
            .should().notBeAnnotatedWith( Bean.class)
            .because(String.format("Bean methods are not allowed in %s", SERVICE_PACKAGE));
}
