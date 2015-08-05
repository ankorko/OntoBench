package de.linkvt.bachelor.features.ontology.rdfs;

import de.linkvt.bachelor.features.Feature;
import de.linkvt.bachelor.features.FeatureCategory;
import de.linkvt.bachelor.features.ontology.OntologyConstants;

import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RdfsCommentFeature extends Feature {

  @Autowired
  OntologyConstants ontologyConstants;

  @Override
  public void addToOntology() {
    OWLLiteral descriptionLiteral = factory.getOWLLiteral(ontologyConstants.getDescription());
    OWLAnnotation comment = factory.getOWLAnnotation(factory.getRDFSComment(), descriptionLiteral);

    addChangeToOntology(new AddOntologyAnnotation(ontology, comment));
  }

  @Override
  public String getName() {
    return "rdfs:comment";
  }

  @Override
  public String getToken() {
    return "rdfscomment";
  }

  @Override
  public FeatureCategory getCategory() {
    return FeatureCategory.ONTOLOGY;
  }
}