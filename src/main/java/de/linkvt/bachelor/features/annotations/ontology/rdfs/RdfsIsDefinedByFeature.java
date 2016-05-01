package de.linkvt.bachelor.features.annotations.ontology.rdfs;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.web.RequestInformation;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RdfsIsDefinedByFeature extends Feature {

  private static final String RDFS_IS_DEFINED_BY = "rdfs:isDefinedBy";

  @Autowired
  private RequestInformation requestInformation;

  @Override
  public void addToOntology() {
    OWLAnnotationProperty annotationProperty = factory.getOWLAnnotationProperty(RDFS_IS_DEFINED_BY, pm);
    OWLAnnotation annotation = factory.getOWLAnnotation(annotationProperty, IRI.create(requestInformation.getGeneratorIri()));

    addChangeToOntology(new AddOntologyAnnotation(ontology, annotation));
  }

  @Override
  public String getName() {
    return RDFS_IS_DEFINED_BY;
  }

  @Override
  public String getToken() {
    return "rdfsisdefinedby";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}