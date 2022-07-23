package youtube.java.puzzle;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static youtube.java.puzzle.utils.ArchitectureConstants.*;

@AnalyzeClasses(packages = DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
public class RepositoryRulesTest {
    @ArchTest
    static final ArchRule classes_should_be_annotated = classes()
            .that().resideInAPackage(REPOSITORY_PACKAGE).should()
            .beAnnotatedWith( Repository.class)
            .because(String.format(ANNOTATED_EXPLANATION, REPOSITORY_SUFFIX, "@Repository"));

    @ArchTest
    static final ArchRule classesShouldBeInterfaces = classes().that()
            .resideInAPackage(REPOSITORY_PACKAGE)
            .should().beInterfaces()
            .because(String.format("Resources should be interfaces in %s", REPOSITORY_PACKAGE));

    @ArchTest
    static final ArchRule class_name_should_postfix_repository = classes()
            .that().resideInAPackage(REPOSITORY_PACKAGE)
            .should().haveSimpleNameEndingWith( REPOSITORY_SUFFIX )
            .because( String.format("Repository should be end with %s", REPOSITORY_SUFFIX) );
}
