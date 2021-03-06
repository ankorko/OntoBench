package de.linkvt.ontobench.features.classexpressions.restrictions.object.cardinality;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.springframework.stereotype.Component;

@Component
public class OwlObjectMaxCardinalityOwlLiteAnd2RlFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLObjectProperty property = featurePool.getExclusiveProperty(":objectMaxCardinalityProperty_LiteRL");
    OWLClass range = featurePool.getExclusiveClass(":ObjectMaxCardinalityRange_LiteRL");
    addToGenericDomainAndNewRange(property, range);

    OWLObjectMaxCardinality maxCardinality = factory.getOWLObjectMaxCardinality(1, property);

    addAxiomToOntology(factory.getOWLSubClassOfAxiom(range, maxCardinality));
  }

  @Override
  public String getName() {
    return "owl:maxCardinality";
  }

  @Override
  public String getCompliance() {
    return "OWL Lite & OWL 2 RL";
  }

  @Override
  public String getToken() {
    return "maxcardinalitylite2rl";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.OBJECT_PROPERTY_RESTRICTIONS;
  }
}
