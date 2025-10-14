package graphql;

import business.ModuleBusiness;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;

public class MutationModuleResolver implements GraphQLRootResolver {
    public ModuleBusiness helper;

    public MutationModuleResolver(){
        helper=new ModuleBusiness();
    }
    public boolean addModule(String matricule, String nom, int coefficient, int volumeHoraire, Module.TypeModule type) {
        Module md = new Module(matricule,nom,coefficient,volumeHoraire,type);
        return helper.addModule(md);
    }
    public boolean deleteModule(String matricule)
    {
        return helper.deleteModule(matricule);
    }
    public boolean updateModule(String matricule,String matricule2, String nom, int coefficient, int volumeHoraire, Module.TypeModule type)
    {
        return helper.updateModule(matricule,new Module(matricule2,nom,coefficient,volumeHoraire,type));
    }


}
