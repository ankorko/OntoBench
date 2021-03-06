package de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMinCardinalityFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectMinCardinalityProperty");
    OWLClass range = featurePool.getExclusiveClass(":ObjectMinCardinalityRange");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMinCardinality minCardinality = factory.getOWLObjectMinCardinality(2, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, minCardinality));
  }

  @Override
  public String getName() {
    return "owl:minCardinality";
  }

  @Override
  public String getToken() {
    return "mincardinality";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
