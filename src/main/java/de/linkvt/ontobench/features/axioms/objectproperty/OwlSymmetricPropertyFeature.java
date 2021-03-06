package de.linkvt.ontobench.features.axioms.objectproperty;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlSymmetricPropertyFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":symmetricObjectProperty");
    OWLClass range = featurePool.getExclusiveClass(":SymmetricObjectPropertyRange");
    addToGenericDomainAndNewRange(property, range);

    OWLAxiom axiom = factory.getOWLSymmetricObjectPropertyAxiom(property);
    addAxiomToOntology(axiom);
  }

  @Override
  public String getName() {
    return "owl:SymmetricProperty";
  }

  @Override
  public String getToken() {
    return "symmetricprop";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTIES;
  }
}
