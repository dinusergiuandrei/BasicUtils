package genericgeneticalgorithm.defaultimplementations.datastructure;


import genericgeneticalgorithm.geneticalgorithm.data_model.IndividualModel;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Generation;
import genericgeneticalgorithm.geneticalgorithm.data_structure.Individual;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DefaultGeneration implements Generation {
    private List<Individual> individuals = new ArrayList<>();

    private IndividualModel individualModel;

    public DefaultGeneration(IndividualModel individualModel) {
        this.individualModel = individualModel;
    }

    public IndividualModel getIndividualModel() {
        return individualModel;
    }

    public void addIndividual(Individual newIndividual){
        individuals.add(newIndividual);
    }

    public List<Individual> getIndividualsAsList() {
        return individuals;
    }

    @Override
    public Collection<Individual> getIndividuals() {
        return this.individuals;
    }

    @Override
    public Boolean isValid() {
        for (Individual individual : this.individuals) {
            if(!individual.isValid())
                return false;
        }
        return true;
    }
}
