package youtube.java.puzzle;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static youtube.java.puzzle.utils.ArchitectureConstants.DEFAULT_PACKAGE;
import static youtube.java.puzzle.utils.ArchitectureConstants.MODEL_PACKAGE;

@AnalyzeClasses(packages = DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
public class ModelRulesTest {
    @ArchTest
    static final ArchRule classesShouldAnnotatedWithEntity = classes()
            .that()
            .resideInAnyPackage( MODEL_PACKAGE )
            .should().beAnnotatedWith( Entity.class )
            .andShould().beAnnotatedWith( Table.class )
            .because( "Model classes should be annotated with @Entity & @Table." );

    @ArchTest
    static final ArchRule variableShouldAnnotatedWithColumn = fields()
            .that().areDeclaredInClassesThat()
            .resideInAnyPackage( MODEL_PACKAGE )
            .should().beAnnotatedWith( Column.class )
            .andShould().notBeFinal()
            .andShould().notBePublic()
            .andShould().notBeStatic()
            .because( "Variables should annotated with @Column" );

}
