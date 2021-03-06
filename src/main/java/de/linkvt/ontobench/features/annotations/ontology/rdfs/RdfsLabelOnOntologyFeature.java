package de.linkvt.ontobench.features.annotations.ontology.rdfs;

import de.linkvt.ontobench.features.Feature;
import de.linkvt.ontobench.features.FeatureCategory;
import de.linkvt.ontobench.features.annotations.ontology.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RdfsLabelOnOntologyFeature extends Feature {

  @Autowired
  OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLLiteral titleLiteral = factory.getOWLLiteral(ontologyConstants.getTitle());
    OWLAnnotation title = factory.getOWLAnnotation(factory.getRDFSLabel(), titleLiteral);

    addChangeToOntology(new AddOntologyAnnotation(ontology, title));
  }

  @Override
  public String getName() {
    return "rdfs:label";
  }

  @Override
  public String getClarification() {
    return "on Ontology";
  }

  @Override
  public String getToken() {
    return "rdfslabelontology";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ANNOTATIONS;
  }
}
