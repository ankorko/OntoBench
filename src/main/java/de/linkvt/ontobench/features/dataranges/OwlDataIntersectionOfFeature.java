package de.linkvt.ontobench.features.dataranges;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;

import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.springframework.stereotype.Component;

@Component
public class OwlDataIntersectionOfFeature extends Feature {
  @Override
  public void addToOntology() {
    OWLDatatype d1 = factory.getOWLDatatype(":DatatypeIntersectionOf_Datatype1", pm);
    OWLDatatype d2 = factory.getOWLDatatype(":DatatypeIntersectionOf_Datatype2", pm);
    OWLDataIntersectionOf intersection = factory.getOWLDataIntersectionOf(d1, d2);

    OWLDataProperty property = factory.getOWLDataProperty(":datatypeIntersectionOfProperty", pm);
    addToGenericDomainAndNewRange(property, intersection);
  }

  @Override
  public String getName() {
    return "owl:intersectionOf";
  }

  @Override
  public String getToken() {
    return "intersectionofdata";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.DATA_RANGES;
  }
}
